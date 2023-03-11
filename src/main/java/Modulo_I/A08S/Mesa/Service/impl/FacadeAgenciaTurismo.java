package Modulo_I.A08S.Mesa.Service.impl;

import Modulo_I.A08S.Mesa.modd.Hotel;
import Modulo_I.A08S.Mesa.modd.Voo;
import Modulo_I.A08S.Mesa.Service.ApiHotel;
import Modulo_I.A08S.Mesa.Service.ApiVoo;
import Modulo_I.A08S.Mesa.Service.IFacadeAgenciaTurismo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class FacadeAgenciaTurismo implements IFacadeAgenciaTurismo {

    private ApiVoo apiVoo;
    private ApiHotel apiHotel;

    public FacadeAgenciaTurismo() {
        this.apiVoo = new ApiVoo();
        this.apiHotel = new ApiHotel();
    }

    @Override
    public void buscarPacoteTuristico(Date dataPartida, Date dataRetorno, String cidadeDestino) {

        List<Voo> voos = apiVoo.buscarVoos(cidadeDestino, dataPartida, dataRetorno);
        List<Hotel> hoteis = apiHotel.buscarHoteis(cidadeDestino, dataPartida, dataRetorno);

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setTimeZone(TimeZone.getTimeZone("GMT-3"));

        System.out.println("Cidade: " + cidadeDestino);
//        System.out.println("Data de partida: " + formato.format(dataPartida) + " Data retorno " + formato.format(dataRetorno));

        System.out.println("------------------------------");

        System.out.println("Voos encontrados:");
        for (Voo voo : voos) {
            System.out.println("+ Voo com origem " + voo.getOrigem() + " e destino " + voo.getDestino());
        }

        System.out.println("Hoteis encontrados:");
        for (Hotel hotel : hoteis) {
            System.out.println("+ " + hotel.getNome() + " - " + hotel.getCidade());
        }

    }
}
