package entities;

public class Empregado {

	public String nome;
	public double salario;
	public double taxa;
	
	public double salarioLiquido() {
	
		double salarioLiquido = salario - taxa;
		return salarioLiquido;
		
}
	
	public void aumentarSalario(double percentagem) {
		salario += salario * percentagem / 100.0;
		}
		
	public String toString() {
		return nome + ", R$ " + String.format("%.2f", salarioLiquido());
		}
	}
	

