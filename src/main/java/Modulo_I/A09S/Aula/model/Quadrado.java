package Modulo_I.A09S.Aula.model;

public class Quadrado {

    private String cor;
    private int tamnaho;

    private static int contador;

    public Quadrado(int tamnaho) {
        this.tamnaho = tamnaho;
        this.contador++;
        System.out.println("Criado uma nova instacia de Quadrado : " + contador);
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
        Quadrado.contador = contador;
    }
}
