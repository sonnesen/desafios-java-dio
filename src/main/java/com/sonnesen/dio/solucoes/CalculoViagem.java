package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class CalculoViagem {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int tempoDaViagem = scan.nextInt();
    int velocidadeMedia = scan.nextInt();

    System.out.printf("%.3f\n", (tempoDaViagem * velocidadeMedia) / 12.0);
    scan.close();
  }
}
