package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1189
*/

public class CalculaSomaOuMediaAreaEsquerdaMatriz {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        double soma = 0;
        char O = leitor.next().toUpperCase().charAt(0);
        double[][] M = new double[12][12];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                M[i][j] = leitor.nextDouble();
            }
        }
  
        int k = 0, m = 4;

        for (int i = 1; i <= 10; i++) {
            if (i <= 5) {
                for (int j = 0; j <= k; j++) {
                    soma += M[i][j];                    
                }
                k++;
            } else {
                for (int j = 0; j <= m; j++) {                    
                    soma += M[i][j];
                }
                m--;
            }
        }
               
        if (O == 'M')
            soma /= 30.0;

        System.out.println(String.format("%.1f", soma));
        leitor.close();
    }

}