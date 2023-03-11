package Modulo_I.A04S.Mesa.ControleQualidade;

import Modulo_I.A04S.Mesa.Artigo.Artigo;

public class CheckQuality {
    private Controle controle;

    public CheckQuality() {
        // Define a sequência dos controles
        Controle controleEmbalagem = new ControleEmbalagem(null);
        Controle controlePeso = new ControlePeso(controleEmbalagem);
        Controle controleLote = new ControleLote(controlePeso);

        controle = controleLote;
    }

    public boolean verificar(Artigo artigo) {
        boolean resultado = controle.verificar(artigo);

        if (resultado) {
            System.out.println("O artigo " + artigo.getNome() + " foi aceito.");
            return true;
        }
        System.out.println("O artigo " + artigo.getNome() + " foi rejeitado.");

        return false;
    }
}