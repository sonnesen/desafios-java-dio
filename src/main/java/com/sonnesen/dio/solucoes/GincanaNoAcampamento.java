package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.StringTokenizer;

public class GincanaNoAcampamento {

    public static void main(String[] args) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int quantidadeDeJogadores = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            do {
                CirculoDeJogadores jogadores = new CirculoDeJogadores();

                for (int i = 0; i < quantidadeDeJogadores; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    String nome = st.nextToken();
                    int valor = Integer.parseInt(st.nextToken());
                    jogadores.adicionarJogador(new Jogador(nome, valor));
                }

                Jogador vencedor = simular(jogadores);
                System.out.println("Vencedor(a): " + vencedor.nome);

                quantidadeDeJogadores = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            } while (quantidadeDeJogadores > 0);
        }

    }

    private static Jogador simular(CirculoDeJogadores jogadores) {
        Jogador jogador = jogadores.primeiro;
        int valor = jogador.valor;

        while (jogadores.totalDeJogadores > 1) {
            for (int i = 0; i < valor; i++) {
                jogador = jogadores.proximoJogadorDisponivel(jogador, valor);
            }
            jogadores.removerJogador(jogador);
            valor = jogador.valor;
        }

        return jogadores.buscaVencedor();
    }

}

class CirculoDeJogadores {

    Jogador primeiro;

    Jogador ultimo;

    int totalDeJogadores = 0;

    void adicionarJogador(Jogador novoJogador) {

        if (primeiro == null) {
            primeiro = novoJogador;
        }
        else {
            ultimo.proximo = novoJogador;
            novoJogador.anterior = ultimo;
        }

        ultimo = novoJogador;
        ultimo.proximo = primeiro;
        primeiro.anterior = ultimo;

        totalDeJogadores++;
    }

    public Jogador proximoJogadorDisponivel(Jogador jogador, int valor) {
        if (valor % 2 == 0) {
            jogador = jogador.anterior;
        }
        else {
            jogador = jogador.proximo;
        }

        if (jogador.estaForaDoJogo && totalDeJogadores > 1)
            return proximoJogadorDisponivel(jogador, valor);

        return jogador;
    }

    public void removerJogador(Jogador jogador) {
        jogador.estaForaDoJogo = true;
        totalDeJogadores--;
    }

    void listarJogadores() {
        Optional<Jogador> optional = Optional.ofNullable(primeiro);

        if (optional.isPresent()) {
            Jogador jogador = optional.get();
            do {
                System.out.println(jogador);
                jogador = jogador.proximo;
            } while (!jogador.equals(primeiro));
        }

    }

    Jogador buscaVencedor() {
        Optional<Jogador> optional = Optional.ofNullable(primeiro);

        if (optional.isPresent()) {
            Jogador jogador = optional.get();
            do {
                if (!jogador.estaForaDoJogo)
                    return jogador;
                jogador = jogador.proximo;
            } while (!jogador.equals(primeiro));
        }

        return null;
    }

}

class Jogador {
    String nome;

    int valor;

    Jogador proximo;

    Jogador anterior;

    boolean estaForaDoJogo = false;

    Jogador(String nome, int valor) {
        this.nome = nome;
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + valor;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jogador other = (Jogador) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        }
        else if (!nome.equals(other.nome))
            return false;
        if (valor != other.valor)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return anterior.nome + " " + anterior.valor + " | " +
                nome + " " + valor + " | " +
                proximo.nome + " " + proximo.valor;
    }
}