package application;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		System.out.println("Entre com os dados do produto:");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Preço: ");
		double preco = sc.nextDouble();
		System.out.print("Quantidade: ");
		int quantidade = sc.nextInt();
		Product produto = new Product(nome, preco, quantidade);//instaciação com construtor
		
		System.out.println();
		System.out.println("Dados do produto:");
		System.out.println(produto);
		System.out.println();
		
		System.out.println("Quantas unidades desse produto deseja adicionar ao estoque?");
		quantidade = sc.nextInt();
		produto.adicionarProdutos(quantidade);
		System.out.println();
		
		System.out.println("Quantas unidades desse produto deseja remover do estoque?");
		quantidade = sc.nextInt();
		produto.removerProdutos(quantidade);
		System.out.println();
		
		System.out.println("Dados do produto atualizados:" + produto);
		
		
		sc.close();
	}

}
