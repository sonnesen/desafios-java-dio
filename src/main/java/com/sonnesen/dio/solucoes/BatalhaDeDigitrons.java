package com.sonnesen.dio.solucoes;

import java.util.Scanner;

public class BatalhaDeDigitrons {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int numeroInstancias = leitor.nextInt();
        int valorBonus, valorAtaque, valorDefesa, valorNivel;

        for (int i = 0; i < numeroInstancias; i++) {
            valorBonus = leitor.nextInt();
            valorAtaque = leitor.nextInt();
            valorDefesa = leitor.nextInt();
            valorNivel = leitor.nextInt();

            Digitron digitronBruno = new Digitron(valorAtaque, valorDefesa, valorNivel);

            valorAtaque = leitor.nextInt();
            valorDefesa = leitor.nextInt();
            valorNivel = leitor.nextInt();

            Digitron digitronGuarte = new Digitron(valorAtaque, valorDefesa, valorNivel);

            if (digitronBruno.getValorGolpe(valorBonus) > digitronGuarte.getValorGolpe(valorBonus))
                System.out.println("Bruno");
            else if (digitronGuarte.getValorGolpe(valorBonus) > digitronBruno.getValorGolpe(valorBonus))
                System.out.println("Guarte");
            else
                System.out.println("Empate");

        }

        leitor.close();
    }
}

class Digitron {
    private int ataque;
    private int defesa;
    private int nivel;
    private float golpe;

    public Digitron(int ataque, int defesa, int nivel) {
        this.ataque = ataque;
        this.defesa = defesa;
        this.nivel = nivel;
    }

    public float getValorGolpe(int valorBonus) {
        int valorGolpe = (ataque + defesa) / 2;
        return this.nivel % 2 == 0 ? valorGolpe + valorBonus : valorGolpe;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getNivel() {
        return nivel;
    }
}