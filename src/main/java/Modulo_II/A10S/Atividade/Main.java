package Modulo_II.A10S.Atividade;

import Modulo_II.A10S.Atividade.Animais.Leao;
import Modulo_II.A10S.Atividade.Animais.Tigre;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        Leao leao1 = new Leao("Simba", 5, false);
        Leao leao2 = new Leao("Mufasa", -2, true);
        Tigre tigre1 = new Tigre("Rajah", 3);
        Tigre tigre2 = new Tigre("Shere Khan", 6);

        leao1.correr();
        leao2.correr();
        try {
            leao1.eMaiorque();
            leao2.eMaiorque();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        tigre1.correr();
        tigre2.correr();
        try {
            tigre1.eMaiorQue10();
            tigre2.eMaiorQue10();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}