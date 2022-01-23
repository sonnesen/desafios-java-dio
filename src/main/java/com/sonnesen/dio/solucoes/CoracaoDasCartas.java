package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CoracaoDasCartas {

    private int n;

    private int[][] pilha = new int[3][102];

    private Map<String, Integer> m = null;

    public static void main(String[] args) throws Exception {
        new CoracaoDasCartas().iniciar();
    }

    public void iniciar() throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                try {
                    n = Integer.parseInt(br.readLine());
                }
                catch (Exception e) {
                }

                if (n == 0)
                    break;

                for (int i = 0; i < n; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < 3; j++) {
                        pilha[j][i] = Integer.parseInt(st.nextToken());
                    }
                }

                m = new HashMap<>();
                m.put("000", 0);
                boolean resultado = funcao(0, 0, 0);
                System.out.println(resultado ? 1 : 0);
            }

        }
    }

    private boolean funcao(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        String valor = sb.append(a).append(b).append(c).toString();

        if (a == b && b == c && c == n) {
            m.put(valor, 1);
            return true;
        }

        int x = 0;

        try {
            x = m.get(valor);
        }
        catch (Exception e) {
        }

        if (x > 0)
            return (x == 1 ? true : false);

        if (a < n && pilha[0][a] % 3 == 0 && funcao(a + 1, b, c)) {
            m.put(valor, 1);
            return true;
        }

        if (b < n && pilha[1][b] % 3 == 0 && funcao(a, b + 1, c)) {
            m.put(valor, 1);
            return true;
        }

        if (c < n && pilha[2][c] % 3 == 0 && funcao(a, b, c + 1)) {
            m.put(valor, 1);
            return true;
        }

        if (a < n && b < n && (pilha[0][a] + pilha[1][b]) % 3 == 0 && funcao(a + 1, b + 1, c)) {
            m.put(valor, 1);
            return true;
        }

        if (a < n && c < n && (pilha[0][a] + pilha[2][c]) % 3 == 0 && funcao(a + 1, b, c + 1)) {
            m.put(valor, 1);
            return true;
        }

        if (b < n && c < n && (pilha[1][b] + pilha[2][c]) % 3 == 0 && funcao(a, b + 1, c + 1)) {
            m.put(valor, 1);
            return true;
        }

        if (a < n && b < n && c < n && (pilha[0][a] + pilha[1][b] + pilha[2][c]) % 3 == 0
                && funcao(a + 1, b + 1, c + 1)) {
            m.put(valor, 1);
            return true;
        }

        m.put(valor, 2);
        return false;
    }

}
