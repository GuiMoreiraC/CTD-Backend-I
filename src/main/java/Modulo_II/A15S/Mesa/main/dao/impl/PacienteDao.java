package Modulo_II.A15S.Mesa.main.dao.impl;

import Modulo_II.A15S.Mesa.main.config.ConfiguracaoJDBC;
import Modulo_II.A15S.Mesa.main.dao.IDao;
import Modulo_II.A15S.Mesa.main.model.Endereco;
import Modulo_II.A15S.Mesa.main.model.Paciente;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;

    private EnderecoDao enderecoDao;

    private static final Logger logger = LogManager.getLogger(String.valueOf(PacienteDao.class));


    public PacienteDao(EnderecoDao enderecoDao) {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDao = enderecoDao;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        logger.debug("Salvando novo paciente: " + paciente.toString());
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        PreparedStatement preparedStatement = null;
        paciente.setEndereco(enderecoDao.salvar(paciente.getEndereco()));
        String query = "INSERT INTO paciente (nome, sobrenome, rg, data_nascimento, endereco_id) VALUES (?, ?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getSobrenome());
            preparedStatement.setString(3, paciente.getRg());
            preparedStatement.setDate(4, new java.sql.Date(paciente.getDataNascimento().getTime()));
            preparedStatement.setInt(5, paciente.getEndereco().getId());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next())
                paciente.setId(generatedKeys.getInt(1));
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }


    @Override
    public List<Paciente> buscarTodos() {
        logger.debug("Buscando pacientes cadastrados...");
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = "SELECT * FROM paciente";
        List<Paciente> pacientes = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                pacientes.add(criarPaciente(resultSet));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    @Override
    public void excluir(int id) {
        logger.debug("Excluindo paciente com id: " + id);
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("DELETE FROM paciente WHERE id = '%s'", id);
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
    public Paciente buscarPorId(int id) {
        logger.debug("Buscando paciente com id: " + id);
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format("SELECT * FROM paciente WHERE id = '%s'", id);
        Paciente paciente = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                paciente = criarPaciente(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public Paciente criarPaciente(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String sobrenome = resultSet.getString("sobrenome");
        String rg = resultSet.getString("rg");
        Date dataNascimento = resultSet.getDate("data_nascimento");
        int enderecoId = resultSet.getInt("endereco_id");
        Endereco endereco = enderecoDao.buscarPorId(enderecoId);
        Paciente paciente = new Paciente(id, nome, sobrenome, rg, dataNascimento, endereco);
        return paciente;
    }

}
