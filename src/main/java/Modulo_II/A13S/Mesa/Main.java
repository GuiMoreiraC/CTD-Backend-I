package Modulo_II.A13S.Mesa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(String.valueOf(Main.class));

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();

            createTable(connection);
            insertData(connection);
            updateMatricula(connection, 1, "555");
            verifyData(connection);

            connection.close();
        } catch (Exception e) {
            logger.error("Erro ao executar o programa: " + e.getMessage());
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String sqlCreateTable = """
        DROP TABLE IF EXISTS Dentista;
        CREATE TABLE Dentista (
            Id INT PRIMARY KEY,
            Nome VARCHAR(100),
            Sobrenome VARCHAR(100),
            Matricula VARCHAR(100) UNIQUE
        );
    """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCreateTable);
        }
    }

    private static void insertData(Connection connection) throws SQLException {
        Dentista dentista1 = new Dentista(1,"Fulano", "Silva", "123");
        Dentista dentista2 = new Dentista(2,"Ciclano", "Souza", "456");
        Dentista dentista3 = new Dentista(3,"Beltrano", "Oliveira", "789");
        Dentista dentista4 = new Dentista(4,"José", "Santos", "404");

        insertDentista(connection, dentista1);
        insertDentista(connection, dentista2);
        insertDentista(connection, dentista3);
        insertDentista(connection, dentista4);
    }

    private static void insertDentista(Connection connection, Dentista dentista) throws SQLException {
        String sqlInsert = "INSERT INTO Dentista (Id, Nome, Sobrenome, Matricula) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert)){
            preparedStatement.setInt(1, dentista.getId());
            preparedStatement.setString(2, dentista.getNome());
            preparedStatement.setString(3, dentista.getSobrenome());
            preparedStatement.setString(4, dentista.getMatricula());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            if (e.getMessage().contains("Unique index or primary key violation")) {
                logger.error("Erro ao tentar inserir dentista com matrícula repetida");
            } else {
                logger.error("Erro desconhecido ao inserir dentista: " + e.getMessage());
            }
        }
    }

    private static void updateMatricula(Connection connection, int id, String matricula) throws SQLException {
        String sqlUpdateMatricula = "UPDATE Dentista SET Matricula = ? WHERE Id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateMatricula)){
            preparedStatement.setString(1, matricula);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        }
    }

    private static void verifyData(Connection connection) throws SQLException {
        String sqlSelect = "SELECT * FROM Dentista";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlSelect)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String nome = resultSet.getString("Nome");
                String sobrenome = resultSet.getString("Sobrenome");
                String matricula = resultSet.getString("Matricula");

                logger.info("Dentista " + id + ": " + nome + " " + sobrenome + " - Matrícula: " + matricula);
            }
        }
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test ", "sa", "");
    }
}

