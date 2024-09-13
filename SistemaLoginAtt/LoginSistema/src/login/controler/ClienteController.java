package login.controler;

import java.util.Date;
import login.DAO.ClienteDAO;
import login.view.TelaCadastroCliente;

public class ClienteController {

    private final ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrarCliente(String nome, String cpf, String email, String endereco) {
        // Valida os dados recebidos
        String mensagem = validarDadosCliente(nome, cpf, email, endereco);

        if (mensagem != null) {
            // Exibe mensagem de erro na view
            TelaCadastroCliente.getInstance().exibirMensagem(mensagem);
        } else {
            // Se as validações passaram, persiste o cliente no banco
            String resultado = clienteDAO.cadastrarCliente(nome, cpf, email, endereco);

            if ("Cliente cadastrado com sucesso!".equals(resultado)) {
                TelaCadastroCliente.getInstance().exibirMensagem(resultado);
            } else {
                TelaCadastroCliente.getInstance().exibirMensagem(resultado);
            }
        }
    }

    private String validarDadosCliente(String nome, String cpf, String email, String endereco) {
        if (nome == null || nome.trim().isEmpty()) {
            return "O nome não pode estar vazio!";
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            return "O CPF não pode estar vazio!";
        }
        cpf = cpf.replaceAll("\\D", "");

        // Verifica se o CPF tem exatamente 11 dígitos
        if (cpf.length() != 11) {
            return "O CPF deve conter exatamente 11 dígitos!";
        }
        if (email == null || email.trim().isEmpty()) {
            return "O e-mail não pode estar vazio!";
        }
        if (endereco == null || endereco.trim().isEmpty()) {
            return "O endereço não pode estar vazio!";
        }
        return null;
    }
}
