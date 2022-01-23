package com.sonnesen.dio.solucoes;
/*
Leia um valor inteiro N. Este valor será a quantidade de valores que serão lidos em seguida. Para cada valor 
lido, mostre uma mensagem em inglês dizendo se este valor lido é par (EVEN), ímpar (ODD), positivo (POSITIVE) 
ou negativo (NEGATIVE). No caso do valor ser igual a zero (0), embora a descrição correta seja (EVEN NULL), pois 
por definição zero é par, seu programa deverá imprimir apenas NULL.

Entrada

A primeira linha da entrada contém um valor inteiro N(N < 10000) que indica o número de casos de teste. 
Cada caso de teste a seguir é um valor inteiro X (-107 < X <107).
Saída

Para cada caso, imprima uma mensagem correspondente, de acordo com o exemplo abaixo. 
Todas as letras deverão ser maiúsculas e sempre deverá haver um espaço entre duas palavras impressas na mesma linha.
 
Exemplo de Entrada 	Exemplo de Saída

4					ODD NEGATIVE
-5					NULL
0					ODD POSITIVE
3					EVEN NEGATIVE
-4
*/

import java.util.Scanner;

public class ParOuImpar {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
    	int casosDeTeste = leitor.nextInt();
    	for (int i = 0; i < casosDeTeste; i++) {    		
    		int valor = leitor.nextInt();
    		String mensagem = calculaMensagem(valor);
    		System.out.println(mensagem);    		
    	}
    	leitor.close();
	}

	private static String calculaMensagem(int valor) {
		String mensagem = "NULL";
		
		if (valor > 0) {
			if (valor % 2 == 0)
				mensagem = "EVEN POSITIVE";
			else
				mensagem = "ODD POSITIVE";
		} else if (valor < 0) {
			if (valor % 2 == 0)
				mensagem = "EVEN NEGATIVE";
			else
				mensagem = "ODD NEGATIVE";
		}
		
		return mensagem;
	}
}
