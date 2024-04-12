package program;
import java.util.Scanner;
import entities.Retangulo;
import java.util.Locale;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Retangulo retangulo;
		retangulo = new Retangulo();
		
		System.out.print("Digite a largura do retângulo: ");
		retangulo.largura = sc.nextDouble(); 
		System.out.println("Digite a altura do retângulo: ");
		retangulo.altura = sc.nextDouble();

		double area = retangulo.Area();
		double perimetro = retangulo.Perimetro();
		double diagonal = retangulo.Diagonal();
		
		System.out.print("Área = " + area);
		System.out.println();
		System.out.print("Perímetro = " + perimetro);
		System.out.println();
		System.out.print("Diagonal = " + diagonal);
		
		sc.close();
	}

}
