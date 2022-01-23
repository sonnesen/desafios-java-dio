package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PreenchimentoDeVetorIII {
    
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        BigDecimal X = new BigDecimal(leitor.nextDouble());
        BigDecimal[] N = new BigDecimal[100];

        N[0] = X;

        for (int i = 1; i <= 99; i++) {
            N[i] = N[i-1].divide(new BigDecimal(2));    
        }

        DecimalFormat df = new DecimalFormat("0.0000");

        for (int i = 0; i < N.length; i++) {            
            System.out.println(String.format("N[" + i + "] = %s\n", df.format(N[i])));            
        }

        leitor.close();
    }
}
