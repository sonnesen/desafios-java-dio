package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class HashMagico {

    public static void main(String[] args) throws Exception {
        
        InputStream in = System.in;
        OutputStream out = System.out;
        
        new HashMagico().iniciar(in, out);
    }

    private void iniciar(InputStream in, OutputStream out) throws Exception {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            
            while (n > 0) {
                List<String> linhas = new ArrayList<>();
                int numeroDeLinhas = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
                
                while (numeroDeLinhas > 0) {
                    String linha = br.readLine();
                    linhas.add(linha);
                    numeroDeLinhas--;
                }
                
                int hash = calcularHash(linhas);
                bw.write("" + hash);
                bw.newLine();
                
                n--;
            }
        }
    }
    
    private int calcularHash(List<String> linhas) {
        List<String> alfabeto = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        
        int hash = 0;
        int entrada = 0;
        
        for (String linha : linhas) {
            String[] letras = linha.split("");
            
            for (int posicaoDoElemento = 0; posicaoDoElemento < letras.length; posicaoDoElemento++) {
                int posicaoNoAlfabeto = alfabeto.indexOf(letras[posicaoDoElemento]);
                hash += posicaoNoAlfabeto + entrada + posicaoDoElemento;
            }
            
            entrada++;
        }
        
        return hash;
    }
}
