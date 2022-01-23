package com.sonnesen.dio.solucoes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MelhorAmigoDoPaulo {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;

        new MelhorAmigoDoPaulo().inciar(in, out);
    }

    private void inciar(InputStream in, OutputStream out) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))) {

            String linha = null;

            List<Voto> votos = new ArrayList<>();

            AtomicInteger criterio = new AtomicInteger(0);
            AtomicReference<Voto> vencedor = new AtomicReference<>();

            while ((linha = br.readLine()) != null && !linha.equals("FIM")) {
                StringTokenizer st = new StringTokenizer(linha);
                String nome = st.nextToken();
                String opcao = st.nextToken();

                if ("SIM".equals(opcao) && (criterio.get() == 0 || nome.length() > criterio.get()))
                    criterio.set(nome.length());

                votos.add(new Voto(nome, opcao));
            }

            Set<Voto> votosUnicos = new TreeSet<>((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
            votosUnicos.addAll(votos);

            votosUnicos
                    .stream()
                    .filter(voto -> "SIM".equals(voto.getOpcao()))
                    .forEach(voto -> {
                        String nome = voto.getNome();
                        Voto votoVencedor = vencedor.get();

                        if (nome.length() == criterio.get()) {
                            if (votoVencedor == null)
                                votoVencedor = voto;
                            else if (voto.getSequencia() < votoVencedor.getSequencia()) {
                                votoVencedor = voto;
                            }
                            vencedor.set(votoVencedor);
                        }

                        try {
                            bw.write(nome + "\n");
                        }
                        catch (IOException e) {
                        }
                    });

            votosUnicos
                    .stream()
                    .filter(voto -> "NAO".equals(voto.getOpcao()))
                    .forEach(voto -> {
                        try {
                            bw.write(voto.getNome() + "\n");
                        }
                        catch (IOException e) {
                        }
                    });

            bw.write("\nAmigo do Pablo:\n" + vencedor.get().getNome());

        }
    }
}

class Voto {
    private static int SEQUENCIADOR = 0;

    private String nome;

    private String opcao;

    private int sequencia;

    public Voto(String nome, String opcao) {
        super();
        this.nome = nome;
        this.opcao = opcao;
        this.sequencia = SEQUENCIADOR++;
    }

    public String getNome() {
        return nome;
    }

    public String getOpcao() {
        return opcao;
    }

    public int getSequencia() {
        return sequencia;
    }

    @Override
    public String toString() {
        return nome;
    }

}