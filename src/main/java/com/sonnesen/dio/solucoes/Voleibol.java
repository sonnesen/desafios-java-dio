package com.sonnesen.dio.solucoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
Um treinador de voleibol gostaria de manter estatísticas sobre sua equipe. A cada jogo, seu
auxiliar anota quantas tentativas de saques, bloqueios e ataques cada um de seus jogadores
fez, bem como quantos desses saques, bloqueios e ataques tiveram sucesso (resultaram em pontos).
Seu programa deve mostrar qual o percentual de saques, bloqueios e ataques do time todo tiveram sucesso.

Entrada
A entrada é dada pelo número de jogadores N (1 ≤ N ≤ 100), seguido pelo nome de cada um dos jogadores.
Abaixo do nome de cada jogador, seguem duas linhas com três inteiros cada.
Na primeira linha S, B e A (0 ≤ S,B,A ≤ 10000) representam a quantidade de tentativas de saques,
bloqueios e ataques e na segunda linha, S1, B1 e A1 (0 ≤ S1 ≤ S; 0 ≤ B1 ≤ B; 0 ≤ A1 ≤ A) com o
número de saques, bloqueios e ataques deste jogador que tiveram sucesso.

Saída
A saída deve conter o percentual total de saques, bloqueios e ataques do time todo que resultaram
em pontos, conforme mostrado no exemplo.

Exemplo de Entrada 	Exemplo de Saída

3                   Pontos de Saque: 19.05 %.
Renan               Pontos de Bloqueio: 63.33 %.
10 20 12            Pontos de Bloqueio: 63.33 %.
1 10 9
Jonas
8 7 1
2 7 0
Edson
3 3 3
1 2 3
*/
public class Voleibol {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        int[] dados = new int[6];
        for (int i = 0; i < N; i++) {
            leitor.next();
            for (int j = 0; j < dados.length; j++) {
                dados[j] += leitor.nextInt();
            }
        }
        double bloqueios = (dados[3] * 100.0) / dados[0];
        double saques = (dados[4] * 100.0) / dados[1];
        double ataques = (dados[5] * 100.0) / dados[2];
        System.out.println(String.format("Pontos de Saque: %.2f", bloqueios) + " %.");
        System.out.println(String.format("Pontos de Bloqueio: %.2f", saques) + " %.");
        System.out.println(String.format("Pontos de Ataque: %.2f", ataques) + " %.");
    }
}
