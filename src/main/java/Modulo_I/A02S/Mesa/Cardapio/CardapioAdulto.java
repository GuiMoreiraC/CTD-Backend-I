package Modulo_I.A02S.Mesa.Cardapio;

public class CardapioAdulto extends Cardapio {

    public CardapioAdulto(String nome, double precoBase) {
        super(nome, precoBase);
    }

    @Override
    public void montarCardapio() {
        System.out.printf("""
                =================================
                             PEDIDO            \s
                =================================
                Produto: %s
                Adicionais:
                """, getNome());

    }

    @Override
    public double getPreco() {
        return getPrecoBase();
    }
}
