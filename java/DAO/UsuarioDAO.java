package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	public String autenticarUsuario(String nomeUsuario, String senha) {
		
		String functionReturn = "Login ou senha incorretos!";
		String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha = ?";

		try {
			
			ConexaoDAO conexaoDao = new ConexaoDAO();
			Connection databaseConnection = conexaoDao.conectarDB();

			if (databaseConnection != null) {
				
				PreparedStatement query = databaseConnection.prepareStatement(sql);
				query.setString(1, nomeUsuario);
				query.setString(2, senha);

				ResultSet resultadoQuery = query.executeQuery();

				
				if (resultadoQuery.next()) {
					
					functionReturn = "Login realizado com sucesso!";
				}
				
			} else {
				
				functionReturn = "Houve um erro ao se conectar com o banco de dados";
				
			}

			conexaoDao.desconectarDB();
		} catch (SQLException exception) {
			
			System.out.println(" > Erro ao autenticar o usuário: " + exception.getMessage());
			
		}
		
		return functionReturn;
	}
}
