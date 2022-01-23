package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.StringTokenizer;

public class ProdutoDivisao {

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

            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split("\\s");

                sb.append(tokens[1]).append(tokens[0]);
            }

            String[] tokens = sb.toString().split("");

            BigDecimal resultado = BigDecimal.ONE;

            for (int i = 0; i < tokens.length; i = i + 2) {
                String operador = tokens[i];
                String valor = tokens[i + 1];

                if ("*".equals(operador)) {
                    resultado = resultado.multiply(new BigDecimal(valor));
                }
                else {
                    resultado = resultado.divide(new BigDecimal(valor), 3, RoundingMode.CEILING);
                }
            }
            
            BigDecimal maxInt = new BigDecimal(Integer.MAX_VALUE);
            if (resultado.compareTo(maxInt) > 0) {
                bw.write("" + resultado + "\n");
            } else {
                bw.write("" + resultado.intValue() + "\n");
            }

        }
    }
}
