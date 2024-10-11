package Control;

import java.util.ArrayList;

import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import Model.CategoriaModel;
import Model.ClienteModel;

public class CategoriaController {
	
	public String cadastrarCategoria(CategoriaModel categoria) {
		String dadosValidos = validarDadosCategoria(categoria);
		if(dadosValidos != "") return dadosValidos;
        
		CategoriaDAO categoriaDao = new CategoriaDAO();
		String retorno = categoriaDao.cadastrarCategoria(categoria);
		
		return retorno;
		
	}
	
	public CategoriaModel procurarCategoriaId(int categoriaId) {
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		CategoriaModel retorno = categoriaDao.procurarCategoriaId(categoriaId);
		
		return retorno;
		
	}
	
	public CategoriaModel procurarCategoriaNome(String categoriaNome) {
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		CategoriaModel retorno = categoriaDao.procurarCategoriaNome(categoriaNome);
		
		return retorno;
		
	}
	
	public String atualizarCategoria(CategoriaModel categoria) {
		
		String dadosValidos = validarDadosCategoria(categoria);
		if(dadosValidos != "") return dadosValidos;
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		String retorno = categoriaDao.atualizarCategoria(categoria);
		
		return retorno;
		
	}
	
	public ArrayList<CategoriaModel> buscarCategorias() {
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		ArrayList<CategoriaModel> retorno = categoriaDao.buscarCategorias();
		
		return retorno;
		
	}
	
	public String removerCategoria(int categoriaId) {
		
		String dadosValidos = validarDadosRemover(categoriaId);
		if(dadosValidos != "") return dadosValidos;
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		String retorno = categoriaDao.removerCategoria(categoriaId);
		
		return retorno;
		
	}
	
	public String validarDadosCategoria(CategoriaModel categoria) {
		
		if (categoria.getNome() == null || categoria.getNome().trim().isEmpty()) { return "Nome não pode ser vazio."; }
	    if (categoria.getDescricao() == null || categoria.getDescricao().trim().isEmpty()) { return "Descrição não pode ser vazio."; }
		
		return "";
		
	}
	
	public String validarDadosRemover(int categoriaId) {
		
		ClienteDAO clienteDao = new ClienteDAO();
		ArrayList<ClienteModel> clientes = clienteDao.procurarClienteCategoria(categoriaId);
		if(!clientes.isEmpty()) { return "Há clientes cadastrados com essa categoria, não é possível fazer a exclusão"; }
		
		return "";
		
	}
}
