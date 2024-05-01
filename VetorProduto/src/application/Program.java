package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Produto;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Produto[] vetor = new Produto[n];
		
		for(int i = 0; i < n; i++) {
			
			sc.nextLine();
			String nome = sc.nextLine();
			double preco = sc.nextDouble();
			vetor[i] = new Produto(nome,preco);
			
		}
		
		double media = 0;
		
		for(int i = 0; i < n; i++) {
			
			media += vetor[i].getPreco();
			
		}
		
		media = media / n;
		
		System.out.printf("Média = %.2f%n", media );
		
		sc.close();
	}

}
