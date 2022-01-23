package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ConjuntosBonsOuRuins {

    private static List<String> palavras;

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

            int n = 0;

            while ((n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken())) > 0) {
                palavras = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    String palavra = new StringTokenizer(br.readLine()).nextToken();
                    palavras.add(palavra);
                }

                palavras = palavras
                        .stream()
                        .sorted((p1, p2) -> p1.compareTo(p2))
                        .collect(Collectors.toList());
                
                boolean ehUmConjuntoRuim = false;
                
                for (int i = 0; i < palavras.size() - 1; i++) {
                    for (int j = i + 1; j <= palavras.size() - 1; j++) {
                        String p1 = palavras.get(i);
                        String p2 = palavras.get(j);
                        
                        if (p2.startsWith(p1)) {
                            ehUmConjuntoRuim = true;
                            break;
                        }
                    }
                }
                
                String resultado = ehUmConjuntoRuim ? "Conjunto Ruim" : "Conjunto Bom";
                bw.write("" + resultado + "\n");
            }
        }
    }
}
