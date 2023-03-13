package Modulo_II.A10S.Mesa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
//        System.out.println("Log4j configuration file path: " + System.getProperty("log4j.configurationFile"));
        try {
            ListaMedia listaMaior5 = new ListaMedia(Arrays.asList(1,2,3,4,5,6));
            ListaMedia listaMaior10 = new ListaMedia(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
            int listaMedia = new ListaMedia(Arrays.asList(1,2,3,4,5)).media();
            ListaMedia listaVazia = new ListaMedia(List.of());
        }catch (Exception e){
            logger.error("A Lista é igual a Zero", e);
        }

    }
}
