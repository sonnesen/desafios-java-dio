package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CalculadoraDeConsumoMedioDeCombustivel {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int kilometrosPercorridos = 0;
        double litrosConsumidos = 0.0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        kilometrosPercorridos = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        litrosConsumidos = Double.parseDouble(st.nextToken());
        
        double consumoMedio = kilometrosPercorridos / litrosConsumidos;
        
        System.out.println(String.format("%.3f km/l", consumoMedio));

    }

}