package webapp_alberto.newsletterjdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectioFactory {

    /* Atibutos */

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    /* Métodos */

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            /* Capturando o erro */

            throw new RuntimeException("Erro ao conectar com o banco de dados:" + e.getMessage());
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();

            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }

    public static void closeConnection(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.fillInStackTrace();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement stmt) {
        try {
            if (connection != null && stmt != null) {
                connection.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet rs) {
        closeConnection(connection, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
