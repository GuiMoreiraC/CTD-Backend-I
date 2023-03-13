package Modulo_II.A13S.Atividade;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();

            createTable(connection);

            Paciente paciente1 = new Paciente("Fulano", "Silva", "Rua A, 123", "123456789", "2022-03-10", "fulano123", "senha123");
            insertPaciente(connection, paciente1);

            updateSenha(connection, 1, "novaSenha");
            verificarSenha(connection);

            connection.close();
        } catch (Exception e) {
            logger.error("Erro ao executar o programa: " + e.getMessage());
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sqlCreateTable = """
        DROP TABLE IF EXISTS Paciente;
        CREATE TABLE Paciente (
            Id INT PRIMARY KEY AUTO_INCREMENT,
            Nome VARCHAR(100) NOT NULL,
            Sobrenome VARCHAR(100) NOT NULL,
            Endereco VARCHAR(100),
            RG VARCHAR(20),
            DataCadastro VARCHAR(100),
            Usuario VARCHAR(100) UNIQUE NOT NULL,
            Senha VARCHAR(100) NOT NULL
        );
    """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTable);
        }
    }

    private static void insertPaciente(Connection connection, Paciente paciente) throws SQLException {
        String sqlInsert = "INSERT INTO Paciente (Nome, Sobrenome, Endereco, RG, DataCadastro, Usuario, Senha) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)){
            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setString(2, paciente.getSobrenome());
            preparedStatement.setString(3, paciente.getEndereco());
            preparedStatement.setString(4, paciente.getRg());
            preparedStatement.setString(5, paciente.getDataCadastro());
            preparedStatement.setString(6, paciente.getUsername());
            preparedStatement.setString(7, paciente.getSenha());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("Unique index or primary key violation")) {
                logger.error("Erro ao tentar inserir paciente com usuário repetido");
            } else {
                logger.error("Erro desconhecido ao inserir paciente: " + e.getMessage());
            }
        }
    }

    private static void updateSenha(Connection connection, int id, String novaSenha) throws SQLException {
        connection.setAutoCommit(false);
        String sqlUpdateSenha = "UPDATE Paciente SET Senha = ? WHERE Id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateSenha)){
            preparedStatement.setString(1, novaSenha);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            logger.error("Erro ao tentar atualizar a senha do paciente: " + e.getMessage());
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    private static void verificarSenha(Connection connection) throws SQLException {
        String sqlSelect = "SELECT Senha FROM Paciente WHERE Id = 1";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            resultSet.next();
            String senha = resultSet.getString("Senha");
            if (senha.equals("senha123")) {
                logger.info("Senha não foi alterada com sucesso");
            } else {
                logger.info("Senha foi alterada com sucesso");
            }
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test ", "sa", "");
    }

}
