package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class Diferenca {
    
    public static void main(String[] args) {
        try (Scanner leitor = new Scanner(System.in)) {
            int a = leitor.nextInt();
            int b = leitor.nextInt();
            int c = leitor.nextInt();
            int d = leitor.nextInt();

            int diferenca = (a * b - c * d);
            System.out.println(String.format("DIFERENCA = %s", diferenca));
        }
    }
}
