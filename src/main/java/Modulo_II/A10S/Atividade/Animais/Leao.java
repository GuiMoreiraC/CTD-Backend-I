package Modulo_II.A10S.Atividade.Animais;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Leao{

    private String nome;
    private int idade;
    private boolean eAlfa;

    public Leao(String nome, int idade, boolean eAlfa) {
        this.nome = nome;
        this.idade = idade;
        this.eAlfa = eAlfa;
    }

    public void correr() {
        Logger logger = LogManager.getLogger(Leao.class);
        logger.info("O Leão " + this.nome + " está correndo");
    }

    public void eMaiorque() throws Exception {
        Logger logger = LogManager.getLogger(Leao.class);
        if (this.idade < 0) {
            logger.error("A idade não pode ser negativa");
            throw new Exception("A idade do Leão " + this.nome + " está incorreta");
        }
        if (this.eAlfa && this.idade > 10) {
            logger.info("O Leão " + this.nome + " é alfa e tem mais de 10 anos");
        }
    }
}
