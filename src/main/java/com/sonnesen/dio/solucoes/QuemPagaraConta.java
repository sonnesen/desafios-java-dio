package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/*
* Em uma lanchonete, Ale e Juliana estão brigando por quem vai pagar a conta. Para dar um fim
* à discussão, a garçonete propõe um desafio e, quem tivesse mais acertos, não pagaria a conta.
* Ela lançou o seguinte desafio: dado a seguinte somatória abaixo, informe o resultado, com uma
* quantidade de termos no mesmo:
* S = 1 - 1 + 1 - 1 + 1 - 1 + 1 - 1 ...
*
* Agora é com você! Desenvolva um programa que, dada uma quantidade de termos, informe o resultado
* da somatória acima.
*
* Entrada
* Um número inteiro C será informado, que será a quantidade de casos de teste. Cada caso de teste inicia
* com um número inteiro N (1 ≤ N ≤ 1000), indicando a quantidade de termos da soma.
*
* Saída
* Para cada caso de teste imprima um número S, que é o resultado da soma dos N termos da expressão.
*
* Exemplo de Entrada 	Exemplo de Saída
* 3                     1
* 11                    1
* 7                     1
* 18                    0
*/
public class QuemPagaraConta {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        while (leitor.hasNext()) {
            Integer entrada = null;
            try {
                entrada = Integer.valueOf(leitor.nextInt());
            } catch (Throwable t) {
                break;
            }
            if (entrada % 2 == 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
}
