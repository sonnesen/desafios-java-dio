package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class JogoPedraPapelTesouraLagartoSpock {

    public static void main(String[] args) throws NumberFormatException, IOException {

        /*
         * Tesoura corta papel 
         * Papel cobre pedra 
         * Pedra derruba lagarto 
         * Lagarto adormece 
         * Spock Spock derrete tesoura
         * Tesoura prende lagarto 
         * Lagarto come papel 
         * Papel refuta Spock 
         * Spock vaporiza pedra 
         * Pedra quebra tesoura
         */
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int quantidadeDeCasosDeTeste = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            for (int i = 0; i < quantidadeDeCasosDeTeste; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Apostador fernanda = new Apostador("fernanda", Jogada.valueOf(st.nextToken().toUpperCase()));
                Apostador marcia = new Apostador("marcia", Jogada.valueOf(st.nextToken().toUpperCase()));
                System.out.println(Jogo.jogar(fernanda, marcia));
            }
        }
    }

}

class Jogo {

    public static String jogar(Apostador fernanda, Apostador marcia) {
        Jogada vencedora = Jogada.comparar(fernanda.jogada, marcia.jogada);

        if (vencedora.equals(Jogada.EMPATE))
            return Jogada.EMPATE.toString().toLowerCase();
        else if (vencedora.equals(fernanda.jogada))
            return fernanda.nome;
        else
            return marcia.nome;
    }
}

class Apostador {
    String nome;

    Jogada jogada;

    Apostador(String nome, Jogada jogada) {
        this.nome = nome;
        this.jogada = jogada;
    }
}

enum Jogada {

    TESOURA, PAPEL, PEDRA, LAGARTO, SPOCK, EMPATE;

    static final Map<Jogada, List<Jogada>> resultados = new EnumMap<>(Jogada.class);

    static {
        resultados.put(Jogada.TESOURA, Arrays.asList(PAPEL, LAGARTO));
        resultados.put(Jogada.PAPEL, Arrays.asList(PEDRA, SPOCK));
        resultados.put(Jogada.PEDRA, Arrays.asList(LAGARTO, TESOURA));
        resultados.put(Jogada.LAGARTO, Arrays.asList(SPOCK, PAPEL));
        resultados.put(Jogada.SPOCK, Arrays.asList(TESOURA, PEDRA));
    }

    static Jogada comparar(Jogada jogada1, Jogada jogada2) {
        if (jogada1.equals(jogada2))
            return EMPATE;
        else if (resultados.get(jogada1).contains(jogada2))
            return jogada1;
        else
            return jogada2;
    }

}