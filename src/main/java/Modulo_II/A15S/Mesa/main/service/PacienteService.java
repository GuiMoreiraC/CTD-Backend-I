package Modulo_II.A15S.Mesa.main.service;

import Modulo_II.A15S.Mesa.main.dao.IDao;
import Modulo_II.A15S.Mesa.main.model.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteDao;

    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteDao.salvar(paciente);
    }

    public List<Paciente> buscarTodos() {
        return pacienteDao.buscarTodos();
    }

    public void excluir(int id) {
        pacienteDao.excluir(id);
    }

    public Paciente buscarPorId(int id) {
        return pacienteDao.buscarPorId(id);
    }

}
