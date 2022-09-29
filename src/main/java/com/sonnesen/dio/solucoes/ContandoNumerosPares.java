package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class ContandoNumerosPares {
    public static void main(String[] args) {
        int num = Integer.parseInt(new Scanner(System.in).nextLine());
        var count = 0;

        for (int i = 1; i <= num ; i++) {
            String[] digitos = String.valueOf(i).split("(?<=.)");
            int soma = 0;
            for (int j = 0; j < digitos.length; j++) {
                int digito = Integer.parseInt(digitos[j]);
                soma += digito;
            }
            if (soma % 2 == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
