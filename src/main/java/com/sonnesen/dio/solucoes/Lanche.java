package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class Lanche {

    public static void main(String[] args) {
        int codigoProduto, quantidade;
        float preco = 0;

        Scanner input = new Scanner(System.in);
        codigoProduto = input.nextInt();
        quantidade = input.nextInt();
        if (codigoProduto == 1) {
            preco  = (float) (4.00 * quantidade);
        }else if (codigoProduto == 2) {
            preco  = (float) (4.5  * quantidade);
        }else if (codigoProduto == 3) {
            preco  = (float) (5.0 * quantidade);
        }else if (codigoProduto == 4) {
            preco  = (float) (2.0 * quantidade);
        }else if (codigoProduto == 5) {
            preco  = (float) (1.5 * quantidade);
        }

        System.out.printf("Total: R$ %.2f\n",preco);
    }
}
