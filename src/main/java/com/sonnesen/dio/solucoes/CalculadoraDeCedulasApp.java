package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CalculadoraDeCedulasApp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int valor = Integer.parseInt(st.nextToken());

        CalculadoraDeCedulas calculadora = new CalculadoraDeCedulas();
        Map<Integer, Integer> cedulas = calculadora.calcular(valor);

        System.out.println(
                String.format("%s\n" +
                        "%s nota(s) de R$ 100,00\n" +
                        "%s nota(s) de R$ 50,00\n" +
                        "%s nota(s) de R$ 20,00\n" +
                        "%s nota(s) de R$ 10,00\n" +
                        "%s nota(s) de R$ 5,00\n" +
                        "%s nota(s) de R$ 2,00\n" +
                        "%s nota(s) de R$ 1,00", valor, cedulas.get(100), cedulas.get(50), cedulas.get(20),
                        cedulas.get(10), cedulas.get(5), cedulas.get(2), cedulas.get(1)));

    }

}

class CalculadoraDeCedulas {

    private List<Integer> cedulas = Arrays.asList(100, 50, 20, 10, 5, 2, 1);

    private Map<Integer, Integer> resultados = new HashMap<>();

    public Map<Integer, Integer> calcular(int valor) {
        for (Integer cedula : cedulas) {
            int resultado = valor / cedula;
            resultados.put(cedula, resultado);
            valor = valor - resultado * cedula;
        }

        return resultados;
    }
}
