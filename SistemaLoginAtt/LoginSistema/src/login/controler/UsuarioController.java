package login.controler;

import login.DAO.UsuarioDAO;
import login.view.LoginView;
import login.view.TelaPrincipal;

public class UsuarioController {
     private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void realizarLogin(String nomeUsuario, String senha) {
        // Valida as credenciais recebidas
        String mensagem = validarCredenciais(nomeUsuario, senha);
        
       if (mensagem != null) {
            // Exibe mensagem de erro na view
            LoginView.getInstance().exibirMensagem(mensagem);
        } else {
            // Se as validações passaram, autentica o usuário
            String resultado = usuarioDAO.autenticarUsuario(nomeUsuario, senha);
            
            if ("Login bem sucedido!".equals(resultado)) {
                LoginView.getInstance().exibirMensagem(resultado);
                abrirTelaHome(); // Abre a tela de cadastro de cliente
            } else {
                LoginView.getInstance().exibirMensagem(resultado);
            }
        }
    }

    private String validarCredenciais(String nomeUsuario, String senha) {
        if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
            return "O nome de usuário não pode estar vazio!";
        }
        if (senha == null || senha.trim().isEmpty()) {
            return "A senha não pode estar vazia!";
        }
        if (senha.length() < 6) {
            return "A senha deve ter pelo menos 6 caracteres!";
        }
        return null; // Se todas as validações passaram
    }
    
    private void abrirTelaHome() {
        TelaPrincipal telaHome = new TelaPrincipal();
        telaHome.setVisible(true);
    }
}
