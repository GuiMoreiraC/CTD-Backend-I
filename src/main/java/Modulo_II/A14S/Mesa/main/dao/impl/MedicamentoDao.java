package Modulo_II.A14S.Mesa.main.dao.impl;

import Modulo_II.A14S.Mesa.main.config.ConfiguracaoJDBC;
import Modulo_II.A14S.Mesa.main.dao.IDao;
import Modulo_II.A14S.Mesa.main.model.Medicamento;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MedicamentoDao implements IDao<Medicamento> {

    private static final Logger logger = LogManager.getLogger(MedicamentoDao.class);
    private ConfiguracaoJDBC configuracaoJDBC;

    public MedicamentoDao(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Medicamento salvar(Medicamento medicamento) {
        Connection connection = configuracaoJDBC.conectarComCancoDeDados();
        String query = "INSERT INTO medicamentos (nome, laboratorio, quantidade, preco) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, medicamento.getNome());
            statement.setString(2, medicamento.getLaboratorio());
            statement.setInt(3, medicamento.getQuantidade());
            statement.setDouble(4, medicamento.getPreco());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                medicamento.setId(generatedKeys.getInt(1));
            }
            logger.info("Medicamento salvo com sucesso. " + medicamento.toString());
        } catch (Exception e) {
            logger.error("Erro ao salvar medicamento. " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                logger.error("Erro ao fechar conexão com banco de dados. " + e.getMessage());
                e.printStackTrace();
            }
        }

        return medicamento;
    }


    @Override
    public Medicamento buscarPorId(int id) {
        Connection connection = configuracaoJDBC.conectarComCancoDeDados();
        Medicamento medicamento = null;
        String query = String.format("SELECT * FROM medicamentos WHERE id = %d", id);

        try (Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(query);
            if (result.next()) {
                medicamento = new Medicamento(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("laboratorio"),
                        result.getInt("quantidade"),
                        result.getDouble("preco")
                );
            }
            logger.info("Medicamento recuperado com sucesso. " + medicamento.toString());
        } catch (Exception e) {
            logger.error("Erro ao buscar medicamento. " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                logger.error("Erro ao fechar conexão com banco de dados. " + e.getMessage());
                e.printStackTrace();
            }
        }

        return medicamento;
    }
}