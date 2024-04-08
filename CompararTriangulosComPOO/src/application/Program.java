package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Triangulo;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Triangulo x, y; 
		x = new Triangulo();
		y = new Triangulo();
		
		System.out.print("Entre as medidas do triângulo X: ");
		x.a = sc.nextDouble(); 
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		
		System.out.print("Entre as medidas do triângulo Y: ");
		y.a = sc.nextDouble(); 
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		/* a variavel areaX e areaY chamam o método que realiza o calculo da área */
		double areaX = x.area();
		double areaY = y.area();
		System.out.println("Área do triângulo X: " + areaX);
		System.out.println("Área do triângulo Y: " + areaY);
		
		if (areaX > areaY) {
			
			System.out.println("Área maior: X");
			
		}
		else System.out.println("Área maior: Y");

		
		sc.close();
	}

}
