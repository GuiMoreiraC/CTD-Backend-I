package Modulo_II.A12S.Mesa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try (Connection connection = getConnection()) {

            createTable(connection);

            insertData(connection);

            updateEmailByID(connection, 2, "ueber.james@gmail.com");

            deleteById(connection,1);

            deleteByIdade(connection, 26);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void createTable(Connection connection) throws SQLException {
        String sqlCreateTable = """
        DROP TABLE IF EXISTS Funcionarios;
        CREATE TABLE Funcionarios
        (
        Id INT PRIMARY KEY,
        Nome VARCHAR(100),
        Sobrenome VARCHAR(100),
        Idade INT,
        Email VARCHAR(100)
        );
        """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTable);
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        insertFuncionario(connection, 1, "Eventon", "Alves", 25, "eventon.alves@email.com");
        insertFuncionario(connection, 2, "Ueber", "James", 23, "ueber.james@email.com");
        insertFuncionario(connection, 3, "Pablo", "Haleson", 26, "pablo.haleson@email.com");
        insertFuncionario(connection, 1, "João", "Silva", 30, "joao.silva@email.com"); // Vai gerar um erro de id repetido
    }

    private static void insertFuncionario(Connection connection, int id, String nome, String sobrenome, int idade, String email) throws SQLException {
        String sqlInsert = "INSERT INTO Funcionarios (Id, Nome, Sobrenome, Idade, Email) VALUES (" + id + ", '" + nome + "', '" + sobrenome + "', " + idade + ", '" + email + "')";

        try (Statement statement = connection.createStatement()){
            statement.execute(sqlInsert);
        } catch (SQLException e) {
            if (e.getMessage().contains("Unique index or primary key violation")) {
                logger.error("Erro ao tentar inserir funcionário com ID repetido");
            } else {
                logger.error("Erro desconhecido ao inserir funcionário: " + e.getMessage());
            }
        }
    }

    private static void updateEmailByID(Connection connection, int id, String email) throws SQLException {
        String sqlConsulta = "SELECT * FROM Funcionarios WHERE Id=" + id;
        String sqlUpdate = "UPDATE Funcionarios SET Email='" + email + "' WHERE Id=" + id;

        Statement statement = connection.createStatement();
        int colunasExcluidas = statement.executeUpdate(sqlUpdate);

        if (colunasExcluidas > 0 ){
            ResultSet resultSet = statement.executeQuery(sqlConsulta);

            while (resultSet.next()){
                logger.debug("Funcionário atualizado: "
                        + resultSet.getInt(1) + " - "
                        + resultSet.getString(2) + " - "
                        + resultSet.getString(3) + " - "
                        + resultSet.getString(4) + " - "
                        + resultSet.getString(5));
            }
        }else {
            logger.info("Nenhum Funcionário com o id=" + id + "Foi encontrado");
        }
    }

    private static void deleteById(Connection connection, int id) throws SQLException {
        String sqlConsulta = "SELECT * FROM Funcionarios WHERE Id=" + id;
        String sqlDelete = "DELETE FROM Funcionarios WHERE Id=" + id;

        Statement statement = connection.createStatement();
        int colunasExcluidas = statement.executeUpdate(sqlDelete);

        if (colunasExcluidas > 0 ){
            logger.info("Funcionário de ID " + id + " foi excluído");
        }else {
            logger.info("Nenhum Funcionário com o id=" + id + " foi encontrado");
        }
    }

    private static void deleteByIdade(Connection connection, int idade) throws SQLException {
        String sqlConsulta = "SELECT * FROM Funcionarios WHERE Idade=" + idade;
        String sqlDelete = "DELETE FROM Funcionarios WHERE Idade=" + idade;

        Statement statement = connection.createStatement();
        int colunasExcluidas = statement.executeUpdate(sqlDelete);

        if (colunasExcluidas > 0 ){
            logger.info( colunasExcluidas + " funcionário(s) de idade " + idade + " foram excluídos");
        }else {
            logger.info("Nenhum Funcionário com idade=" + idade + " foi encontrado");
        }
    }

    private static final Logger logger = LogManager.getLogger(String.valueOf(Main.class));
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test ", "sa", "");
    }
}

