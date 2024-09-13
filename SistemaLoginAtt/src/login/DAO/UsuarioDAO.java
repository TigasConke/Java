package login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import login.View.TelaPrincipal;

public class UsuarioDAO {

    public String autenticarUsuario(String nomeUsuario, String senha) {
        String sql = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
        String resultado = "Usuário ou senha incorretos!";

        try {
            
            Connection conn = ConexaoDAO.conectarBD();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, nomeUsuario);
            pstmt.setString(2, senha);

            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                
                new TelaPrincipal().setVisible(true);
               
                return "Usuário logado com sucesso!";
                
            } else {
                
                return "Usuário ou senha incorretos!";
                
            }
        } catch (SQLException e) {
            
            System.err.println("Erro ao autenticar o usuário: " + e.getMessage());
        }

        return resultado;
        
    }
}
