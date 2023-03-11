package Modulo_I.A02S.Mesa.Cardapio;

public class CardapioInfantil extends Cardapio {
    private static final double PRECO_BRINQUEDO = 2.5;

    public CardapioInfantil(String nome, double precoBase) {
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
                - Presente surpresa
                """, getNome());
    }

    @Override
    public double getPreco() {
        return PRECO_BRINQUEDO + getPrecoBase();
    }
}
