package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ComprasNoSupermacado {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int quantidadeDeListas = Integer.parseInt(st.nextToken());
            Map<Integer, Set<String>> listas = new HashMap<>();
            
            for (int i = 0; i < quantidadeDeListas; i++) {
                String linha = br.readLine();
                List<String> lista = Arrays.asList(linha.split("\\s"));
                Collections.sort(lista);
                Set<String> itens = new LinkedHashSet<>(lista);
                
                listas.put(i, itens);
            }
            
            listas.forEach((linha, itens) -> {
                itens.stream().forEach(item -> System.out.print(item + " "));
                System.out.println();
            });
        }

    }

}
