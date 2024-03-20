package crescente;

import java.util.Scanner;

public class Crescente {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int X, Y;
		
//--------------- Inserção e leitura de dados do usuário ---------------//
		
		System.out.println("Digite dois números:");
		X = sc.nextInt();
		System.out.println();
		Y = sc.nextInt();
		
//----------------------------------------------------------------------//		
		
//--------------- Loop que determina se é crescente ou decrescente ---------------//		
		
		while(X != Y) { //se X e Y forem iguais, não entra no loop e o programa é finalizado
			
			if(X < Y) { // quando diferentes, o if determina se o X é menor que o Y, se for é printado "Crescente!"
				
				System.out.println("Crescente!"); 
				
			}
			
			else {System.out.println("Decrescente!");} //se Y for menor, então é printado "Decrescente!"
			X = Y; // iguala o X a Y para que o loop não seja infinito
		}
		
//--------------------------------------------------------------------------------//	
		
		System.out.println("FIM DO PROGRAMA!");
		
		sc.close();

	}

}
