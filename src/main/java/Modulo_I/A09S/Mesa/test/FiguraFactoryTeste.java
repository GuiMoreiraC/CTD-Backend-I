package Modulo_I.A09S.Mesa.test;

import Modulo_I.A09S.Aula.model.Quadrado;
import Modulo_I.A09S.Aula.model.Triangulo;
import Modulo_I.A09S.Aula.sevice.FiguraFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FiguraFactoryTeste {

    @Test
    void getTriangulo(){
        Triangulo triangulo = FiguraFactory.obterTriangulo("Vermelho");
        triangulo.setTamnaho(2);

        Triangulo triangulo1 = FiguraFactory.obterTriangulo("Vermelho");
        triangulo.setTamnaho(1);

        Assertions.assertEquals(triangulo.getCor(), "Vermelho");
        Assertions.assertEquals(triangulo1.getTamnaho(), 1);
        Assertions.assertEquals(FiguraFactory.trianguloHashMap.size() == 1, true);
    }

    @Test
    void getQuadrado(){

        Quadrado quadrado = FiguraFactory.obterQuadrado(2);
        quadrado.setCor("Verde");

        Quadrado quadrado1 = FiguraFactory.obterQuadrado(2);
        quadrado1.setCor("Vermelho");

        Assertions.assertEquals(quadrado.getTamnaho(), 2);
        Assertions.assertEquals(quadrado1.getCor(), "Vermelho");
        Assertions.assertEquals(FiguraFactory.quadradoHashMap.size() == 1, true);
    }

}
