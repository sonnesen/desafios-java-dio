package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

public class MenorPosicao {

    public static void main(String[] args) throws IOException {
        
        try (Scanner leitor = new Scanner(System.in)) {
            
            int e = leitor.nextInt();
            
            int menorValor = Integer.MAX_VALUE;
            int posicao = -1;
            
            for (int i = 0; i < e; i++) {
                int valor = leitor.nextInt();
                if (valor < menorValor) {
                    menorValor = valor;
                    posicao = i;
                }
            }
            
            System.out.println(String.format("Menor valor: %s\nPosicao: %s", menorValor, posicao));
        }
    }
}
