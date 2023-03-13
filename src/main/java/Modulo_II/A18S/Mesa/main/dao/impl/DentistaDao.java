package Modulo_II.A18S.Mesa.main.dao.impl;

import Modulo_II.A18S.Mesa.main.config.ConfiguracaoJDBC;
import Modulo_II.A18S.Mesa.main.dao.IDao;
import Modulo_II.A18S.Mesa.main.model.Dentista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class DentistaDao implements IDao<Dentista> {

    private ConfiguracaoJDBC configuracaoJDBC;

    private static final Logger logger = LogManager.getLogger(String.valueOf(DentistaDao.class));


    public DentistaDao() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    @Override
    public Dentista salvar(Dentista dentista) {
        logger.debug("Salvando novo Dentista: " + dentista.toString());
        String query = "INSERT INTO dentista (nome, sobrenome, matricula) VALUES (?, ?, ?)";
        try (Connection connection = configuracaoJDBC.conectarComBancoDeDados();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, dentista.getNome());
            statement.setString(2, dentista.getSobrenome());
            statement.setString(3, dentista.getMatricula());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    dentista.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            logger.error("Erro ao salvar o Dentista: " + dentista.toString(), e);
        }
        return dentista;
    }

    @Override
    public List<Dentista> buscarTodos() {
        return null;
    }

    @Override
    public void excluir(int id) {

    }

    @Override
    public Dentista buscarPorId(int id) {
        return null;
    }
}
