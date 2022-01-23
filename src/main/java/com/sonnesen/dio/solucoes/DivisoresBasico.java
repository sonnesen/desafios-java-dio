package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;


/*
Ler um número inteiro N e calcular todos os seus divisores.

Entrada
O arquivo de entrada contém um valor inteiro.

Saída
Escreva todos os divisores positivos de N, um valor por linha.
 
Exemplo de Entrada 	Exemplo de Saída
6                   1
                    2
                    3
                    6
*/
public class DivisoresBasico {
    
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();
        for (int i = 1; i <= n; i++) {
        	if (n % i == 0) System.out.println(i);
        }
        leitor.close();
    }
}
