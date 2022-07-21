package com.sonnesen.dio.solucoes;

import java.util.Arrays;
import java.util.Scanner;

public class FotoAnual {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int tamanho = input.nextInt();
        int[] heights = new int[tamanho];

        //preenchendo o array de alturas com as entradas
        for(int i = 0; i < tamanho; i++){
            heights[i] = input.nextInt();
        }


        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] aux = Arrays.copyOf(heights, heights.length);
        Arrays.sort(aux);

        int dif = 0;

        for (int i = 0; i < aux.length; i++) {
            if (aux[i] != heights[i]) {
                dif++;
            }
        }
        return dif;
    }
}
