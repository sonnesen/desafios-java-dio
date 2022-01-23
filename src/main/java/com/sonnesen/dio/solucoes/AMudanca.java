package com.sonnesen.dio.solucoes;

import java.util.Scanner;

/* 

Hermione está criando um novo Vira Tempo especialmente para programadores. É impressionante as vantagens que ele oferece e o conforto pra codar que ele tem. O artefato ainda está em desenvolvimento e ele prometeu consertar os bugs e colocar uns apetrechos melhores e, em troca, pediu um sistema simples para o modo Standy Bay. O problema é que o artefato por si só sempre tem o ângulo de inclinação do Sol/Lua(de 0 a 360). Valendo um Vira Tempo, caso deseja aceitar: dada em grau da inclinação do Sol/Lua, informe em qual período do dia ele se encontra.
Entrada

A entrada contém um número inteiro M (0 ≤ M ≤ 360) representando o grau do Sol/Lua. Como a posição muda constantemente seu programa receberá diversos casos a cada segundo(EOF).
Saída

Imprima uma saudação referente ao período do dia que ele se encontra: "Boa Tarde!!", "Boa Noite!!", "Bom Dia!!" e "De Madrugada!!".
 
Exemplo de Entrada 	Exemplo de Saída

0					Bom Dia!!
45					Bom Dia!!
360					Bom Dia!!
90					Boa Tarde!!
180					Boa Noite!!

*/

public class AMudanca {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int graus = sc.nextInt();
				if (graus >= 90 && graus < 180)
					System.out.println("Boa Tarde!!");
				else if (graus >= 180 && graus < 270)
					System.out.println("Boa Noite!!");
				else if (graus >= 270 && graus < 360)
					System.out.println("De Madrugada!!");
				else
					System.out.println("Bom Dia!!");
			}
		}
	}
}
