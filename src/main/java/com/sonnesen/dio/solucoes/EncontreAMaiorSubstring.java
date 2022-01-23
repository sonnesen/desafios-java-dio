package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncontreAMaiorSubstring {

    public static void main(String[] args) throws IOException {
        
        String linha1 = null;
        String linha2 = null;
        String aux = null;
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            while ((aux = in.readLine()) != null) {
                if (linha1 == null)
                    linha1 = aux;
                else if (linha2 == null) 
                    linha2 = aux;
                
                if (linha1 != null && linha2 != null) {
                    int tamanho = lookup(linha1, linha2);
                    System.out.println(tamanho);
                    linha1 = linha2 = null;
                }                
            }
        }

    }

    private static int lookup(String linha1, String linha2) {
        
        int tamanho = 0;
        int aux = 0;
        
        while (aux < linha2.length()) {
            StringBuilder sb = new StringBuilder(); 
            for (int i = aux; i < linha2.length(); i++) {
                sb.append(linha2.charAt(i));
                if (linha1.contains(sb)) {
                    if (sb.length() > tamanho)
                        tamanho = sb.length();
                }
            }
            aux++;
        }
        
        return tamanho;
    }
}
