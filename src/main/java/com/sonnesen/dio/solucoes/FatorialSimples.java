package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/* 
Ler um valor N. Calcular e escrever seu respectivo fatorial. Fatorial de N = N * (N-1) * (N-2) * (N-3) * ... * 1.
Entrada

A entrada contém um valor inteiro N (0 < N < 13).
Saída

A saída contém um valor inteiro, correspondente ao fatorial de N.
 
Exemplo de Entrada 	Exemplo de Saída

4					24

Agradecimentos a Cassio F.

*/

public class FatorialSimples {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			var valor = sc.nextInt();
			
			if (valor < 0 || valor > 13)
				throw new RuntimeException(String.format("Valor %s deve ser maior que 0 e menor que 13!", valor));
			
			var fatorial = 1;
			
			for (var i = valor; i > 0; i--) {
				fatorial *= i;
			}
			
			System.out.println(fatorial);
		}
	}
}
