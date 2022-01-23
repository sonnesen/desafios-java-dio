package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class UniformesDeFinalDeAno {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int quantidadeDeUniformes = Integer.parseInt(st.nextToken());

            if (quantidadeDeUniformes < 1 || quantidadeDeUniformes > 60)
                throw new RuntimeException(
                        String.format("Quantidade de uniformes inválida: %s. Favor informar um valor entre 1 e 60.",
                                quantidadeDeUniformes));

            List<Aluno> alunos = new ArrayList<>();

            for (int i = 0; i < quantidadeDeUniformes; i++) {
                String nome = br.readLine();
                StringTokenizer corTamanhoTokenizer = new StringTokenizer(br.readLine());
                String cor = corTamanhoTokenizer.nextToken().toLowerCase();
                String tamanho = corTamanhoTokenizer.nextToken().toUpperCase();

                Aluno aluno = new Aluno(nome, new Camisa(cor, Tamanho.valueOf(tamanho)));
                alunos.add(aluno);
            }

            alunos.sort(new Comparator<Aluno>() {

                @Override
                public int compare(Aluno o1, Aluno o2) {
                    int valor = o1.getCamisa().getCor().compareTo(o2.getCamisa().getCor());
                    
                    if (valor != 0) return valor;
                    
                    valor = o2.getCamisa().getTamanho().name().compareTo(o1.getCamisa().getTamanho().name());
                    
                    if (valor != 0) return valor;
                    
                    return o1.getNome().compareTo(o2.getNome());
                }
            });

            alunos.stream().forEach(System.out::println);

        }

    }

}

class Aluno {
    private String nome;

    private Camisa camisa;

    public Aluno(String nome, Camisa camisa) {
        this.nome = nome;
        this.camisa = camisa;
    }

    public String getNome() {
        return nome;
    }

    public Camisa getCamisa() {
        return camisa;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(camisa.cor)
                .append(" ")
                .append(camisa.tamanho)
                .append(" ")
                .append(nome);
        return builder.toString();
    }

}

class Camisa {
    String cor;

    Tamanho tamanho;

    public Camisa(String cor, Tamanho tamanho) {
        this.cor = cor;
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

}

enum Tamanho {
    P, M, G
}
