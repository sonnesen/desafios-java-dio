package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/*
* Gilberto é um famoso vendedor de esfirras na região. Porém, apesar de todos gostarem de suas
* esfirras, ele só sabe dar o troco com duas notas, ou seja, nem sempre é possível receber o
* troco certo. Para facilitar a vida de Gil, escreva um programa para ele que determine se é
* possível ou não devolver o troco exato utilizando duas notas.
*
* As notas disponíveis são: 2, 5, 10, 20, 50 e 100.
*
* Entrada
* A entrada deve conter o valor inteiro N da compra realizada pelo cliente e, em seguida,
* o valor inteiro M pago pelo cliente (N < M ≤ 104). A entrada termina com N = M = 0.
*
* Saída
* Seu programa deverá imprimir "possible" se for possível devolver o troco exato ou "impossible"
* se não for possível.
*
* Exemplo de Entrada 	Exemplo de Saída
* 11 23                 possible
* 500 650               possible
* 100 600               impossible
* 9948 9963             possible
* 1 2                   impossible
* 2 4                   impossible
* 0 0
*
* Aquecimento para a VI Olimpíada Interna de Programação do IFSULDEMINAS - OLIP 2016
*/
public class DuasNotas {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int notas[] = {2,5,10,20,50,100};

        while (true) {
            int valorDaCompra = leitor.nextInt();
            int valorPago = leitor.nextInt();
            int troco = valorPago - valorDaCompra;
            boolean possivel = false;

            if (valorDaCompra == 0 && valorPago == 0) break;

            outer:
            for (int i = 0; i < notas.length; i++) {
                for (int j = 0; j < notas.length; j++) {
                    if (notas[i] + notas[j] == troco) {
                        possivel = true;
                        break outer;
                    }
                }
            }

            if (possivel)
                System.out.println("possible");
            else
                System.out.println("impossible");
        }
    }
}
