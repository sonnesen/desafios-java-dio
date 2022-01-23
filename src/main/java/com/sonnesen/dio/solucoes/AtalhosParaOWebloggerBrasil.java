package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AtalhosParaOWebloggerBrasil {

    public static void main(String[] args) throws NumberFormatException, IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linha = null;

            while ((linha = br.readLine()) != null) {
                String[] caracteres = linha.split("");
                
                int primeiraOcorrenciaSublinhado = -1;
                int segundaOcorrenciaSublinhado = -1;
                int primeiraOcorrenciaAsterisco = -1;
                int segundaOcorrenciaAsterisco = -1;
                
                for (int i = 0; i < caracteres.length; i++) {
                    if (caracteres[i].equals("_")) {
                        if (primeiraOcorrenciaSublinhado < 0) {
                            primeiraOcorrenciaSublinhado = i;
                        } else if (segundaOcorrenciaSublinhado < 0) {
                            segundaOcorrenciaSublinhado = i;
                        }
                    }
                    
                    if (primeiraOcorrenciaSublinhado >= 0 && segundaOcorrenciaSublinhado > 0) {
                        caracteres[primeiraOcorrenciaSublinhado] = "<i>";
                        caracteres[segundaOcorrenciaSublinhado] = "</i>";
                        primeiraOcorrenciaSublinhado = -1;
                        segundaOcorrenciaSublinhado = -1;
                    }
                    
                    if (caracteres[i].equals("*")) {
                        if (primeiraOcorrenciaAsterisco < 0) {
                            primeiraOcorrenciaAsterisco = i;
                        } else if (segundaOcorrenciaAsterisco < 0) {
                            segundaOcorrenciaAsterisco = i;
                        }
                    }
                    
                    if (primeiraOcorrenciaAsterisco >= 0 && segundaOcorrenciaAsterisco > 0) {
                        caracteres[primeiraOcorrenciaAsterisco] = "<b>";
                        caracteres[segundaOcorrenciaAsterisco] = "</b>";
                        primeiraOcorrenciaAsterisco = -1;
                        segundaOcorrenciaAsterisco = -1;
                    }
                        
                }
                
                StringBuilder sb = new StringBuilder();
                
                for (int i = 0; i < caracteres.length; i++) {
                    sb.append(caracteres[i]);
                }
                
                System.out.println(sb);
                
            }
        }
    }

}

