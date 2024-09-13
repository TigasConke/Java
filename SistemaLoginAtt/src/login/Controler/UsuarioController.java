package login.Controler;

import login.DAO.UsuarioDAO;

public class UsuarioController {
    
     private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
       
         this.usuarioDAO = new UsuarioDAO();
         
    }

    public String realizarLogin(String nomeUsuario, String senha) {
      if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
           
           return "O nome de usuário não pode estar vazio!";
           
        }
        if (senha == null || senha.trim().isEmpty()) {
          
             return "A senha não pode estar vazia!";
             
        }
        if (senha.length() < 6) {
            
             return "A senha deve ter pelo menos 6 caracteres!";
             
        }
        
      return usuarioDAO.autenticarUsuario(nomeUsuario, senha);
         
    }
}
