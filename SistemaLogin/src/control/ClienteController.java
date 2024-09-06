package control;

import dao.ClienteDAO;
import model.ClienteModel;
import java.util.Date;

public class ClienteController {

    public void cadastrarCliente(String nome, String cpf, String email, String endereco, Date dtNascimento) {
        ClienteModel cliente = new ClienteModel();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setDtNascimento(dtNascimento);

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.cadastrarCliente(cliente);
    }
}