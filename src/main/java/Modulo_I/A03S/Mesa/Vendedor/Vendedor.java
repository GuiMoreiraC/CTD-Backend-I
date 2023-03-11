package Modulo_I.A03S.Mesa.Vendedor;

public abstract class Vendedor {

    private String nome;
    private String categoria;
    private int vendas;
    private int pontos;

    public Vendedor(String nome) {
        this.nome = nome;
//        this.categoria = "novato";
    }

    public void vender(){
        vendas++;
    }

    public final void mostrarCategori() {
        calcularPontos();
        recategorizar();
        System.out.printf("""
                Dados do vendedor:
                Nome: %s
                Total de pontos: %d
                Categoria: %s
                """, nome, pontos, categoria);
    }

    public void recategorizar() {
        if (pontos < 20) {
            categoria = "novato";
        } else if (pontos <= 30) {
            categoria = "aprendiz";
        } else if (pontos <= 40) {
            categoria = "bom";
        } else {
            categoria = "mestre";
        }
    }

    public abstract void calcularPontos();

    public String getNome() {
        return nome;
    }

    public int getVendas() {
        return vendas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
