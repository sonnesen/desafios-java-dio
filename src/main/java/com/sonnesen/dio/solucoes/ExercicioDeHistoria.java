package com.sonnesen.dio.solucoes;

/*
Mesmo pensando muito a respeito de como que os anos são encaixados na contagem de séculos, os alunos
ainda continuavam com dúvidas e a professora de história não conseguia avançar na matéria.
Devido a isso, a professora pediu que seus alunos informassem o número (em decimal e em algarismos
arábicos) do século de um determinado ano, mas como quase ninguém aprendia, ela decidiu pedir
sua ajuda para criar um programa que fosse capaz dessa proeza.
Você, por outro lado, aprendeu bem que o século 1, por exemplo, relaciona-se aos anos 1 a 100, o
século 2 aos anos 101 a 200, o século 3 aos anos de 201 a 300 e por aí vai.

Entrada
A entrada consiste em vários casos de teste. Cada linha é um novo caso de teste e contém um
único inteiro N (1 ≤ N ≤ 109), que corresponde ao valor de algum ano que deve ser processado.

Saída
Para cada caso de teste, imprima uma única linha contendo o valor do século do ano correspondente.

Exemplo de Entrada 	Exemplo de Saída

1                   1
999                 10
2000                20
2001                21
*/

import java.util.Scanner;

public class ExercicioDeHistoria {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int ano = 0;
        int seculo = 0;

        while (input.hasNextInt()) {
            ano = input.nextInt();
            seculo = (int) Math.ceil(ano / 100.0);
            System.out.println(seculo);
        }
    }
}
