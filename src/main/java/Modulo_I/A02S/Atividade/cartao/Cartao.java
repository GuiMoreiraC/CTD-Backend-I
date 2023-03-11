package Modulo_I.A02S.Atividade.cartao;

import java.time.LocalDate;

public abstract class Cartao {
    private String numero;
    private int codigoSeguranca;
    private LocalDate dataValidade;

    public Cartao(String numero, int codigoSeguranca, int mesValidade, int anoValidade) {
        this.numero = numero;
        this.codigoSeguranca = codigoSeguranca;
        this.dataValidade = LocalDate.of(anoValidade, mesValidade, 1);
    }

    public final boolean autorizarPagamento(double valor){
        if (LocalDate.now().isAfter(dataValidade)){
            System.out.println("Cartão vencido!");
            return false;
        }

        boolean autorizado = verificarSaldo(valor);

        if (autorizado)
            System.out.println("Pagamento autorizado!");
        else
            System.out.println("Saldo insuficiente!");

        return autorizado;
    }

    protected abstract boolean verificarSaldo(double valor);
}
