package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class Resto2 {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int valor = leitor.nextInt();
        for (int i = 1; i < 10_000; i++) {
            if (i % valor == 2) {
                System.out.println(i);
            }
        }

        leitor.close();
    }
}
