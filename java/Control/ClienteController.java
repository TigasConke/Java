package Control;

import java.util.ArrayList;

import DAO.ClienteDAO;
import Model.ClienteModel;

public class ClienteController {
	
	public String cadastrarCliente(ClienteModel novoCliente) {
		
		String dadosValidos = validarDados(novoCliente);
		if(dadosValidos != "") return dadosValidos;
        
		ClienteDAO clienteDao = new ClienteDAO();
		String retorno = clienteDao.cadastrarCliente(novoCliente);
		
		return retorno;
		
	}
	
	public ArrayList<ClienteModel> procurarCliente(String nome) {
		
		ClienteDAO clienteDao = new ClienteDAO();
		ArrayList<ClienteModel> retorno = clienteDao.procurarCliente(nome);
		
		return retorno;
		
	}
	
	public ArrayList<ClienteModel> procurarClienteCategoria(int categoriaId) {
		
		ClienteDAO clienteDao = new ClienteDAO();
		ArrayList<ClienteModel> retorno = clienteDao.procurarClienteCategoria(categoriaId);
		
		return retorno;
		
	}
	
	public ArrayList<ClienteModel> buscarClientes() {
		
		ClienteDAO clienteDao = new ClienteDAO();
		ArrayList<ClienteModel> retorno = clienteDao.buscarClientes();
		
		return retorno;
		
	}
	
	public ClienteModel procurarClienteCodigo(int codigo) {
		
		ClienteDAO clienteDao = new ClienteDAO();
		ClienteModel retorno = clienteDao.procurarClienteCodigo(codigo);
		
		return retorno;
		
	}
	
	public String atualizarCliente(ClienteModel cliente) {
		
		String dadosValidos = validarDados(cliente);
		if(dadosValidos != "") return dadosValidos;
		
		ClienteDAO clienteDao = new ClienteDAO();
		String retorno = clienteDao.atualizarCliente(cliente);
		
		return retorno;
		
	}
	
	public String removerCliente(int codigoCliente) {
		
		ClienteDAO clienteDao = new ClienteDAO();
		String retorno = clienteDao.removerCliente(codigoCliente);
		
		return retorno;
		
	}
	
	public String validarDados(ClienteModel novoCliente) {
		
	    if (novoCliente.getNome() == null || novoCliente.getNome().trim().isEmpty()) { return "Nome não pode ser vazio."; }
	    if (novoCliente.getCpf() == null || novoCliente.getCpf().trim().isEmpty()) { return "CPF não pode ser vazio."; }
	    if (novoCliente.getCpf().length() != 14) { return "CPF deve conter 11 dígitos."; }
	    if (novoCliente.getEmail() == null || novoCliente.getEmail().trim().isEmpty()) { return "Email não pode ser vazio."; }
	    if (!novoCliente.getEmail().contains("@") || !novoCliente.getEmail().contains(".")) { return "Email inválido."; }
	    if (novoCliente.getEndereco() == null || novoCliente.getEndereco().trim().isEmpty()) { return "Endereço não pode ser vazio."; }
	    if (novoCliente.getDtNascimento() == null) { return "Data de nascimento não pode ser vazia."; }
	    
	    return "";
	    
	}
	
}
