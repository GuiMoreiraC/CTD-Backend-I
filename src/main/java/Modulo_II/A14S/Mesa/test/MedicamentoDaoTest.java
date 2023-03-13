package Modulo_II.A14S.Mesa.test;

import Modulo_II.A14S.Mesa.main.config.ConfiguracaoJDBC;
import Modulo_II.A14S.Mesa.main.dao.impl.MedicamentoDao;
import Modulo_II.A14S.Mesa.main.model.Medicamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicamentoDaoTest {

    private MedicamentoDao medicamentoDao;

    @BeforeEach
    public void setup() {
        ConfiguracaoJDBC configuracaoJDBC = new ConfiguracaoJDBC();
        medicamentoDao = new MedicamentoDao(configuracaoJDBC);
    }

    @Test
    public void testSalvar() {
        Medicamento medicamento = new Medicamento("Dorflex", "Sanofi", 10, 15.99);
        Medicamento medicamentoSalvo = medicamentoDao.salvar(medicamento);
        Assertions.assertNotNull(medicamentoSalvo.getId());
    }

    @Test
    public void testBuscarPorId() {
        Medicamento medicamento = medicamentoDao.buscarPorId(1);
        Medicamento expected = new Medicamento(1, "Dorflex", "Sanofi", 10, 15.99);
        assertEquals(expected.getNome(), medicamento.getNome());
    }

}
