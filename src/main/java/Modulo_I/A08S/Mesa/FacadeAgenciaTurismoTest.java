package Modulo_I.A08S.Mesa;

import Modulo_I.A08S.Mesa.modd.*;
import Modulo_I.A08S.Mesa.Service.*;
import Modulo_I.A08S.Mesa.Service.impl.FacadeAgenciaTurismo;


import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class FacadeAgenciaTurismoTest {

    @Test
    public void testBuscarPacoteTuristico() {
        FacadeAgenciaTurismo facade = new FacadeAgenciaTurismo();

        // Define as datas de partida, retorno e cidade de destino
        Date dataPartida = new Date(2023, 3, 21);
        Date dataRetorno = new Date(2023, 3, 25);
        String cidadeDestino = "São Paulo";

        facade.buscarPacoteTuristico(dataPartida, dataRetorno, cidadeDestino);

        // Verifica se foram encontrados voos
        ApiVoo apiVoo = new ApiVoo();
        List<Voo> voos = apiVoo.buscarVoos(cidadeDestino, dataPartida, dataRetorno);
        assertFalse(voos.isEmpty());

        // Verifica se foram encontrados hotéis
        ApiHotel apiHotel = new ApiHotel();
        List<Hotel> hoteis = apiHotel.buscarHoteis(cidadeDestino, dataPartida, dataRetorno);
        assertFalse(hoteis.isEmpty());
    }
}