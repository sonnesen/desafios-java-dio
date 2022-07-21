package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/*
* O jogo PAR ou ÍMPAR vem decidindo o destino de pessoas ao longo de décadas. As regras
* são simples: dois jogadores informam um número e se a soma desses números for par o
* jogador que escolheu PAR ganha e vice-versa. Em um jogo que as crianças do bairro estão
* jogando, eles não conseguem decidir quem será o próximo a escolher as regras da brincadeira.
* Para solucionar esse problema, você foi chamado.
*
* Basicamente a brincadeira só poderá ser jogada de dois em dois jogadores e para escolher
* o próximo jogador uma das  crianças pediu sua ajuda para desenvolver um programa que, dado
* o nome dos jogadores, suas respectivas escolhas PAR ou IMPAR e os números, informe quem
* foi o vencedor.
*
* Entrada
* A primeira linha de entrada contém um número inteiro QT (1 ≤ QT ≤ 100), indicando a
* quantidade de casos de teste que vem a seguir. Cada caso de teste contém duas linhas.
* Na primeira linha será informado o nome do jogador 1 seguido de sua escolha, “PAR” ou
* “IMPAR” e logo após, o nome do jogador 2 seguido de sua escolha, “PAR” ou “IMPAR”.
* Na segunda linha de entrada, contém 2 números inteiros N (1 ≤ N ≤ 10⁹) e M (1 ≤ M ≤ 10⁹),
* representando respectivamente os números escolhidos pelo jogador 1 e pelo jogador 2.
* É garantido que a escolha (PAR ou IMPAR) do jogador 1 será diferente da escolha (PAR ou IMPAR)
* do jogador 2 e que o nome dos jogares são formados somente por letras e não ultrapassarão
* 100 caracteres.
*
* Saída
* Para cada caso de teste, imprima uma única linha contendo o nome do jogador vencedor.
*
* Exemplo de Entrada 	    Exemplo de Saída
* 4
* Quico PAR Chiquinha IMPAR Quico
* 9 7
*
* Dami PAR Marcus IMPAR     Marcus
* 12 3
*
* Dayran PAR Conrado IMPAR  Conrado
* 3 1000000000
*
* Popis PAR Chaves IMPAR    Chaves
* 2 7
*/
public class DeQuemEaVez {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int quantidade = leitor.nextInt();
        leitor.nextLine();

        for (int i = 0; i < quantidade; i++) {
            String[] linha1 = leitor.nextLine().split(" ");
            String[] linha2 = leitor.nextLine().split(" ");

            String nomeJogadorA = linha1[0];
            String escolhaJogadorA = linha1[1];
            String nomeJogadorB = linha1[2];
            String escolhaJogadorB = linha1[3];
            int valorJogadorA = Integer.valueOf(linha2[0]);
            int valorJogadorB = Integer.valueOf(linha2[1]);

            if (((valorJogadorA + valorJogadorB) % 2 == 0) && "PAR".equalsIgnoreCase(escolhaJogadorA) ||
                ((valorJogadorA + valorJogadorB) % 2 != 0) && "IMPAR".equalsIgnoreCase(escolhaJogadorA)) {
                System.out.println(nomeJogadorA);
            } else {
                System.out.println(nomeJogadorB);
            }
        }
    }
}
