package Modulo_I.A03S.Mesa.Vendedor;

public class Estagiario extends Vendedor {
    public Estagiario(String nome) {
        super(nome);
    }

    @Override
    public void calcularPontos() {
        setPontos(getVendas() * 5);
    }

    @Override
    public void recategorizar() {
        if (this.getPontos() < 50) {
            this.setCategoria("estagiário novato");
        } else {
            this.setCategoria("estagiário experiente");
        }
    }
}
