package entities;

public class Retangulo {
	
	public double altura;
	public double largura;
	
	public double Area(){
		
		double area = largura * altura;
		return area;
		
	}	
	
	public double Perimetro() {
		
		double perimetro = (altura*2) + (largura * 2);
		return perimetro;
	
	}
	
	public double Diagonal() {
		double diagonal = Math.sqrt((altura * altura) + (largura * largura));
		return diagonal;
	}
	
	
}
