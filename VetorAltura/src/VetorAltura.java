import java.util.Scanner;

public class VetorAltura {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantas alturas deseja inserir?");
		int x = sc.nextInt();
		double []alturas = new double[x];
		double media = 0; 
		
		for(int i = 0; i < x; i++){
			
			System.out.println("Digite uma altura:");
			
			alturas[i] = sc.nextDouble();   
			
		}
		
	for(int i = 0; i < x; i++){
			media += alturas[i];
			    
		}
		
		media = media / x;
	
		System.out.println("A média das alturas é: " + media);
		
		sc.close();
	}

}
