package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class OrdenacaoDePalavrasPorTamanho {

    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            
            int quantidadeDeTestes = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            
            for (int i = 0; i < quantidadeDeTestes; i++) {
                List<String> palavras = Arrays.asList(br.readLine().split("\\s"));
            
                palavras.sort((s1,s2) -> {
                    int result = s2.length() - s1.length();
                    
                    if (result == 0) {
                        result = s1.compareTo(s2);
                    }
                    
                    return result;
                });
                
                palavras.stream().forEach(palavra -> System.out.print(palavra + " "));
                System.out.println();
            }            
            
        }
        
    }

}
