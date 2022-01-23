package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class NumerosImpares {

    public static void main(String[] args) throws IOException {
        
        try (Scanner leitor = new Scanner(System.in)) {
            
            int x = leitor.nextInt();

            IntStream
                .rangeClosed(1, x)
                .filter(value -> value % 2 != 0)
                .forEach(System.out::println);
        }
    }
}
