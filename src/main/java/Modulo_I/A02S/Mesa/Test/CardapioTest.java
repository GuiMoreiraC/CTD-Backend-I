package Modulo_I.A02S.Mesa.Test;

import Modulo_I.A02S.Mesa.Cardapio.Cardapio;
import Modulo_I.A02S.Mesa.Cardapio.CardapioAdulto;
import Modulo_I.A02S.Mesa.Cardapio.CardapioInfantil;
import Modulo_I.A02S.Mesa.Cardapio.CardapioVegetariano;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardapioTest {
    private static Cardapio cardapioAdulto;
    private static Cardapio cardapioInfantil;
    private static Cardapio cardapioVegetariano;

    @BeforeAll
    static void setup() {
        cardapioAdulto = new CardapioAdulto("Cardapio Adulto", 15.0);
        cardapioInfantil = new CardapioInfantil("Cardapio Infantil", 15.0);
        cardapioVegetariano = new CardapioVegetariano("Cardapio Vegetariano", 15.0);
    }

    @Test
    @DisplayName("Teste do Cardápio Adulto")
    void testCardapioAdulto() {
        assertEquals("Cardapio Adulto", cardapioAdulto.getNome());
        assertEquals(15.0, cardapioAdulto.getPrecoBase());
        assertEquals(15.0, cardapioAdulto.getPreco());
        cardapioAdulto.preparar();
    }

    @Test
    @DisplayName("Teste do Cardápio Infantil")
    void testCardapioInfantil() {
        assertEquals("Cardapio Infantil", cardapioInfantil.getNome());
        assertEquals(15.0, cardapioInfantil.getPrecoBase());
        assertEquals(17.5, cardapioInfantil.getPreco());
        cardapioInfantil.preparar();
    }

    @Test
    @DisplayName("Teste do Cardápio Vegetariano")
    void testCardapioVegetariano() {
        assertEquals("Cardapio Vegetariano", cardapioVegetariano.getNome());
        assertEquals(15.0, cardapioVegetariano.getPrecoBase());
        assertEquals(16.16, cardapioVegetariano.getPreco());
        cardapioVegetariano.preparar();
    }

}