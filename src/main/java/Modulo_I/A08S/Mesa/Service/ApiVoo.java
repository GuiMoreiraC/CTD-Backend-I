package Modulo_I.A08S.Mesa.Service;

import Modulo_I.A08S.Mesa.modd.Voo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiVoo {

    private List<Voo> voos;

    public ApiVoo() {
        voos = new ArrayList<>();
        voos.add(new Voo("São Paulo", "Rio de Janeiro", new Date(2023, 3, 21), new Date(2023, 3, 22)));
        voos.add(new Voo("São Paulo", "Curitiba", new Date(2023, 3, 22), new Date(2023, 3, 23)));
        voos.add(new Voo("Rio de Janeiro", "São Paulo", new Date(2023, 3, 23), new Date(2023, 3, 24)));
        voos.add(new Voo("Curitiba", "São Paulo", new Date(2023, 3, 21), new Date(2023, 3, 25)));
    }

    public List<Voo> buscarVoos(String destino, Date dataPartida, Date dataRetorno) {
        List<Voo> voosDisponiveis = new ArrayList<>();
        for (Voo voo : voos) {
            if (voo.getDestino().equals(destino) && voo.getDataPartida().equals(dataPartida) && voo.getDataRetorno().equals(dataRetorno)) {
                voosDisponiveis.add(voo);
            }
        }
        return voosDisponiveis;
    }
}