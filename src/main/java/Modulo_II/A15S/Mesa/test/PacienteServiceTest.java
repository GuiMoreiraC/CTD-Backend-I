package Modulo_II.A15S.Mesa.test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Modulo_II.A15S.Mesa.main.dao.impl.EnderecoDao;
import Modulo_II.A15S.Mesa.main.dao.impl.PacienteDao;
import Modulo_II.A15S.Mesa.main.model.Endereco;
import Modulo_II.A15S.Mesa.main.model.Paciente;


public class PacienteServiceTest {

    private EnderecoDao enderecoDao;
    private PacienteDao pacienteDao;
    private Paciente paciente1;
    private Paciente paciente2;

    @Before
    public void setUp() throws Exception {
        enderecoDao = new EnderecoDao();
        pacienteDao = new PacienteDao(enderecoDao);

        // criação de pacientes para os testes
        Endereco endereco1 = new Endereco("Rua A", "123", "Cidade A", "Bairro A");
        paciente1 = new Paciente("João", "Silva", "123456789", new Date(1980, 1, 1), endereco1);
        paciente1 = pacienteDao.salvar(paciente1);

        Endereco endereco2 = new Endereco("Rua B", "456", "Cidade B", "Bairro B");
        paciente2 = new Paciente("Maria", "Santos", "987654321", new Date(1985, 2, 2), endereco2);
        paciente2 = pacienteDao.salvar(paciente2);
    }

    @After
    public void clear() throws Exception {
        // exclusão dos pacientes criados nos testes
        pacienteDao.excluir(paciente1.getId());
        pacienteDao.excluir(paciente2.getId());
    }

    @Test
    public void testSalvar() {
        // adiciona um paciente e verifica se o mesmo foi salvo corretamente
        Endereco endereco = new Endereco("Rua C", "789", "Cidade C", "Bairro C");
        Paciente paciente = new Paciente("Luiz", "Oliveira", "742385321", new Date(1996, 5, 10), endereco);
        paciente = pacienteDao.salvar(paciente);
        Paciente pacienteBuscado = pacienteDao.buscarPorId(paciente.getId());
        assertEquals(paciente.getId(), pacienteBuscado.getId());
        assertEquals(paciente.getNome(), pacienteBuscado.getNome());
        assertEquals(paciente.getSobrenome(), pacienteBuscado.getSobrenome());
    }

    @Test
    public void testExcluir() {
        // exclui um paciente e verifica se o mesmo foi excluído corretamente
        pacienteDao.excluir(paciente1.getId());
        assertNull(pacienteDao.buscarPorId(paciente1.getId()));
    }

    @Test
    public void testBuscarTodos() {
        // busca todos os pacientes e verifica se a lista contém os pacientes criados nos testes
        List<Paciente> pacientes = pacienteDao.buscarTodos();

        boolean paciente1Encontrado = false;
        boolean paciente2Encontrado = false;

        for (Paciente paciente : pacientes) {
            if (paciente.getId() == paciente1.getId()) {
                paciente1Encontrado = true;
            } else if (paciente.getId() == paciente2.getId()) {
                paciente2Encontrado = true;
            }
        }

        assertTrue(paciente1Encontrado);
        assertTrue(paciente2Encontrado);
    }


    @Test
    public void testBuscarPorId() {
        // busca um paciente pelo ID e verifica se o mesmo é o paciente correto
        Paciente pacienteBuscado = pacienteDao.buscarPorId(paciente1.getId());
        assertEquals(paciente1.getId(), pacienteBuscado.getId());
        assertEquals(paciente1.getNome(), pacienteBuscado.getNome());
        assertEquals(paciente1.getSobrenome(), pacienteBuscado.getSobrenome());
    }

}