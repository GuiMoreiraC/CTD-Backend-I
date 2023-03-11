package Modulo_I.A04S.Atividade.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Modulo_I.A04S.Atividade.Documento.Documento;
import Modulo_I.A04S.Atividade.MembroGoverno.*;

public class CadeiaMembrosGovernoTest {

    private static CadeiaMembrosGoverno cadeia;

    @BeforeAll
    static void setup() {
        // Cria uma instância de CadeiaMembrosGoverno e adiciona membros
        MembroGoverno deputado1 = new Deputado("João");
        MembroGoverno deputado2 = new Deputado("Maria");
        MembroGoverno ministro1 = new Ministro("Carlos");
        MembroGoverno ministro2 = new Ministro("Julia");
        MembroGoverno presidente = new Presidente("José");

        cadeia = new CadeiaMembrosGoverno();
        cadeia.adicionarMembro(deputado1);
        cadeia.adicionarMembro(deputado2);
        cadeia.adicionarMembro(ministro1);
        cadeia.adicionarMembro(ministro2);
        cadeia.adicionarMembro(presidente);
    }

    @Test
    @DisplayName("Documento com nível de acesso 1 deve ser lido pelo deputado")
    void testEnviarDocumentoNivel1() {
        Documento documento = new Documento("Documento reservado", 1);
        assertDoesNotThrow(() -> cadeia.enviarDocumento(documento));
    }

    @Test
    @DisplayName("Documento com nível de acesso 2 deve ser lido pelo ministro")
    void testEnviarDocumentoNivel2() {
        Documento documento = new Documento("Documento secreto", 2);
        assertDoesNotThrow(() -> cadeia.enviarDocumento(documento));
    }

    @Test
    @DisplayName("Documento com nível de acesso 3 deve ser lido pelo presidente")
    void testEnviarDocumentoNivel3() {
        Documento documento = new Documento("Documento muito secreto", 3);
        assertDoesNotThrow(() -> cadeia.enviarDocumento(documento));
    }

    @Test
    @DisplayName("Documento com nível de acesso maior que o máximo deve lançar exceção")
    void testEnviarDocumentoNivelMuitoAlto() {
        Documento documento = new Documento("Documento ultrassecreto", 4);
        assertThrows(RuntimeException.class, () -> cadeia.enviarDocumento(documento));
    }
}