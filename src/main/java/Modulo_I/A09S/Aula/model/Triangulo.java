package Modulo_I.A09S.Aula.model;

public class Triangulo {

    private String cor;
    private int tamnaho;

    private static int contador;

    public Triangulo(String cor) {
        this.cor = cor;
        this.contador++;
        System.out.println("Criado uma nova instacia de Triangulo: " + contador);

    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamnaho() {
        return tamnaho;
    }

    public void setTamnaho(int tamnaho) {
        this.tamnaho = tamnaho;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Triangulo.contador = contador;
    }
}
