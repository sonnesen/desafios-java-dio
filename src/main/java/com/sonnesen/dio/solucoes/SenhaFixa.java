package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class SenhaFixa {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        while (true) {
            int senha = leitor.nextInt();
            if (senha == 2002) {
                System.out.println("Acesso Permitido");
                break;
            } else {
                System.out.println("Senha Invalida");
            }
        }

        leitor.close();
    }
}
