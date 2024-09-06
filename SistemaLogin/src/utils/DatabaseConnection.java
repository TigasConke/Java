package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/seu_banco"; // Substitua 'seu_banco' pelo nome do seu banco de dados
    private static final String USER = "seu_usuario"; // Substitua 'seu_usuario' pelo seu nome de usuário do PostgreSQL
    private static final String PASSWORD = "sua_senha"; // Substitua 'sua_senha' pela sua senha do PostgreSQL

    public static Connection getConnection() throws SQLException {
        try {
            // Registrar o driver do PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC do PostgreSQL não encontrado.");
            e.printStackTrace();
        }

        // Retornar a conexão estabelecida
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para testar a conexão
    public static void main(String[] args) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn != null) {
                System.out.println("Conexão estabelecida com sucesso!");
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}