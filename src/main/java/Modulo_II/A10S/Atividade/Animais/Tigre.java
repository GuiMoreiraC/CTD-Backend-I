package Modulo_II.A10S.Atividade.Animais;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tigre {
    private String nome;
    private int idade;

    public Tigre(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void correr() {
        Logger logger = LogManager.getLogger(Tigre.class);
        logger.info("O Tigre " + this.nome + " está correndo");
    }

    public void eMaiorQue10() throws Exception {
        Logger logger = LogManager.getLogger(Tigre.class);
        if (this.idade < 0) {
            logger.error("A idade não pode ser negativa");
            throw new Exception("A idade do Tigre " + this.nome + " está incorreta");
        }
    }
}
