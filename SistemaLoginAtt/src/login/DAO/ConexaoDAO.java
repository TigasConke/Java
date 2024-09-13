package login.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/login";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    
    public static Connection conectarBD() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

