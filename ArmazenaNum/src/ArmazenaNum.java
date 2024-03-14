import java.util.Scanner;
import java.util.Locale;
public class ArmazenaNum {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos números você vai digitar?");
		int numero = sc.nextInt();
		
		double[] numerosvet = new double[numero];
		
		for(int i = 0; i < numero; i++) {
			
			System.out.print("Digite um número: ");
			numerosvet[i] = sc.nextDouble(); 
			
		}
		
		System.out.println();
		
		System.out.println("Os numeros digitados são: ");
		for(int i = 0; i < numero; i++) {
			System.out.println(String.format("%.2f", numerosvet[i]));
			
		}
		
		sc.close();
}

}
