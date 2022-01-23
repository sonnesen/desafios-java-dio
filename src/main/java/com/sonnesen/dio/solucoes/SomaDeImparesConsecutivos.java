package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/* 
Leia 2 valores inteiros X e Y. A seguir, calcule e mostre a soma dos números impares entre eles.
Entrada

O arquivo de entrada contém dois valores inteiros.
Saída

O programa deve imprimir um valor inteiro. Este valor é a soma dos valores ímpares que estão entre os valores fornecidos na entrada que deverá caber em um inteiro.
 
Exemplo de Entrada 	Exemplo de Saída

6
-5					5

15
12					13

12
12					0
*/

public class SomaDeImparesConsecutivos {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			
			var x = sc.nextInt();
			var menor = x;
			var maior = x;
			
			var y = sc.nextInt();
			if (y < x) {
				menor = y;
			} else {
				maior = y;
			}
			
			var soma = 0;
			
			for (int i = menor + 1; i < maior; i++) {
				if (i % 2 == 0) continue;
				soma += i;
			}
				
			System.out.println(soma);
		}
	}
}
