package login.Controler;

import java.util.ArrayList;
import login.DAO.ClienteDAO;
import login.Model.ClienteModel;

public class ClienteController {

    private final ClienteDAO clienteDAO;

    public ClienteController() {
       
        this.clienteDAO = new ClienteDAO();
        
    }

    public ArrayList<ClienteModel> buscarClientesPorNome(String nome) {
        
        return clienteDAO.buscarClientesPorNome(nome);
        
    }

    public String cadastrarCliente(ClienteModel novoCliente) {
        
        if (novoCliente.getNome() == null || novoCliente.getNome().trim().isEmpty()) {
            
            return "O campo nome é obrigatório!";
            
        }

        if (novoCliente.getCpf() == null || novoCliente.getCpf().trim().isEmpty()) {
           
            return "O campo CPF é obrigatório!";
            
        }

        String cpf = novoCliente.getCpf().replaceAll("\\D", "");
        
        if (cpf.length() != 11) {
            
            return "O CPF deve conter exatos 11 dígitos!";
            
        }

        if (novoCliente.getEmail() == null || novoCliente.getEmail().trim().isEmpty()) {
            
            return "O campo e-mail é obrigatório!";
            
        }

        if (novoCliente.getEndereco() == null || novoCliente.getEndereco().trim().isEmpty()) {
            
            return "O campo endereço é obrigatório!";
            
        }

        if (novoCliente.getDtNascimento() == null) {
            
            return "O campo data de nascimento é obrigatório!";
            
        }

        return clienteDAO.cadastrarCliente(novoCliente);
    }
}
