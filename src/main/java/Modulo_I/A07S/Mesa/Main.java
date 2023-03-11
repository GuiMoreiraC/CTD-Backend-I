package Modulo_I.A07S.Mesa;

import Modulo_I.A07S.Mesa.Arvore.Arvore;
import Modulo_I.A07S.Mesa.Arvore.ArvoreFactory;

public class Main {

    public static void main(String[] args) {

        ArvoreFactory arvoreFactory = new ArvoreFactory();

        int numArvores = 1000000;
        for (int i = 0; i < numArvores/3; i++) {
            Arvore ornamentalVerde = arvoreFactory.getArvore(200, 400, "verde", "ornamental");
        }
        for (int i = 0; i < numArvores/3; i++) {
            Arvore frutiferaVermelha = arvoreFactory.getArvore(500, 300, "vermelho", "frutifera");
        }
        for (int i = 0; i < numArvores/3; i++) {
            Arvore frutiferaVermelha = arvoreFactory.getArvore(100, 200, "azul", "Florífera");
        }

        System.out.println("Total de árvores: " + numArvores);

        Runtime runtime = Runtime.getRuntime();
        long memoriaUtilizada = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
        System.out.println("Memória utilizada: " + memoriaUtilizada + " MB");
    }

}