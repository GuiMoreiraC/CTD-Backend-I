package Modulo_I.A02S.Mesa.Cardapio;

public class CardapioVegetariano extends Cardapio {
    private static final double PRECO_EMBALAGEM_ESPECIAL = 1.0;

    public CardapioVegetariano(String nome, double precoBase) {
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
                - Caixa personalizada
                - Temperos
                """, getNome());

    }

    @Override
    public double getPreco() {
        double precoTotal = PRECO_EMBALAGEM_ESPECIAL + getPrecoBase();
        precoTotal += precoTotal * 0.01; // sobretaxa de 1% para os condimentos
        return precoTotal;
    }
}
