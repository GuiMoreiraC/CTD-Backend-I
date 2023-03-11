package Modulo_I.A02S.Atividade.Processador;

import Modulo_I.A02S.Atividade.cartao.Cartao;

public abstract class ProcessadorCartao {

    public final boolean processarPagamento(Cartao cartao, double valor) {
        if (cartao.autorizarPagamento(valor)) {
            realizarPagamento(cartao, valor);
            System.out.println("Pagamento realizado com sucesso!");
            return true;
        }

        System.out.println("Pagamento não autorizado!");
        return false;
    }

    protected abstract void realizarPagamento(Cartao cartao, double valor);

}