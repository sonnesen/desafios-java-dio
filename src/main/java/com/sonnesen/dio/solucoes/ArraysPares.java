package com.sonnesen.dio.solucoes;

public class ArraysPares {
    public static void main(String[] args) {
        int[] array = {2,3,5,7,11,13,18,34};
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println(array[i]);
            }
        }
    }
}
