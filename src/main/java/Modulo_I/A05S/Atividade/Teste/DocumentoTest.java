package Modulo_I.A05S.Atividade.Teste;

import Modulo_I.A05S.Atividade.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DocumentoTest {

    private ServicoDocumentos servicoDocumentos;
    private IDocumento servicoDocumentosProxy;
    private Usuario usuario1;
    private Usuario usuario2;
    private Documento documento1;
    private Documento documento2;

    @BeforeEach
    public void setup() {
        servicoDocumentos = new ServicoDocumentos();
        usuario1 = new Usuario("usuario1@teste.com");
        usuario2 = new Usuario("usuario2@teste.com");
        List<Usuario> usuariosAutorizados = new ArrayList<>();
        usuariosAutorizados.add(usuario1);
        usuariosAutorizados.add(usuario2);
        documento1 = new Documento(1, "https://www.teste.com/doc1", "Conteúdo do Documento 1", usuariosAutorizados);
        documento2 = new Documento(2, "https://www.teste.com/doc2", "Conteúdo do Documento 2", usuariosAutorizados);
        servicoDocumentos.adicionaDocumento(documento1);
        servicoDocumentos.adicionaDocumento(documento2);
        List<Usuario> usuariosAutorizadosProxy = new ArrayList<>();
        usuariosAutorizadosProxy.add(usuario1);
        servicoDocumentosProxy = new ServicoDocumentosProxy(servicoDocumentos, usuariosAutorizadosProxy);
    }

    @Test
    public void testAcessoDocumentoComUsuarioAutorizado() {
        Documento documentoAcessado = servicoDocumentos.acessaDocumento("https://www.teste.com/doc1", usuario1);
        Assertions.assertEquals(documento1, documentoAcessado);
        Assertions.assertEquals(1, documentoAcessado.getAcessos().size());
    }

    @Test
    public void testAcessoDocumentoComUsuarioNaoAutorizado() {
        Documento documentoAcessado = servicoDocumentos.acessaDocumento("https://www.teste.com/doc1", new Usuario("usuario3@teste.com"));
        Assertions.assertNull(documentoAcessado);
    }

    @Test
    public void testAcessoDocumentoComUsuarioAutorizadoProxy() {
        Documento documentoAcessado = servicoDocumentosProxy.acessaDocumento("https://www.teste.com/doc1", usuario1);
        Assertions.assertEquals(documento1, documentoAcessado);
        Assertions.assertEquals(1, documentoAcessado.getAcessos().size());
    }

    @Test
    public void testAcessoDocumentoComUsuarioNaoAutorizadoProxy() {
        Documento documentoAcessado = servicoDocumentosProxy.acessaDocumento("https://www.teste.com/doc1", usuario2);
        Assertions.assertNull(documentoAcessado);
    }
}
