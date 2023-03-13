package Modulo_II.A18S.Mesa.main.service;

import Modulo_II.A18S.Mesa.main.dao.IDao;
import Modulo_II.A18S.Mesa.main.dao.impl.DentistaDao;
import Modulo_II.A18S.Mesa.main.model.Dentista;

public class DentistaService {

    private IDao<Dentista> dentistaIDao;

    public DentistaService() {
        this.dentistaIDao = new DentistaDao();
    }

    public Dentista salvar(Dentista dentista) {
        return dentistaIDao.salvar(dentista);
    }

}
