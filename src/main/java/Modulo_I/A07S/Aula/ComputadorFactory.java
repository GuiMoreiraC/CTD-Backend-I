package Modulo_I.A07S.Aula;

import java.util.HashMap;
import java.util.Map;

public class ComputadorFactory {

    private static Map<String, Computador> flyweight = new HashMap<>();

    public Computador getComputador(int ram, int hd) {

        String id = "id: " + ram + ":" + hd;

        System.out.println(id);

        if (!flyweight.containsKey(id)) {
            Computador computador = new Computador(ram, hd);
            flyweight.put(id, computador);
            System.out.println("PC criado");
            return flyweight.get(id);
        }

        System.out.println("PC obtido");

        return flyweight.get(id);
    }

}
