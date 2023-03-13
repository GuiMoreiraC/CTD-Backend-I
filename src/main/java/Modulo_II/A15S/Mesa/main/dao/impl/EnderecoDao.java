package Modulo_II.A15S.Mesa.main.dao.impl;

import Modulo_II.A15S.Mesa.main.config.ConfiguracaoJDBC;
import Modulo_II.A15S.Mesa.main.dao.IDao;
import Modulo_II.A15S.Mesa.main.model.Endereco;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao implements IDao<Endereco> {

    private ConfiguracaoJDBC configuracaoJDBC;

    private static final Logger logger = LogManager.getLogger(String.valueOf(EnderecoDao.class));

    public EnderecoDao() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        logger.debug("Salvando novo endereço: " + endereco.toString());
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO endereco (rua, numero, cidade, bairro) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, endereco.getRua());
            preparedStatement.setString(2, endereco.getNumero());
            preparedStatement.setString(3, endereco.getCidade());
            preparedStatement.setString(4, endereco.getBairro());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next())
                endereco.setId(generatedKeys.getInt(1));
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public List<Endereco> buscarTodos() {
        logger.debug("Buscando enderecos cadastrados...");
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = "SELECT * FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                enderecos.add(criarEndereco(resultSet));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enderecos;
    }

    @Override
    public void excluir(int id) {
        logger.debug("Excluindo endereco com id: " + id);
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("DELETE FROM endereco WHERE id = '%s'", id);
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Endereco buscarPorId(int id) {
        logger.debug("Buscando endereco com id: " + id);
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("SELECT * FROM endereco WHERE id = '%s'", id);
        Endereco endereco = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                endereco = criarEndereco(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

    public Endereco criarEndereco(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String rua = resultSet.getString("rua");
        String numero = resultSet.getString("numero");
        String cidade = resultSet.getString("cidade");
        String bairro = resultSet.getString("bairro");
        Endereco endereco = new Endereco(id, rua, numero, cidade, bairro);
        return endereco;
    }

}
