package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/1188
*/
public class CalculaSomaOuMediaAreaInferiorMatriz {

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
  
        int k = 6, m = 5;

        for (int i = 7; i <= 11; i++) {
            for (int j = m; j <= k; j++) {
                soma += M[i][j];
            }
            k++;
            m--;
        }   

         if (O == 'M')
             soma /= 30.0;

        System.out.println(String.format("%.1f", soma));
        leitor.close();
    }

}