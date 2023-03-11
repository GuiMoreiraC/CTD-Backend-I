package Modulo_I.A03S.Mesa.Vendedor;

public class Afiliado extends Vendedor {

    public Afiliado(String nome) {
        super(nome);
    }

    @Override
    public void calcularPontos() {
        setPontos(getVendas() * 15);
    }
}
