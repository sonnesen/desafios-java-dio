package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ContagemRepetidaDeNumeros {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;

        new ContagemRepetidaDeNumeros().inciar(in, out);
    }

    private void inciar(InputStream in, OutputStream out) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {

            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            Map<Integer, Integer> valores = new HashMap<>();

            while (n > 0) {
                int valor = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
                int frequencia = valores.getOrDefault(valor, 0);
                valores.put(valor, ++frequencia);
                n--;
            }

            valores.keySet().stream().sorted().forEach(valor -> {
                try {
                    bw.write(String.format("%s aparece %s vez(es)\n", valor, valores.get(valor)));
                }
                catch (IOException e) {
                }
            });

        }
    }
}
