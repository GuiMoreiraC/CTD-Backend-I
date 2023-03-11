package Modulo_I.A07S.Mesa.Arvore;

import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private final Map<String, Arvore> arvores = new HashMap<>();

    public Arvore getArvore(int altura, int largura, String cor, String tipo) {
        String chave = tipo + cor;
        Arvore arvore;

        if (arvores.containsKey(chave)) {
            arvore = arvores.get(chave);
            System.out.println("Arvore obtida - Tipo: " + arvore.getTipo() + ", Contador: " + Arvore.getContador());
        } else {
            arvore = new Arvore(altura, largura, cor, tipo);
            arvores.put(chave, arvore);
            System.out.println("Arvore criada - Tipo: " + arvore.getTipo() + ", Contador: " + Arvore.getContador());
        }

        return arvore;
    }

}
