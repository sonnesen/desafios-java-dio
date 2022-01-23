package com.sonnesen.dio.solucoes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Leia um número inteiro que representa um código de DDD para discagem interurbana. Em seguida, informe à qual cidade o DDD pertence, considerando a tabela abaixo:
 
Se a entrada for qualquer outro DDD que não esteja presente na tabela acima, o programa deverá informar:
DDD nao cadastrado
Entrada

A entrada consiste de um único valor inteiro.
Saída

Imprima o nome da cidade correspondente ao DDD existente na entrada. Imprima DDD nao cadastrado caso não existir DDD correspondente ao número digitado.
 
Exemplo de Entrada 	Exemplo de Saída

11					Sao Paulo 
*/

public class DDDCidade {

  public static Map<Integer, String> map = new HashMap<>();

  public static void main(String[] args) {
    loadMap();

    Scanner leitor = new Scanner(System.in);
    int ddd = leitor.nextInt();
    String city = getCityFromDDD(ddd);
    System.out.println(city);
    leitor.close();
  }

  public static void loadMap() {
    map.put(61, "Brasilia");
    map.put(71, "Salvador");
    map.put(11, "Sao Paulo");
    map.put(21, "Rio de Janeiro");
    map.put(32, "Juiz de Fora");
    map.put(19, "Campinas");
    map.put(27, "Vitoria");
    map.put(31, "Belo Horizonte");
  }

  public static String getCityFromDDD(Integer ddd) {
    String dddNotFound = "DDD nao cadastrado";
    String city = map.getOrDefault(ddd, dddNotFound);
    return city;
  }
}
