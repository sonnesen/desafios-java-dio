package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MultipicacaoSimples {

    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int primeiroFator = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int segundoFator = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            System.out.println(String.format("PROD = %s", primeiroFator * segundoFator));
        }
    }
}
