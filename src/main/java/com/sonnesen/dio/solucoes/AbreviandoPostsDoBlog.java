package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AbreviandoPostsDoBlog {

    public static void main(String[] args) throws IOException {
//        java.io.FileInputStream in = new java.io.FileInputStream(
//                new java.io.File("src/desafios/dadosAbreviandoPalavras.txt"));
//        java.io.FileOutputStream out = new java.io.FileOutputStream(
//                new java.io.File("src/desafios/resultadosObtidos.txt"));

        java.io.InputStream in = System.in;
        java.io.PrintStream out = System.out;
                
        iniciar(in, out);
    }

    private static void iniciar(InputStream in, OutputStream out) throws FileNotFoundException, IOException {
        List<Linha> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {

            String linha = null;

            while ((linha = br.readLine()) != null && !(".".equals(linha))) {
                if (linha.length() > 10_000)
                    continue;

                Linha linhaAbreviada = new Linha(linha);
                String[] palavras = linha.split("\\s");

                for (int i = 0; i < palavras.length; i++) {
                    String palavra = palavras[i];

                    if (palavra.length() <= 2)
                        continue;

                    String primeiraLetraDaPalavra = palavra.substring(0, 1);

                    String palavraEscolhida = linhaAbreviada.map.getOrDefault(primeiraLetraDaPalavra, null);
                    
                    
                    if (palavraEscolhida == null)
                        linhaAbreviada.map.put(primeiraLetraDaPalavra, palavra);
                    else {
                        String aux1 = linha.replaceAll(palavra, primeiraLetraDaPalavra + ".");
                        String aux2 = linha.replaceAll(palavraEscolhida, primeiraLetraDaPalavra + ".");
                        
                        if (aux1.length() < aux2.length()) {
                            linhaAbreviada.map.put(primeiraLetraDaPalavra, palavra);
                        }
                    }
                }

                linhas.add(linhaAbreviada);

            }

            for (int i = 0; i < linhas.size() - 1; i++) {
                bw.write(linhas.get(i).resultado());
                bw.newLine();
            }

            bw.write(linhas.get(linhas.size() - 1).resultado());
            bw.newLine();
        }
    }
}

class Linha {
    String linhaOriginal = null;

    String linhaAbreviada = null;

    Map<String, String> map = new HashMap<>();

    Linha(String linhaOriginal) {
        this.linhaOriginal = linhaOriginal;
    }

    public String resultado() {
        StringBuilder sb = new StringBuilder();

        List<String> letrasIniciais = map.keySet().stream().sorted().collect(Collectors.toList());

        linhaAbreviada = linhaOriginal;

        letrasIniciais.stream().forEach(letra -> {
            String palavra = map.get(letra);
            linhaAbreviada = linhaAbreviada.replaceAll("\\b" + palavra + "\\b", letra + ".");
            sb.append(letra).append(". = ").append(palavra).append("\n");
        });

        String aux = sb.toString();
        aux = aux.substring(0, aux.length() - 1);

        return linhaAbreviada + "\n" + map.keySet().size() + "\n" + aux;
    }

    public int numeroDeOcorrenciasDaPalavra(String palavra) {
        int ocorrencias = 0;

        String[] palavras = linhaOriginal.split("\\s");

        for (int i = 0; i < palavras.length; i++) {
            if (palavra.equals(palavras[i]))
                ocorrencias++;
        }

        return ocorrencias;
    }
}
