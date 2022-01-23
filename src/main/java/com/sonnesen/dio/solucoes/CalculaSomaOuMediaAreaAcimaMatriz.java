package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class CalculaSomaOuMediaAreaAcimaMatriz {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        double soma = 0;
        char O = leitor.next().toUpperCase().charAt(0);
        double[][] M = new double[12][12];
        int aux = 0;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (leitor.hasNextDouble()) {
                    double nextDouble = leitor.nextDouble();
                    M[i][j] = nextDouble;
                }
            }
        }

        for (int i = 0; i <= 10; i++) {
            for (int j = 11; j > i; j--) {
                soma += M[i][j];
                aux++;
            }
        }

        if (O == 'M')
            soma /= aux;

        System.out.println(String.format("%.1f", soma));
        leitor.close();
    }
}
