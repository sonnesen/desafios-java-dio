package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class OrdenacaoEFiltrosApp {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int numeroDeLinhas = 0;
            List<Integer> valores = new ArrayList<>();

            StringTokenizer numeroDeLinhasSTokenizer = new StringTokenizer(br.readLine());

            numeroDeLinhas = Integer.parseInt(numeroDeLinhasSTokenizer.nextToken());
            
            for (int i = 0; i < numeroDeLinhas; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());                
                int valor = Integer.parseInt(st.nextToken());
                valores.add(valor);
            }
            
            valores.sort((valor1, valor2) -> valor1 - valor2);
            valores.stream().filter(valor -> (valor % 2) == 0).collect(Collectors.toList())
                .stream().forEach(System.out::println);
            
            valores.sort((valor1, valor2) -> valor2 - valor1);
            valores.stream().filter(valor -> (valor % 2) != 0).collect(Collectors.toList())
                .stream().forEach(System.out::println);

        }

    }

}
