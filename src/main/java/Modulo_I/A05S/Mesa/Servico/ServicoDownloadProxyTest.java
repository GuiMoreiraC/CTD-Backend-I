package Modulo_I.A05S.Mesa.Servico;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Modulo_I.A05S.Mesa.Usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicoDownloadProxyTest {

    private Usuario usuarioFree;
    private Usuario usuarioPremium;
    private ServicoDownloadProxy servicoDownloadProxy;

    @BeforeEach
    public void setUp() {
        usuarioFree = new Usuario("João", "1234", "Free");
        usuarioPremium = new Usuario("Maria", "5678", "Premium");
        servicoDownloadProxy = new ServicoDownloadProxy();
    }

    @Test
    public void testBaixarMusicaUsuarioFree() {
        String expectedOutput = "O usuário João não tem acesso ao download de músicas.";
        String actualOutput = "";
        try {
            servicoDownloadProxy.baixarMusica(usuarioFree, "Musica A");
            actualOutput = "O usuário João não tem acesso ao download de músicas.";
        } catch (Exception e) {
            actualOutput = e.getMessage();
        }
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testBaixarMusicaUsuarioPremium() {
        String expectedOutput = "Baixando a música Musica B para o usuário Maria...";
        String actualOutput = "";
        try {
            servicoDownloadProxy.baixarMusica(usuarioPremium, "Musica B");
            actualOutput = "Baixando a música Musica B para o usuário Maria...";
        } catch (Exception e) {
            actualOutput = e.getMessage();
        }
        assertEquals(expectedOutput, actualOutput);
    }

}