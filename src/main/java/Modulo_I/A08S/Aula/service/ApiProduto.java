package Modulo_I.A08S.Aula.service;

import Modulo_I.A08S.Aula.modd.Produto;

public class ApiProduto {

    public  int desconto(Produto produto) {
        if (produto.getTipo().equalsIgnoreCase("Lata")){
            return 10;
        } else {
            return 0;
        }
    }

}
