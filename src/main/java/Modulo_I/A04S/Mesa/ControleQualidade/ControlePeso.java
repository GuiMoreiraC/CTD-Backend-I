package Modulo_I.A04S.Mesa.ControleQualidade;

import Modulo_I.A04S.Mesa.Artigo.Artigo;

public class ControlePeso extends Controle {
    public ControlePeso(Controle proximo) {
        super(proximo);
    }

    @Override
    public boolean verificar(Artigo artigo) {
        if (artigo.getPeso() >= 1200 && artigo.getPeso() <= 1300) {
            System.out.println("O artigo " + artigo.getNome() + " passou no controle de peso.");
            if (this.getProximo() != null){
                return this.getProximo().verificar(artigo);
            }
            return true;
        }
        System.out.println("O artigo " + artigo.getNome() + " falhou no controle de peso.");

        return false;
    }
}
