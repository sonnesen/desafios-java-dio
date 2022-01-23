package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
import java.util.Set;

public class EntrevistaEmbaracosa {

    public static void main(String[] args) throws IOException {
//        java.io.FileInputStream in = new java.io.FileInputStream(
//                new java.io.File("src/desafios/dadosEntrevistaEmbaracosa.txt"));
//        java.io.FileOutputStream out = new java.io.FileOutputStream(
//                new java.io.File("src/desafios/resultadoEntrevistaEmbaracosa.txt"));

        java.io.InputStream in = System.in;
        java.io.PrintStream out = System.out;

        iniciar(in, out);
    }

    private static void iniciar(InputStream in, OutputStream out) throws FileNotFoundException, IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {

            String linha = null;

            while (true) {
                linha = br.readLine();

                if (linha == null || "".equals(linha))
                    break;

                Set<String> palavras = new LinkedHashSet<>();

                String[] letras = linha.split("");

                for (int i = letras.length - 1, j = i - 1; i >= 0 && j >= 0; i--, j = j - 2) {
                    String s1 = linha.substring(i, linha.length());
                    String s2 = linha.substring(j, i);

                    if (s1.equals(s2)) {
                        String palavra = linha.substring(0, i);
                        palavras.add(palavra);
                    }
                }

                if (palavras.size() == 0) {
                    palavras.add(linha);
                }

                palavras
                    .stream()
                    .sorted((p1,p2) -> p1.length() - p2.length())
                    .forEach(palavra -> {
                    try {
                        bw.write("" + palavra + "\n");
                    }
                    catch (IOException e) {
                    }
                });
            }
        }
    }
}
