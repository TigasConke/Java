package login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private final ConexaoDAO conexaoDAO;

    public UsuarioDAO() {
        this.conexaoDAO = new ConexaoDAO();
    }
    
    // autenticar usuário
    public String autenticarUsuario(String nomeUsuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
        String resultado = "Usuário ou senha incorretos!";

        try (
             Connection conn = conexaoDAO.conectarBD();
             PreparedStatement stmt = conn.prepareStatement(sql)
           ) {

            // parâmetros da consulta
            stmt.setString(1, nomeUsuario);
            stmt.setString(2, senha);

            // consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Se houver um resultado, as credenciais estão corretas
                    resultado = "Login bem sucedido!";
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar o usuário: " + e.getMessage());
        }

        return resultado;
    }
}
