package Modulo_I.A05S.Atividade;

import java.util.List;

public class ServicoDocumentosProxy implements IDocumento {

    private IDocumento servicoDocumentos;
    private List<Usuario> usuariosAutorizados;

    public ServicoDocumentosProxy(IDocumento servicoDocumentos, List<Usuario> usuariosAutorizados) {
        this.servicoDocumentos = servicoDocumentos;
        this.usuariosAutorizados = usuariosAutorizados;
    }

    @Override
    public Documento acessaDocumento(String url, Usuario usuario) {
        if (usuariosAutorizados.contains(usuario)) {
            return servicoDocumentos.acessaDocumento(url, usuario);
        } else {
            return null;
        }
    }
}
