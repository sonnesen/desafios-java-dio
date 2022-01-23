package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TabuleiroSecreto {

    private int[][] tabuleiro;

    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream(new File("src/desafios/TabuleiroSecretoEntrada.txt"));
        OutputStream out = new FileOutputStream(new File("src/desafios/TabuleiroSecretoSaida.txt"));

        new TabuleiroSecreto().iniciar(in, out);
    }

    private void iniciar(InputStream in, OutputStream out) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {

            String[] parametrosDoJogo = br.readLine().split("\\s");

            int tamanhoDoTabuleiro = Integer.parseInt(parametrosDoJogo[0]);
            int quantidadeDeOperacoes = Integer.parseInt(parametrosDoJogo[1]);

            tabuleiro = new int[tamanhoDoTabuleiro][tamanhoDoTabuleiro];

            for (int i = 0; i < quantidadeDeOperacoes; i++) {
                String[] entradas = br.readLine().split("\\s");

                int tipoDaOperacao = Integer.parseInt(entradas[0]);
                int x = Integer.parseInt(entradas[1]);
                int r = -1;

                if (tipoDaOperacao == 1 || tipoDaOperacao == 2) {
                    r = Integer.parseInt(entradas[2]);
                }

                switch (tipoDaOperacao) {
                case 1:
                    atribuirValorParaLinha(r, x);
                    break;
                case 2:
                    atribuirValorParaColuna(r, x);
                    break;
                case 3:
                    mostrarValorMaisFrequenteDaLinha(x, bw);
                    break;
                case 4:
                    mostrarValorMaisFrequenteDaColuna(x, bw);
                    break;
                }

            }
        }
    }

    private void mostrarValorMaisFrequenteDaColuna(int coluna, BufferedWriter bw) throws IOException {
        Integer[] valores = Arrays.stream(tabuleiro).map(aux -> aux[coluna - 1]).toArray(Integer[]::new);
        mostrarMaisFrequente(bw, buscaMaisFrequente(valores));
    }

    private void mostrarMaisFrequente(BufferedWriter bw, int valor) throws IOException {
        bw.write("" + valor);
        bw.newLine();
    }

    private void mostrarValorMaisFrequenteDaLinha(int linha, BufferedWriter bw) throws IOException {
        Integer[] valores = Arrays.stream(tabuleiro[linha - 1]).boxed().toArray(Integer[]::new);
        mostrarMaisFrequente(bw, buscaMaisFrequente(valores));
    }

    private int buscaMaisFrequente(Integer[] valores) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < valores.length; j++) {

            int valor = valores[j];
            int frequencia = 0;

            if (map.containsKey(valor)) {
                frequencia = map.get(valor);
                frequencia++;
            }

            map.put(valor, frequencia);
        }

        Integer maiorFrequencia = map.values().stream().max((valor1, valor2) -> valor1 - valor2).orElse(0);

        Integer valorMaisFrequente = map.keySet().stream().filter(key -> map.get(key) == maiorFrequencia)
                .max((valor1, valor2) -> valor1 - valor2).orElse(0);
        
        return valorMaisFrequente;
    }

    private void atribuirValorParaColuna(int valor, int coluna) {
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[i][coluna - 1] = valor;
        }
    }

    private void atribuirValorParaLinha(int valor, int linha) {
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[linha - 1][i] = valor;
        }
    }

}
