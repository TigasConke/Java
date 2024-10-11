package Model;

import java.sql.Date;

public class ClienteModel {
	private int codigo;
	private String nome;
	private String cpf;
	private String email;
	private String endereco;
	private Date dtNascimento;
	private int categoria;
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public Date getDtNascimento() {
		return dtNascimento;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
}
