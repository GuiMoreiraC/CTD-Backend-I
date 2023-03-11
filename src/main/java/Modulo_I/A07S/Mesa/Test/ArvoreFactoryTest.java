package Modulo_I.A07S.Mesa.Test;

import Modulo_I.A07S.Mesa.Arvore.Arvore;
import Modulo_I.A07S.Mesa.Arvore.ArvoreFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArvoreFactoryTest {

    private ArvoreFactory arvoreFactory;

    @BeforeEach
    public void setUp() {
        arvoreFactory = new ArvoreFactory();
        Arvore.setContador(0);
    }

    @Test
    public void testContador() {
        int numArvores = 1000000;
        for (int i = 0; i < numArvores / 3; i++) {
            arvoreFactory.getArvore(200, 400, "verde", "ornamental");
        }
        for (int i = 0; i < numArvores / 3; i++) {
            arvoreFactory.getArvore(500, 300, "vermelho", "frutifera");
        }
        for (int i = 0; i < numArvores / 3; i++) {
            arvoreFactory.getArvore(100, 200, "azul", "Florífera");
        }

        Assertions.assertEquals(3, Arvore.getContador(), "O contador de árvores não está correto.");
    }

    @Test
    public void testArvoreUnica() {
        ArvoreFactory arvoreFactory = new ArvoreFactory();
        Arvore arvore1 = arvoreFactory.getArvore(200, 400, "verde", "ornamental");
        Arvore arvore2 = arvoreFactory.getArvore(200, 400, "verde", "ornamental");

        Assertions.assertSame(arvore1, arvore2, "As duas árvores deveriam ser a mesma instância.");
    }

    @Test
    public void testArvoresDiferentes() {
        ArvoreFactory arvoreFactory = new ArvoreFactory();
        Arvore arvore1 = arvoreFactory.getArvore(200, 400, "verde", "ornamental");
        Arvore arvore2 = arvoreFactory.getArvore(500, 300, "vermelho", "frutifera");

        Assertions.assertNotSame(arvore1, arvore2, "As duas árvores não deveriam ser a mesma instância.");
    }
}