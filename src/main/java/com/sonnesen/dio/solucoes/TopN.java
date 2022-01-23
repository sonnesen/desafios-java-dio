package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class TopN {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] TOPS = {1, 3, 5, 10, 25, 50, 100};

        int colocacao = scan.nextInt();

        if (colocacao > 50) {
            System.out.println("Top 100");
        } else if (colocacao > 25) {
            System.out.println("Top 50");
        } else if (colocacao > 10) {
            System.out.println("Top 25");
        } else if (colocacao > 5) {
            System.out.println("Top 10");
        } else if (colocacao > 3) {
            System.out.println("Top 5");
        } else if (colocacao > 1) {
            System.out.println("Top 3");
        } else {
            System.out.println("Top 1");
        }
    }
}
