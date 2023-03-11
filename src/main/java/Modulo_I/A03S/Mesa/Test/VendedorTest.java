package Modulo_I.A03S.Mesa.Test;

import Modulo_I.A03S.Mesa.Vendedor.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendedorTest {

    private static Funcionario vendedor1;
    private static Funcionario vendedor2;
    private static Afiliado vendedor3;
    private static Afiliado vendedor4;

    @BeforeAll
    static void setUp() {
        vendedor1 = new Funcionario("João", 5);
        vendedor2 = new Funcionario("Maria",3);
        vendedor3 = new Afiliado("Luiz");
        vendedor4 = new Afiliado("André");

    }

    @Test
    @DisplayName("Teste de vendas por Funcionario")
    void testeVendasFuncionario() {
        vendedor1.vender();
        vendedor1.vender();
        vendedor1.obterAfiliado(vendedor3);
        vendedor1.calcularPontos();
        assertEquals(45, vendedor1.getPontos());
    }

    @Test
    @DisplayName("Teste de categoria por Funcionario")
    void testeCategoriaFuncionario() {
        vendedor2.vender();
        vendedor2.vender();
        vendedor2.mostrarCategori();
        assertEquals("aprendiz", vendedor2.getCategoria());
    }

    @Test
    @DisplayName("Teste de vendas por Afiliado")
    void testeVendasAfiliado() {
        vendedor3.vender();
        vendedor3.vender();
        vendedor3.calcularPontos();
        assertEquals(30, vendedor3.getPontos());
    }

    @Test
    @DisplayName("Teste de categoria por Afiliado")
    void testeCategoriaAfiliado() {
        vendedor4.vender();
        vendedor4.vender();
        vendedor4.vender();
        vendedor4.mostrarCategori();
        assertEquals("mestre", vendedor4.getCategoria());
    }
}