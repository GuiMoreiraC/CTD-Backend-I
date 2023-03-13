package Modulo_II.A11S.Atividade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);

            insertEmployee(connection, "João", 25, "Digital House", "2022-01-01");
            insertEmployee(connection, "Maria", 30, "Google", "2021-01-01");
            insertEmployee(connection, "Juliana", 35, "Facebook", "2020-01-01");

            mostrarEmployees(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void mostrarEmployees(Connection connection) throws SQLException {
        String sqlConsulta = "SELECT * FROM Employee";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlConsulta);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("ID") + " - " + resultSet.getString("Nome") + " - " + resultSet.getInt("Idade") + " - " + resultSet.getString("Empresa") + " - " + resultSet.getString("DataInicio"));
        }
    }

    private static void insertEmployee(Connection connection, String nome, int idade, String empresa, String dataInicio) throws SQLException {
        String sqlInsert = "INSERT INTO Employee (Nome, Idade, Empresa, DataInicio) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, nome);
        preparedStatement.setInt(2, idade);
        preparedStatement.setString(3, empresa);
        preparedStatement.setString(4, dataInicio);
        preparedStatement.executeUpdate();
    }

    private static final String sqlCreateTable = """
            DROP TABLE IF EXISTS Employee; CREATE TABLE Employee
            (
            ID INT PRIMARY KEY AUTO_INCREMENT,
            Nome VARCHAR(100) NOT NULL,
            Idade INT NOT NULL,
            Empresa VARCHAR(100) NOT NULL,
            DataInicio DATE NOT NULL
            )
            """;

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

}
