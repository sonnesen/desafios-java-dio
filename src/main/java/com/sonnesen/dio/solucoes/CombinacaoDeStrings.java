package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CombinacaoDeStrings {

    public static void main(String[] args) throws IOException {
        java.io.InputStream in = System.in;
        java.io.OutputStream out = System.out;

        new CombinacaoDeStrings().iniciar(in, out);
    }

    private void iniciar(InputStream in, OutputStream out) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {

            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            while (n > 0) {
                String[] sequencias = br.readLine().split("\\s");

                int tamanhoDaMenorSequencia = calculaMenorTamanho(sequencias);

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < tamanhoDaMenorSequencia; i++) {
                    sb.append(sequencias[0].charAt(i));
                    sb.append(sequencias[1].charAt(i));
                }

                if (sequenciasPossuemTamanhosDiferentes(sequencias)) {
                    String substring = maiorSequencia(sequencias).substring(tamanhoDaMenorSequencia);
                    sb.append(substring);
                }

                bw.write(sb.toString());
                bw.newLine();
                n--;
                
            }
        }

    }

    private boolean sequenciasPossuemTamanhosDiferentes(String[] sequencias) {
        return sequencias[0].length() != sequencias[1].length();
    }

    private String maiorSequencia(String[] sequencias) {
        if (sequencias[0].length() >= sequencias[1].length())
            return sequencias[0];
        else
            return sequencias[1];
    }

    private int calculaMenorTamanho(String[] sequencias) {
        if (sequencias[0].length() >= sequencias[1].length())
            return sequencias[1].length();
        else
            return sequencias[0].length();
    }
}
