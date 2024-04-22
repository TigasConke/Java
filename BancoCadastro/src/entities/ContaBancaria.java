package entities;

public class ContaBancaria {
	
	private int numeroConta;
	private String nome;
	private double saldo;
	
	
	public ContaBancaria(int numeroConta, String nome) {
		
		this.numeroConta = numeroConta;
		this.nome = nome;
		
	}

	
	
	public ContaBancaria(int numeroConta, String nome, double depositoInicial) {

		this.numeroConta = numeroConta;
		this.nome = nome;
		deposito(depositoInicial);
		
	}

	public double getNumeroConta() {
		return numeroConta;
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void deposito(double qtd) {
		
		saldo += qtd;
		
	}
	
	public void saque(double qtd) {
		
		saldo -= qtd + 5;
		
	}
	
	public String toString() {
		
		return "Conta: "
			+ numeroConta
			+", Titular: "
			+ nome
			+", Saldo: R$"
			+String.format("%.2f", saldo);
	}
	
}
