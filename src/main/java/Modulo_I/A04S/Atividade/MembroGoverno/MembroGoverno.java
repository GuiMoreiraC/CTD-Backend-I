package Modulo_I.A04S.Atividade.MembroGoverno;

import Modulo_I.A04S.Atividade.Documento.Documento;

public abstract class MembroGoverno {
    private String nome;
    private MembroGoverno sucessor;
    private int nivelAcesso;

    public MembroGoverno(String nome, int nivelAcesso) {
        this.nome = nome;
        this.nivelAcesso = nivelAcesso;
    }

    public void lerDocumento(Documento documento) {
        if (documento.getNivelAcesso() <= this.nivelAcesso) {
            System.out.println(this.getClass().getSimpleName() + " " + nome + " leu o documento: " + documento.getConteudo());
        } else if (sucessor != null) {
            sucessor.lerDocumento(documento);
        } else {
            System.out.println("Nenhum membro com acesso suficiente para ler o documento.");
        }
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }
}