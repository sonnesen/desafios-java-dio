package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class FilaDoBanco {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int quantidadeDeTestes = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

            for (int i = 0; i < quantidadeDeTestes; i++) {

                int quantidadeDeClientes = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

                if (quantidadeDeClientes < 1 || quantidadeDeClientes > 1000)
                    throw new RuntimeException("Quantidade de clientes inválida! Informe um valor entre 1 e 1000.");

                List<Integer> senhasGeradas = Arrays.stream(br.readLine().split("\\s"))
                        .mapToInt(value -> Integer.parseInt(value)).boxed().collect(Collectors.toList());

                List<Integer> senhasOrdenas = new ArrayList<>(senhasGeradas);
                senhasOrdenas.sort((valor1, valor2) -> valor2 - valor1);

                int quantidadeDeClientesQueNaoPrecisaramTrocarDeLugar = 0;

                for (int j = 0; j < quantidadeDeClientes; j++) {
                    if (senhasGeradas.get(j) == senhasOrdenas.get(j)) {
                        quantidadeDeClientesQueNaoPrecisaramTrocarDeLugar++;
                    }
                }

                System.out.println(quantidadeDeClientesQueNaoPrecisaramTrocarDeLugar);
            }
        }

    }

}
