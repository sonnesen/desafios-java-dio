package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/* 
A fórmula de Binet é uma forma de calcular números de Fibonacci.

Sua tarefa é, dado um natural n, calcular o valor de Fibonacci(n) usando a fórmula acima.

Entrada

A entrada é um número natural n (0 < n ≤ 50).

Saída

A saída é o valor de Fibonacci(n) com 1 casa decimal utilizando a fórmula de Binet dada.
 
Exemplos de Entrada 	Exemplos de Saída

1						1.0
2						1.0
3						2.0

Prova 2 (D2) de Programação de Computadores 2016/1 da UNILA


*/

public class FibonacciRapido {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			var n = sc.nextInt();
			
			if (n < 0 || n > 50)
				throw new RuntimeException(String.format("Valor %s deve ser maior que 0 e menor ou igual a 50!", n));
			
			var a = Math.pow((1 + Math.sqrt(5))/2, n);
			var b = Math.pow((1 - Math.sqrt(5))/2, n);			
			var fibonacci = (a - b) / Math.sqrt(5);
			
			System.out.println(String.format("%.1f", fibonacci));
		}
	}
}
