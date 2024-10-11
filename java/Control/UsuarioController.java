package Control;

import DAO.UsuarioDAO;

public class UsuarioController {
	
	public String realizarLogin(String nomeUsuario, String senha) {
		String dadosValidos = validarDados(nomeUsuario, senha);
		if(dadosValidos != "") return dadosValidos;
        
		UsuarioDAO usuarioDao = new UsuarioDAO();
		String retorno = usuarioDao.autenticarUsuario(nomeUsuario, senha);
		System.out.println(retorno);
		
		return retorno;
		
	}
	
	public String validarDados(String nomeUsuario, String senha) {
		
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) { return "O campo nome de usuário não pode ser vazio."; }
        if (senha == null || senha.trim().isEmpty()) { return "O campo senha não pode ser vazio."; }
        if (senha.length() < 6) { return "A senha deve ter no mínimo 6 caracteres."; }
        
        return "";
        
	}
	
}
