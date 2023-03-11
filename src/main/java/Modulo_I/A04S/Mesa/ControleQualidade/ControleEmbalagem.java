package Modulo_I.A04S.Mesa.ControleQualidade;

import Modulo_I.A04S.Mesa.Artigo.Artigo;

public class ControleEmbalagem extends Controle {
    public ControleEmbalagem(Controle proximo) {
        super(proximo);
    }

    @Override
    public boolean verificar(Artigo artigo) {
        if (artigo.getEmbalagem().equalsIgnoreCase("saudável") ||
                artigo.getEmbalagem().equalsIgnoreCase("quase saudável")) {
            System.out.println("O artigo " + artigo.getNome() + " passou no controle de qualidade da embalagem.");
            if (this.getProximo() != null){
                return this.getProximo().verificar(artigo);
            }
            return true;
        }

        System.out.println("O artigo " + artigo.getNome() + " falhou no controle de qualidade da embalagem.");
        return false;

    }
}
