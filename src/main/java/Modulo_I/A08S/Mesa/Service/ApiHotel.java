package Modulo_I.A08S.Mesa.Service;

import Modulo_I.A08S.Mesa.modd.Hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApiHotel {

    private List<Hotel> hoteis;

    public ApiHotel() {
        hoteis = new ArrayList<>();
        hoteis.add(new Hotel("Hotel A", "São Paulo", new Date(2023, 3, 21), new Date(2023, 3, 25)));
        hoteis.add(new Hotel("Hotel B", "Curitiba", new Date(2023, 3, 22), new Date(2023, 3, 24)));
        hoteis.add(new Hotel("Hotel C", "Rio de Janeiro", new Date(2023, 3, 23), new Date(2023, 3, 25)));
        hoteis.add(new Hotel("Hotel D", "São Paulo", new Date(2023, 3, 21), new Date(2023, 3, 25)));
    }

    public List<Hotel> buscarHoteis(String cidade, Date dataEntrada, Date dataSaida) {
        List<Hotel> hoteisDisponiveis = new ArrayList<>();
        for (Hotel hotel : hoteis) {
            if (hotel.getCidade().equals(cidade) && hotel.getDataEntrada().equals(dataEntrada) && hotel.getDataSaida().equals(dataSaida)) {
                hoteisDisponiveis.add(hotel);
            }
        }
        return hoteisDisponiveis;
    }
}
