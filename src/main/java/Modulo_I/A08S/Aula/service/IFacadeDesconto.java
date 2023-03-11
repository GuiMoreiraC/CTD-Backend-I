package Modulo_I.A08S.Aula.service;

import Modulo_I.A08S.Aula.modd.Cartao;
import Modulo_I.A08S.Aula.modd.Produto;

public interface IFacadeDesconto {

    int desconto(Cartao cartao, Produto produto, int quantidade);

}
