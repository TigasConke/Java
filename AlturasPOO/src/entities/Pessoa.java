package entities;

public class Pessoa {
	public String nome;
	public double idade;
	public double altura;
	public Pessoa(String nome, double idade, double altura) {

		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	
	
	
	
}


