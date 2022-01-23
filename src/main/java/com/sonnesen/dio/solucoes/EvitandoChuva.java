package com.sonnesen.dio.solucoes;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/2813
 */
public class EvitandoChuva {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        int casaComprado = 0;
        int casaSobrando = 0;
        int trabComprado = 0;
        int trabSobrando = 0;
        
        leitor.nextLine();
        
        for (int i = 0; i < N; i++) {

            String[] previsaoDoTempo = leitor.nextLine().split(" ");
            String ida = previsaoDoTempo[0];
            String volta = previsaoDoTempo[1];

            if ("chuva".equals(ida)) {
                if (casaSobrando > 0) {
        		    casaSobrando--;
                } else {
                    casaComprado++;
                }
                trabSobrando++;
        	}

        	if ("chuva".equals(volta)) {
                if (trabSobrando > 0) {
        		    trabSobrando--;
                } else {
                    trabComprado++;
                }
                casaSobrando++;
        	}
        }

        System.out.println(casaComprado + " " + trabComprado);
        leitor.close();
    }
}
