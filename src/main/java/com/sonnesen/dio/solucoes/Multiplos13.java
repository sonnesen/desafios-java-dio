package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Multiplos13 {

  public static void main(String[] args) throws IOException {
    Scanner leitor = new Scanner(System.in);

    int soma = 0;
    int valorA = leitor.nextInt();
    int valorB = leitor.nextInt();

    List<Integer> valores =
        IntStream.of(valorA, valorB).sorted().boxed().collect(Collectors.toList());

    for (int i = valores.get(0); i <= valores.get(1); i++) {
      if (i % 13 != 0) {
        soma += i;
      }
    }

    System.out.println(soma);

    leitor.close();
  }
}
