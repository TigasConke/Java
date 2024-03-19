//Fazer um programa para ler o nome e idade de duas pessoas. Ao final mostrar uma mensagem com os
//nomes e a idade média entre essas pessoas.
import java.util.Scanner;

public class Idade {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner st = new Scanner(System.in);
		
		double idade1, idade2, media;
		String nome1,nome2;
		
		System.out.println("Dados da primeira pessoa:");
		System.out.print("Nome: ");
		nome1 = st.nextLine();
		System.out.print("Idade: ");
		idade1 = sc.nextInt();
		System.out.println();
		
		
		
		System.out.println("Dados da segunda pessoa:");
		System.out.print("Nome: ");
		nome2 = st.nextLine();
		System.out.print("Idade: ");
		idade2 = sc.nextInt();
		System.out.println();
		
		media = (idade1 + idade2)/2;
		
		System.out.println("A média das idades entre " + nome1 + " e " + nome2 + " é de " + media + ".");
		
		st.close();
		sc.close();
	}

}
