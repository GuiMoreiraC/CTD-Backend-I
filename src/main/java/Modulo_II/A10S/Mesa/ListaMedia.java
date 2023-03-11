package Modulo_II.A10S.Mesa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ListaMedia {

    private static final Logger logger = LogManager.getLogger(String.valueOf(ListaMedia.class));

    private List<Integer> lista;

    public ListaMedia(List<Integer> lista) throws Exception {
        this.lista = lista;
        compararLista(lista);
    }

    public void compararLista(List<Integer> inteiros) throws Exception {
        if (inteiros.size() > 10){
            logger.info("O comprimento da lista é maior que 10");
            return;
        }
        if (inteiros.size() > 5){
            logger.info("O comprimento da lista é maior que 5");
            return;
        }
        if (inteiros.size() == 0){
            throw new Exception();
        }

    }

    public int media(){
        int soma = 0;
        for (Integer inteiro : lista){
            soma += inteiro;
        }
        int media = soma / lista.size();
        logger.info("A média da lista é: " + media);

        return media;
    }
}
