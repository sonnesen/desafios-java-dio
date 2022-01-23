package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class VogaisExtraterrestres {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;

        new VogaisExtraterrestres().inciar(in, out);
    }

    private void inciar(InputStream in, OutputStream out) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {
            
            String vogais = null;
            
            while ((vogais = br.readLine()) != null && vogais.length() > 0) {
                String[] vogaisAlienigenas = vogais.split("");
                String frase = br.readLine();
                
                int contador = 0;
                
                for (int i = 0; i < vogaisAlienigenas.length; i++) {
                    String vogal = vogaisAlienigenas[i];
                    Stream<String> stream = Stream.of(frase.split(""));
                    contador += stream.filter(s -> s.equals(vogal)).count();
                }
                
                bw.write("" + contador + "\n");
            }

        }
    }
}
