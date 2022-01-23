package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;

public class AnaliseNumeros {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        AtomicInteger pares = new AtomicInteger(0);
        AtomicInteger impares = new AtomicInteger(0);
        AtomicInteger positivos = new AtomicInteger(0);
        AtomicInteger negativos = new AtomicInteger(0);

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int valor = Integer.parseInt(st.nextToken());

            if (valor > 0)
                positivos.incrementAndGet();

            if (valor < 0)
                negativos.incrementAndGet();

            if (valor % 2 == 0)
                pares.incrementAndGet();
            else
                impares.incrementAndGet();

        }

        System.out.println(String.format(
                "%s par(es)\n" +
                "%s impar(es)\n" +
                "%s positivo(s)\n" +
                "%s negativo(s)",
                pares.get(), impares.get(), positivos.get(), negativos.get()));
    }
}
