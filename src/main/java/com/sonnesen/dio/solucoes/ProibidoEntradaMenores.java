package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/*
* O objetivo deste desafio é resolvê-lo utilizando o seu conhecimento sobre Arrays,
* uma estrutura de dados que armazena uma coleção de dados em um bloco de memória.
* Você está desenvolvendo um sistema para um local de eventos, neste local, é necessário
* que a entrada seja permitida apenas para pessoas acima de 18 anos. Faça um programa para
* ler um número N, a idade de N pessoas. Depois disso, coloque a idade mínima permitida
* para se entrar no local, conforme exemplo.
* Retorne às idades de quem não puder entrar.
*
* Entrada   Saída
* 4         Nao poderao entrar as idades:
* 18        4
* 22        15
* 15
* 50
*/
public class ProibidoEntradaMenores {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int quantidade = leitor.nextInt();
        int[] idade = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            idade[i] = leitor.nextInt();
        }

        System.out.println("Nao poderao entrar as idades: ");
        for (int i = 0; i < quantidade; i++) {
            if (idade[i] < 18) {
                System.out.println(idade[i]);
            }
        }
    }
}
