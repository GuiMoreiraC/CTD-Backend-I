package Modulo_I.A08S.Aula;

import Modulo_I.A08S.Aula.modd.Cartao;
import Modulo_I.A08S.Aula.modd.Produto;
import Modulo_I.A08S.Aula.service.impl.FacedeDesconto;

public class Main {

    public static void main(String[] args) {
        FacedeDesconto facade = new FacedeDesconto();
        Cartao cartao = new Cartao("123456789", "Star Bank");
        Produto produto = new Produto("Milho", "Lata");

        System.out.println(facade.desconto(cartao,produto,5));
    }
}
