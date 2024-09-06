package dao;

import model.ClienteModel;
import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    // Método para cadastrar um novo cliente no banco de dados
    public void cadastrarCliente(ClienteModel cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, email, endereco, dt_nascimento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Setando os valores no PreparedStatement
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setDate(5, new java.sql.Date(cliente.getDtNascimento().getTime())); // Conversão da data para SQL

            // Executa a inserção no banco de dados
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
}