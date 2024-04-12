package entities;

public class Empregado {
	
	public String nome;
	public double salarioBruto;
	public double taxa;
	
	public double salarioLiquido() {
	
		double salarioLiquido = salarioBruto - taxa;
		return salarioLiquido;
		
}
	
	public void aumentarSalario(double porcentagem) {
		double procentagem = 0;
		procentagem = salarioBruto + (procentagem  * 100);
		
	}
	
}

