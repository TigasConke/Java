package login.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/login";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public Connection conectarBD() {
        Connection conn = null;

        try {
            // Registrar o driver PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Estabelecer a conexão com o banco de dados
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

        return conn;
    }
}
