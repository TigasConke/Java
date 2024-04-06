package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Triangulo;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double p;
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
		
		/* Triangulo X */
		p = (x.a + x.b + x.c) / 2; //calculo de p para o triangulo X 
		double areaX = p * (p - x.a) * (p-x.b) * (p-x.c); //calcula primeiro o que fica dentro da raiz
		areaX = Math.sqrt(areaX); // depois coloca o valor calculado na linha anterior na raiz
		
		/* Triangulo Y */
		p = (y.a + y.b + y.c)/2; //calculo de p para o triangulo Y 
		double areaY = p * (p - y.a) * (p-y.b) * (p-y.c); //calcula primeiro o que fica dentro da raiz
		areaY = Math.sqrt(areaY); // depois coloca o valor calculado na linha anterior na raiz
		
		System.out.println("Área do triângulo X: " + areaX);
		System.out.println("Área do triângulo Y: " + areaY);
		
		if (areaX > areaY) {
			
			System.out.println("Área maior: X");
			
		}
		else System.out.println("Área maior: Y");

		
		sc.close();
	}

}