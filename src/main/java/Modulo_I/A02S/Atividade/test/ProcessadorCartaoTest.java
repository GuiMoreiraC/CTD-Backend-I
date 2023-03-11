package Modulo_I.A02S.Atividade.test;

import Modulo_I.A02S.Atividade.cartao.*;
import Modulo_I.A02S.Atividade.Processador.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessadorCartaoTest {

    private static CartaoCredito cartaoCredito;
    private static CartaoDebito cartaoDebito;

    @BeforeAll
    public static void setup() {
        cartaoCredito = new CartaoCredito("1111222233334444", 123, 12, 2025, 1000.0);
        cartaoDebito = new CartaoDebito("5555666677778888", 456, 12, 2025, 500.0);
    }

    @Test
    @DisplayName("Teste de pagamento autorizado com cartão de crédito")
    public void testePagamentoAutorizadoCartaoCredito() {
        ProcessadorCartao processadorCartao = new ProcessadorCredito();

        assertTrue(processadorCartao.processarPagamento(cartaoCredito, 500.0));
    }

    @Test
    @DisplayName("Teste de pagamento recusado com cartão de crédito")
    public void testePagamentoRecusadoCartaoCredito() {
        ProcessadorCartao processadorCartao = new ProcessadorCredito();

        assertFalse(processadorCartao.processarPagamento(cartaoCredito, 1500.0));
    }

    @Test
    @DisplayName("Teste de pagamento autorizado com cartão de débito")
    public void testePagamentoAutorizadoCartaoDebito() {
        ProcessadorCartao processadorCartao = new ProcessadorDebito();

        assertTrue(processadorCartao.processarPagamento(cartaoDebito, 300.0));
    }

    @Test
    @DisplayName("Teste de pagamento recusado com cartão de débito")
    public void testePagamentoRecusadoCartaoDebito() {
        ProcessadorCartao processadorCartao = new ProcessadorDebito();

        assertFalse(processadorCartao.processarPagamento(cartaoDebito, 600.0));
    }

}
