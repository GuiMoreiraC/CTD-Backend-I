package Modulo_I.A06S.Mesa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SerieTeste {

    @Test
    @DisplayName("Cria uma instância do proxy com número de visualizações abaixo do limite")
    void testaGetSerieComNumValidoDeVisualisacoes(){
        ISerie serie = new SerieProxy();
        System.out.println(serie.getSerie("Sopranos")); // Imprime "www.Sopranos"
        System.out.println(serie.getSerie("BreakingBad")); // Imprime "www.BreakingBad"
        System.out.println(serie.getSerie("GameOfThrones")); // Imprime "www.GameOfThrones"
        System.out.println(serie.getSerie("TheOffice")); // Imprime "www.TheOffice"
        System.out.println(serie.getSerie("ItsAlwaysSunnyInPhiladelphia")); // Imprime "www.ItsAlwaysSunnyInPhiladelphia"
        System.out.println("------------------------------------------------------------------------------");
    }

    @Test
    @DisplayName("Cria uma instância do proxy e verifica o prefixo")
    public void testaRetornoComPrefixoGetSeriet() {
        ISerie serie = new SerieProxy();
        assertEquals("www.Sopranos", serie.getSerie("Sopranos"));
        assertEquals("www.BreakingBad", serie.getSerie("BreakingBad"));
        assertEquals("www.GameOfThrones", serie.getSerie("GameOfThrones"));
        assertEquals("www.TheOffice", serie.getSerie("TheOffice"));
        assertEquals("www.ItsAlwaysSunnyInPhiladelphia", serie.getSerie("ItsAlwaysSunnyInPhiladelphia"));
    }

    @Test
    @DisplayName("Cria uma instância do proxy com número de visualizações acima do limite")
    void testaGetSerieComNumInvalidoDeVisualisacoes(){
        ISerie serie = new SerieProxy();
        System.out.println(serie.getSerie("Sopranos"));
        System.out.println(serie.getSerie("BreakingBad"));
        System.out.println(serie.getSerie("GameOfThrones"));
        System.out.println(serie.getSerie("TheOffice"));
        System.out.println(serie.getSerie("ItsAlwaysSunnyInPhiladelphia"));
        try {
            System.out.println(serie.getSerie("BlackMirror")); // Lança a exceção SerieNaoHabilitadaException
        } catch (SerieNaoHabilitadaException e) {
            System.out.println(e.getMessage()); // Imprime "Excede o número de reproduções permitidas."
        }
        System.out.println("------------------------------------------------------------------------------");
    }




}
