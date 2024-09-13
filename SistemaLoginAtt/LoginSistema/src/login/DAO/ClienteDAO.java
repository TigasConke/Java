package login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    private final ConexaoDAO conexaoDAO;

    public ClienteDAO() {
        this.conexaoDAO = new ConexaoDAO();
    }

    // Método para cadastrar um novo cliente
    public String cadastrarCliente(String nome, String cpf, String email, String endereco) {
        String sql = "INSERT INTO cliente (nome, cpf, email, endereco) VALUES (?, ?, ?, ?)";
        String resultado = "Erro ao cadastrar cliente!";

        try (
            Connection conn = conexaoDAO.conectarBD();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // Define os parâmetros da consulta
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, email);
            stmt.setString(4, endereco);

            // Executa a inserção
            stmt.executeUpdate();
            resultado = "Cliente cadastrado com sucesso!";
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar o cliente: " + e.getMessage());
        }
        
        return resultado;
    }
}
