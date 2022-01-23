package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Multiplos {

  public static void main(String[] args) throws IOException {
    Scanner leitor = new Scanner(System.in);

    int valorA = Math.abs(leitor.nextInt());
    int valorB = Math.abs(leitor.nextInt());

    List<Integer> valores =
        IntStream.of(valorA, valorB).sorted().boxed().collect(Collectors.toList());

    if (valores.get(1) % valores.get(0) == 0) {
      System.out.println("Sao Multiplos");
    } else {
      System.out.println("Nao sao Multiplos");
    }

    leitor.close();
  }
}
