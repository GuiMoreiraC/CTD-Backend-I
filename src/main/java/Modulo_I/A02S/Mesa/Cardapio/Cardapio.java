package Modulo_I.A02S.Mesa.Cardapio;

public abstract class Cardapio {
    private String nome;
    private double precoBase;

    public Cardapio(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public final void preparar() {
        montarCardapio();
        System.out.printf("""
                
                Total: %.2f%n
                ---------------------------------
                """, getPreco());
    }

    public abstract void montarCardapio();

    public abstract double getPreco();

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

}
