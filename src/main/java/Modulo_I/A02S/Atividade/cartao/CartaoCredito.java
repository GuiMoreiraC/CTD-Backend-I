package Modulo_I.A02S.Atividade.cartao;

public class CartaoCredito extends Cartao {
    private double limite;
    private double saldoUtilizado;

    public CartaoCredito(String numero, int codigoSeguranca, int mesValidade, int anoValidade, double limite) {
        super(numero, codigoSeguranca, mesValidade, anoValidade);
        this.limite = limite;
        this.saldoUtilizado = 0;
    }

    @Override
    protected boolean verificarSaldo(double valor) {
        return saldoUtilizado + valor <= limite;
    }

    public double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
    }
}
