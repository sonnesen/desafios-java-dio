package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class Blobs {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int entry = reader.nextInt();

        for (int i = 0; i < entry; i++) {
            double qtd = reader.nextDouble();
            int days = 0;
            double aux = 0.0;
            do {
                aux = qtd / 2.0;
                qtd = aux;
                days++;
            } while (aux >= 1.0);
            System.out.println(String.format("%s %s", days, days > 1 ? "dias" : "dia"));
        }
    }
}
