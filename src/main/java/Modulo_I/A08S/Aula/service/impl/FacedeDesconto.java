package Modulo_I.A08S.Aula.service.impl;

import Modulo_I.A08S.Aula.modd.Cartao;
import Modulo_I.A08S.Aula.modd.Produto;
import Modulo_I.A08S.Aula.service.ApiCartao;
import Modulo_I.A08S.Aula.service.ApiProduto;
import Modulo_I.A08S.Aula.service.ApiQuantidade;
import Modulo_I.A08S.Aula.service.IFacadeDesconto;

public class FacedeDesconto implements IFacadeDesconto {

private ApiCartao apiCartao;
private ApiProduto apiProduto;
private ApiQuantidade apiQuantidade;

    public FacedeDesconto() {
        this.apiCartao = new ApiCartao();
        this.apiProduto = new ApiProduto();
        this.apiQuantidade = new ApiQuantidade();
    }

    @Override
    public int desconto(Cartao cartao, Produto produto, int quantidade) {
        int desconto = 0;
        desconto += apiCartao.desconto(cartao);
        desconto += apiProduto.desconto(produto);
        desconto += apiQuantidade.desconto(quantidade);


        return desconto;
    }
}
