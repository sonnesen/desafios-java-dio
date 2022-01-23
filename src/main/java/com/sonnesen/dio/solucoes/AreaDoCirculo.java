package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class AreaDoCirculo {

  public static void main(String[] args) {
    final double PI = 3.14159;

    Scanner scan = new Scanner(System.in);

    double raio = scan.nextDouble();
    double area = PI * (Math.pow(raio, 2));

    System.out.printf("A=%.4f\n", area);
    scan.close();
  }
}
