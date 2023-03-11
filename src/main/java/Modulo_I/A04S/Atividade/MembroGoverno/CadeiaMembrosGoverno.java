package Modulo_I.A04S.Atividade.MembroGoverno;

import Modulo_I.A04S.Atividade.Documento.Documento;

import java.util.ArrayList;
import java.util.List;

public class CadeiaMembrosGoverno {

    private List<MembroGoverno> membros = new ArrayList<>();

    public void adicionarMembro(MembroGoverno membro) {
        membros.add(membro);
    }

    public void enviarDocumento(Documento documento) {
        if (documento.getNivelAcesso() > 3) {
            throw new RuntimeException("Documento com nível de acesso maior que o máximo permitido");
        }
        for (MembroGoverno membro : membros) {
            if (documento.getNivelAcesso() <= membro.getNivelAcesso()) {
                membro.lerDocumento(documento);
            }
        }
    }

}

