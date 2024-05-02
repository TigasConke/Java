import java.util.Scanner;
import java.util.Locale;

public class MostraNegativos {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		System.out.print("Quantos números você vai digitar? ");
		int tam = sc.nextInt();
		double[] vet =  new double[tam];
		
		System.out.println();
		
		for(int i = 0; i < vet.length; i++) { 
		
			System.out.println("Digite um número");
			vet[i] = sc.nextDouble();
		
		}
		
		System.out.println("Números negativos: ");
		
		for (int i = 0; i < vet.length; i++) {
			
			if(vet[i] < 0) {
				
				System.out.println(vet[i]);
				
			}
			
		}
		
		sc.close();
	}

}
