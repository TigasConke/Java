package Model;

public class CategoriaModel {
	private int id;
	private String nome;
	private String descricao;
	private boolean ativo;
	
	public int getId() {
		
		return id;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
