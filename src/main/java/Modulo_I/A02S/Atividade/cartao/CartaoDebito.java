package Modulo_I.A02S.Atividade.cartao;

public class CartaoDebito extends Cartao {
    private double saldoDisponivel;

    public CartaoDebito(String numero, int codigoSeguranca, int mesValidade, int anoValidade, double saldoDisponivel) {
        super(numero, codigoSeguranca, mesValidade, anoValidade);
        this.saldoDisponivel = saldoDisponivel;
    }

    @Override
    protected boolean verificarSaldo(double valor) {
        return valor <= saldoDisponivel;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }
}
