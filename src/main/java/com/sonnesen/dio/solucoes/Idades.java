package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

public class Idades {
    public static void main(String[] args) throws IOException {
        try (Scanner leitor = new Scanner(System.in)) {
            int cont = 0;
            int n = 0;
            double soma = 0;
            while (n >= 0) {
                n = leitor.nextInt();
                if (n >= 0) {
                    soma += n;
                    cont++;
                }
            }
            double media = soma / cont;
            System.out.println(String.format("%.2f", media));
        }
    }
}
