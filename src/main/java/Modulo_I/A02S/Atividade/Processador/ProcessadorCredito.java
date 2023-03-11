package Modulo_I.A02S.Atividade.Processador;

import Modulo_I.A02S.Atividade.cartao.Cartao;
import Modulo_I.A02S.Atividade.cartao.CartaoCredito;

public class ProcessadorCredito extends ProcessadorCartao {

    @Override
    protected void realizarPagamento(Cartao cartao, double valor) {
        CartaoCredito cartaoCredito = (CartaoCredito) cartao;
        double novoSaldoUtilizado = cartaoCredito.getSaldoUtilizado() + valor;
        cartaoCredito.setSaldoUtilizado(novoSaldoUtilizado);
    }

}
