package Modulo_I.A04S.Mesa.ControleQualidade;

import Modulo_I.A04S.Mesa.Artigo.Artigo;

public abstract class Controle {
    private Controle proximo;

    public Controle(Controle proximo) {
        this.proximo = proximo;
    }

    public abstract boolean verificar(Artigo artigo);

    public void setProximo(Controle proximo) {
        this.proximo = proximo;
    }

    public Controle getProximo() {
        return proximo;
    }
}

