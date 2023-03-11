package Modulo_I.A05S.Atividade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicoDocumentos implements IDocumento {

    private List<Documento> documentos;

    public ServicoDocumentos() {
        documentos = new ArrayList<>();
    }

    @Override
    public Documento acessaDocumento(String url, Usuario usuario) {
        Documento documento = documentos.stream()
                .filter(d -> d.getUrl().equals(url))
                .filter(d -> d.getUsuariosAutorizados().contains(usuario))
                .findFirst()
                .orElse(null);

        if (documento != null) {
            documento.addAcesso(LocalDateTime.now());
        }

        return documento;
    }

    public void adicionaDocumento(Documento documento) {
        documentos.add(documento);
    }
}
