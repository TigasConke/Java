package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serão digitadas? ");
		int tam = sc.nextInt();
		Pessoa[] vetor = new Pessoa[tam];
		
		System.out.println();
		
		for(int i = 0; i < vetor.length; i++) {
		
			System.out.println("Dados da " + (i + 1) + "a pessoa: ");
			System.out.print("Nome: ");
			String nome = sc.next();
			
			System.out.println();
			
			System.out.print("Idade: ");
			double idade = sc.nextDouble();
			
			System.out.println();
			
			System.out.print("Altura: ");
			double altura = sc.nextDouble();
			
			vetor[i] = new Pessoa(nome, idade, altura);
		
		}
		
		double media = 0;
		
		for(int i = 0; i < vetor.length; i++) {
			
			media += vetor[i].getAltura();
			
		}
		
		media = media / tam;
		
		System.out.printf("Média de alturas = %.2f%n", media);
		 
		media = 0;
		
		for(int i = 0; i < vetor.length; i++) {
			
			media += vetor[i].getIdade();
			
		}
		
		media = media / tam;
		
		System.out.printf("Média de idades = %.2f%n", media);
		
		sc.close();
	}
	
}
