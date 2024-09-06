package dao;

import model.UsuarioModel;
import utils.DatabaseConnection;
import java.sql.*;

public class UsuarioDAO {

    public UsuarioModel buscarUsuarioPorLogin(String login) {
        String sql = "SELECT * FROM usuario WHERE login = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UsuarioModel usuario = new UsuarioModel();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                return usuario;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        }
        return null;
    }
}