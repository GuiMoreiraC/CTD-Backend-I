package Modulo_I.A04S.Atividade.Documento;

public class Documento {
    private String conteudo;
    private int nivelAcesso;

    public Documento(String conteudo, int nivelAcesso) {
        this.conteudo = conteudo;
        this.nivelAcesso = nivelAcesso;
    }

    public String getConteudo() {
        return conteudo;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }
}