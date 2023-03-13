package Modulo_II.A11S.Mesa;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

            mostrarFiguraPorTipoECor(connection, "Circulo", "Vermelho");
            System.out.println("------------------------");
            mostrarFigura(connection);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Encerrando a conexão no bloco finally para garantir que a conexão seja fechada
            if (connection != null) {
                connection.close();
            }
        }

    }

    private static void mostrarFigura(Connection connection) throws SQLException {
        String sqlConsulta = "SELECT * FROM Figuras";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlConsulta);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Id") + " - " + resultSet.getString("TipoFigura") + " - " + resultSet.getString("Cor"));
        }
    }

    private static void mostrarFiguraPorTipoECor(Connection connection, String tipo, String cor) throws SQLException {
        String sqlConsulta = "SELECT * FROM Figuras WHERE TipoFigura = ? AND Cor = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlConsulta);
        preparedStatement.setString(1, tipo);
        preparedStatement.setString(2, cor);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Id") + " - " + resultSet.getString("TipoFigura") + " - " + resultSet.getString("Cor"));
        }
    }

    private static final String sqlCreateTable = """
            DROP TABLE IF EXISTS Figuras; CREATE TABLE Figuras
            (
            Id INT PRIMARY KEY,
            TipoFigura VARCHAR(100) NOT NULL,
            Cor VARCHAR(100) NOT NULL
            )
            """;

    private static final String sqlInsert1 = "INSERT INTO Figuras (Id, TipoFigura, Cor) VALUES (1, 'Circulo', 'Vermelho')";
    private static final String sqlInsert2 = "INSERT INTO Figuras (Id, TipoFigura, Cor) VALUES (2, 'Circulo', 'Verde')";
    private static final String sqlInsert3 = "INSERT INTO Figuras (Id, TipoFigura, Cor) VALUES (3, 'Quadrado', 'Azul')";
    private static final String sqlInsert4 = "INSERT INTO Figuras (Id, TipoFigura, Cor) VALUES (4, 'Quadrado', 'Roxo')";
    private static final String sqlInsert5 = "INSERT INTO Figuras (Id, TipoFigura, Cor) VALUES (5, 'Quadrado', 'Amarelo')";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

}
