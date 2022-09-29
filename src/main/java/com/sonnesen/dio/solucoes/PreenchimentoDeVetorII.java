package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PreenchimentoDeVetorII {
    
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int t = leitor.nextInt();
        int[] vetor = new int[9];
        int j = 0;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("N[" + i + "] = " + j);
            if (j == (t -1)){
                j = 0;
                continue;
            }
            j++;
        }

        leitor.close();
    }
}
