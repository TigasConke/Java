package login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import login.Model.ClienteModel;

public class ClienteDAO {

    public ArrayList<ClienteModel> buscarClientesPorNome(String nome) {
    String sql;
    if (nome == null || nome.trim().isEmpty()) {
        // Se o nome for vazio ou nulo, busca todos os clientes
        sql = "SELECT * FROM cliente";
    } else {
        // Busca clientes cujo nome contenha a string fornecida
        sql = "SELECT * FROM cliente WHERE nome LIKE ?";
    }
    
    ArrayList<ClienteModel> clientes = new ArrayList<>();

    try {
        Connection conn = ConexaoDAO.conectarBD();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        if (nome != null && !nome.trim().isEmpty()) {
            pstmt.setString(1, "%" + nome + "%");
        }

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            ClienteModel cliente = new ClienteModel(
                rs.getInt("codigo"), 
                rs.getString("nome"),
                rs.getString("cpf"),
                rs.getString("email"),
                rs.getString("endereco"),
                rs.getDate("dtnascimento")
            );
            clientes.add(cliente);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }

    return clientes;
}


    public String cadastrarCliente(ClienteModel cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, email, endereco, dtNascimento) VALUES (?, ?, ?, ?, ?)";
        String resultado = "Erro ao cadastrar cliente!";

        try {
            Connection conn = ConexaoDAO.conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setDate(5, new Date(cliente.getDtNascimento().getTime()));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return "Usuário cadastrado com sucesso!";
            } else {
                return "Usuário não cadastrado!";
            }

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar o cliente: " + e.getMessage());
        }

        return resultado;
    }
}
