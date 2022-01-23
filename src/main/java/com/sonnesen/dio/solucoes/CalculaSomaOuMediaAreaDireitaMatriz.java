package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

/* 
https://www.urionlinejudge.com.br/judge/pt/problems/view/1190 
*/
public class CalculaSomaOuMediaAreaDireitaMatriz {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double soma = 0;
        char O = leitor.next().toUpperCase().charAt(0);
        double[][] M = new double[12][12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                if (leitor.hasNextDouble()) {
                    double nextDouble = leitor.nextDouble();
                    System.out.println(nextDouble);
                    M[i][j] = nextDouble;
                }
            }
        }
        
        for (int i = 1; i <= 10; i++) {
            for (int j = 11, k = 1; k <= i && k <= 5 && i != j; j--, k++) {
                soma += M[i][j];
            }
        }

        if (O == 'M')
            soma /= 30.0;

        System.out.println(String.format("%.1f", soma));
        leitor.close();
    }

}