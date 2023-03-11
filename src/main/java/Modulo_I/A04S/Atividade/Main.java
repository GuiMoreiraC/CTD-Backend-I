package Modulo_I.A04S.Atividade;

import Modulo_I.A04S.Atividade.Documento.Documento;
import Modulo_I.A04S.Atividade.MembroGoverno.*;

public class Main {

    public static void main(String[] args) {
        MembroGoverno deputado1 = new Deputado("João");
        MembroGoverno deputado2 = new Deputado("Maria");

        MembroGoverno ministro1 = new Ministro("Carlos");
        MembroGoverno ministro2 = new Ministro("Julia");

        MembroGoverno presidente = new Presidente("José");

        CadeiaMembrosGoverno cadeia = new CadeiaMembrosGoverno();

        cadeia.adicionarMembro(deputado1);
        cadeia.adicionarMembro(deputado2);
        cadeia.adicionarMembro(ministro1);
        cadeia.adicionarMembro(ministro2);
        cadeia.adicionarMembro(presidente);

        Documento doc1 = new Documento("Documento reservado", 1);
        Documento doc2 = new Documento("Documento secreto", 2);
        Documento doc3 = new Documento("Documento muito secreto", 3);

        cadeia.enviarDocumento(doc1); // Deputado lerá
        cadeia.enviarDocumento(doc2); // Ministro lerá
        cadeia.enviarDocumento(doc3); // Presidente lerá

    }

}
