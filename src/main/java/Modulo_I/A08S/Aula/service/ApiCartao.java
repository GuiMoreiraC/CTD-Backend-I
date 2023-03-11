package Modulo_I.A08S.Aula.service;

import Modulo_I.A08S.Aula.modd.Cartao;

public class ApiCartao {

    public int desconto(Cartao cartao) {
        if (cartao.getBanco().trim().equalsIgnoreCase("Star Bank")) {
            return 20;
        }else {
            return 0;
        }

    }
}
