package Modulo_I.A01S.Mesa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FiguraTest {


    @Test
    public void testCalcularPerimetroCirculo() {
        double raio = 3.0;
        double perimetroEsperado = 2 * Math.PI * raio;
        Circulo circulo = new Circulo(raio);
        double perimetroCalculado = circulo.calcularPerimetro();
        assertEquals(perimetroEsperado, perimetroCalculado, 0.001);
    }

    @Test
    public void testCalcularPerimetroQuadrado() {
        double lado = 4.0;
        double perimetroEsperado = 4 * lado;
        Quadrado quadrado = new Quadrado(lado);
        double perimetroCalculado = quadrado.calcularPerimetro();
        assertEquals(perimetroEsperado, perimetroCalculado, 0.001);
    }

}