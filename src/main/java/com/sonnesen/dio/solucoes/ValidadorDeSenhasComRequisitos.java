package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ValidadorDeSenhasComRequisitos {

    private static final List<Pattern> requisitosDaSenha = new ArrayList<>();
            
    static {
        requisitosDaSenha.add(Pattern.compile(".*[a-z].*"));
        requisitosDaSenha.add(Pattern.compile(".*[A-Z].*"));
        requisitosDaSenha.add(Pattern.compile(".*[0-9].*"));
        requisitosDaSenha.add(Pattern.compile(".*[^\\s].*"));
        requisitosDaSenha.add(Pattern.compile("\\w{6,32}"));
    }
    
    public static void main(String[] args) throws IOException {
        
        String senha = null;
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            while ((senha = in.readLine()) != null) {
                boolean senhaValida = validaSenha(senha);
                mostraSaida(senhaValida);
            }
        }

    }

    private static void mostraSaida(boolean senhaValida) {
        String msg = senhaValida ? "Senha valida." : "Senha invalida.";
        System.out.println(msg);        
    }

    private static boolean validaSenha(String senha) {
        List<Boolean> validacoes = new ArrayList<>();
        
        requisitosDaSenha.forEach(pattern -> {
            validacoes.add(pattern.matcher(senha).matches());
        });
        
        return validacoes.stream().allMatch(resultado -> resultado);
    }
    
}
