package control;

import dao.UsuarioDAO;
import model.UsuarioModel;

public class UsuarioController {

    public boolean autenticarUsuario(String login, String senha) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioModel usuario = usuarioDAO.buscarUsuarioPorLogin(login);

        if (usuario != null && usuario.getSenha().equals(senha)) {
            return true;
        } else {
            return false;
        }
    }
}
