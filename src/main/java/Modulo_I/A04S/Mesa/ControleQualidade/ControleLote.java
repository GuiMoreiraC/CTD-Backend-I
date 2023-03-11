package Modulo_I.A04S.Mesa.ControleQualidade;

import Modulo_I.A04S.Mesa.Artigo.Artigo;

public class ControleLote extends Controle {
    public ControleLote(Controle proximo) {
        super(proximo);
    }

    @Override
    public boolean verificar(Artigo artigo) {
        if (artigo.getLote() >= 1000 && artigo.getLote() <= 2000) {
            System.out.println("O artigo " + artigo.getNome() + " passou no controle de lote.");
            if (this.getProximo() != null){
                return this.getProximo().verificar(artigo);
            }
            return true;
        }
        System.out.println("O artigo " + artigo.getNome() + " falhou no controle de lote.");

        return false;
    }

}
