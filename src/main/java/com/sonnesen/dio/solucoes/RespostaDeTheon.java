package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

/*
Ramsay: "(...) você vence se conseguir adivinhar quem eu sou e por que estou torturando você."

Theon deve pensar rápido e adivinhar quem é seu algoz! Entretanto, 
Ramsay já decidiu o que ele irá fazer depois que Theon der sua resposta.

Theon pode dizer que seu algoz é alguma dentre N pessoas. Considere que as pessoas 
são numeradas de 1 a N. Se Theon responder que seu algoz é a pessoa i, Ramsay irá atingi-lo Ti vezes.

Sua tarefa é ajudar Theon a determinar qual deve ser sua resposta de forma a minimizar 
o número de vezes que ele será atingido.

Entrada
A primeira linha contém um inteiro N (1 ≤ N ≤ 100). A segunda linha contém N inteiros T1, T2, ..., TN (0 ≤ Ti ≤ 20).

Saída
Imprima uma linha contendo o número da pessoa que Theon deve dizer ser seu algoz. Se existe mais de uma resposta possível, imprima a menor.
 
Exemplos de Entrada 	Exemplos de Saída
3                       2
8 0 7
-------------------------------------------
2                       1
1 1
*/

public class RespostaDeTheon {
    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int n = leitor.nextInt();
        int t, menor = Integer.MAX_VALUE, posMenor = 1;
        
        for (int i = 1; i <= n; i++) {
            t = leitor.nextInt();
            if ( t < menor) {
                menor = t;
                posMenor = i;    
            }
        }
        System.out.println(posMenor);
        leitor.close();
  }
}
