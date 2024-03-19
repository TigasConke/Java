//Fazer um programa para ler as medidas da base e altura de um retângulo. Em seguida, mostrar o valor
//da área, perímetro e diagonal deste retângulo.
import java.util.Locale;
import java.util.Scanner;
import java.lang.Math;
public class Retangulo {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		double base = 0, altura = 0, area, perimetro, diagonal;
		
		System.out.print("Base do retângulo: ");
		base = sc.nextDouble();
				
		System.out.print("Altura do retângulo: ");
		altura = sc.nextDouble();
		
		area = base * altura;
		
		perimetro = (base * 2) + (altura * 2);
		
		diagonal = Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
		
		System.out.println("Área: " + area);
		System.out.println("Perímetro: " + perimetro);
		System.out.println("Diagonal: " + diagonal);
		
		sc.close();
	}

}
