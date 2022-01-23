package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class MensagemDoPadreDoBalao {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        while (leitor.hasNext()) {
            String alphabet = leitor.next();
            String word = "";
            int letters = leitor.nextInt();
            for (int i = 0; i < letters; i++) {
                int letter = leitor.nextInt();
                word = word.concat(String.valueOf(alphabet.charAt(letter - 1)));
            }
            System.out.println(word);
        }
    }
}
