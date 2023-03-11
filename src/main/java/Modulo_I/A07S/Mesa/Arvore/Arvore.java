package Modulo_I.A07S.Mesa.Arvore;

public class Arvore {

    private final int altura;
    private final int largura;
    private final String cor;
    private final String tipo;
    private static int contador;

    public Arvore(int altura, int largura, String cor, String tipo) {
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
        this.tipo = tipo;
        contador++;
        System.out.println("contador: " + contador);
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

    public String getCor() {
        return cor;
    }

    public String getTipo() {
        return tipo;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Arvore.contador = contador;
    }

}