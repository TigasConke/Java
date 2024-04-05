import java.util.Scanner;
import java.util.Locale;

public class CompararAreaTriangulos {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		double x1, x2, x3, y1, y2, y3, px, py, areaX, areaY;
		
		System.out.print("Entre as medidas do triângulo X: ");
		x1 = sc.nextDouble(); 
		x2 = sc.nextDouble();
		x3 = sc.nextDouble();
		
		System.out.print("Entre as medidas do triângulo Y: ");
		y1 = sc.nextDouble(); 
		y2 = sc.nextDouble();
		y3 = sc.nextDouble();
		
		/* Triangulo X */
		px = (x1 + x2 + x3) / 2; //calculo de p para o triangulo X 
		areaX = px * (px - x1) * (px-x2) * (px-x3); //calcula primeiro o que fica dentro da raiz
		areaX = Math.sqrt(areaX); // depois coloca o valor calculado na linha anterior na raiz
		
		/* Triangulo Y */
		py = (y1 + y2 + y3)/2; //calculo de p para o triangulo Y 
		areaY = py * (py - y1) * (py-y2) * (py-y3); //calcula primeiro o que fica dentro da raiz
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
