package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Divisores {

    public static void main(String[] args) throws IOException {
        iniciar();
    }

    private static void iniciar() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int n = -1;

            List<Integer> divisores = IntStream.rangeClosed(1, c)
                    .parallel()
                    .filter(valor -> c % valor == 0)
                    .boxed()
                    .sorted()
                    .collect(Collectors.toList());
            
            for (Integer divisor : divisores) {
                if (divisor % a == 0 && divisor % b != 0 &&
                        c % divisor == 0 && d % divisor != 0) {
                    n = divisor;
                    break;
                }
            }

            System.out.println(n);
        }
    }

}
