package Modulo_II.A14S.Mesa.main.service;

import Modulo_II.A14S.Mesa.main.dao.IDao;
import Modulo_II.A14S.Mesa.main.model.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento salvar(Medicamento medicamento) {
        return medicamentoDao.salvar(medicamento);
    }

    public Medicamento buscarPorId(int id) {
        return medicamentoDao.buscarPorId(id);
    }
}
