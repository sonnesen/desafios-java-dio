package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

public class SeisNumerosImpares {

    public static void main(String[] args) throws IOException {

        try (Scanner leitor = new Scanner(System.in)) {

            int x = leitor.nextInt();
            int counter = 0;

            while (counter < 6) {
                if (x % 2 != 0) {
                    System.out.println(x);
                    counter++;
                }
                x++;
            }

        }
    }
}
