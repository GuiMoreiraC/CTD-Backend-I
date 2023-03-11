package Modulo_I.A04S.Mesa.Test;

import Modulo_I.A04S.Mesa.Artigo.Artigo;
import Modulo_I.A04S.Mesa.ControleQualidade.CheckQuality;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckQualityTest {


    @Test
    public void testVerificarArtigoPassa() {
        CheckQuality checkQuality = new CheckQuality();

        Artigo artigo1 = new Artigo("Arroz", 1500, 1250, "Saudável");
        assertTrue(checkQuality.verificar(artigo1));

    }

    @Test
    public void testVerificarArtigoFalha() {
        CheckQuality checkQuality = new CheckQuality();

        Artigo artigo2 = new Artigo("Feijão", 3000, 1400, "Quase saudável");
        assertFalse(checkQuality.verificar(artigo2));

        Artigo artigo3 = new Artigo("Macarrão", 1200, 1500, "Comum");
        assertFalse(checkQuality.verificar(artigo3));

    }
}
