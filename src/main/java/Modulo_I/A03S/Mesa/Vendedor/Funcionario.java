package Modulo_I.A03S.Mesa.Vendedor;

import java.util.ArrayList;

public class Funcionario extends Vendedor {

    private int anosAntiguidade;
    private ArrayList<Afiliado> afiliados;

    public Funcionario(String nome, int anosAntiguidade) {
        super(nome);
        this.anosAntiguidade = anosAntiguidade;
        this.afiliados = new ArrayList<>();
    }

    public void obterAfiliado(Afiliado afiliado) {
        afiliados.add(afiliado);
    }

    @Override
    public void calcularPontos() {
        int totalPontos = afiliados.size() * 10;
        totalPontos += anosAntiguidade * 5;
        totalPontos += getVendas() * 5;

        setPontos(totalPontos);
    }

}
