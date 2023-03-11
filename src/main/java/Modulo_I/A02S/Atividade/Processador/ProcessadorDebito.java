package Modulo_I.A02S.Atividade.Processador;

import Modulo_I.A02S.Atividade.cartao.Cartao;
import Modulo_I.A02S.Atividade.cartao.CartaoDebito;

public class ProcessadorDebito extends ProcessadorCartao {

    @Override
    protected void realizarPagamento(Cartao cartao, double valor) {
        CartaoDebito cartaoDebito = (CartaoDebito) cartao;
        double novoSaldoDisponivel = cartaoDebito.getSaldoDisponivel() - valor;
        cartaoDebito.setSaldoDisponivel(novoSaldoDisponivel);
    }

}
