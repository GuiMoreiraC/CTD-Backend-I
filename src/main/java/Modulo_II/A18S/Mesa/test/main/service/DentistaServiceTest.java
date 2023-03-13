package Modulo_II.A18S.Mesa.test.main.service;

import static org.junit.jupiter.api.Assertions.*;

import Modulo_II.A18S.Mesa.main.model.Dentista;
import Modulo_II.A18S.Mesa.main.service.DentistaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DentistaServiceTest {

    private DentistaService dentistaService;

    @BeforeEach
    public void setUp() {
        dentistaService = new DentistaService();
    }

    @Test
    public void salvar() {
        // Crie um objeto Dentista com dados de teste
        Dentista dentista = new Dentista(0, "João", "Silva", "12345");

        // Salve o Dentista usando o serviço
        Dentista resultado = dentistaService.salvar(dentista);

        // Verifique se o objeto retornado pelo método salvar() não é nulo
        assertNotNull(resultado);

        // Verifique se o objeto retornado pelo método salvar() possui um ID maior que 0
        assertTrue(resultado.getId() > 0);

        // Verifique se os dados do objeto salvo são iguais aos dados do objeto original
        assertEquals(dentista.getNome(), resultado.getNome());
        assertEquals(dentista.getSobrenome(), resultado.getSobrenome());
        assertEquals(dentista.getMatricula(), resultado.getMatricula());
    }

}
