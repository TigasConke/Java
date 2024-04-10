package application;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Product produto = new Product();;
	
		System.out.println("Entre com os dados do produto:");
		System.out.print("Nome: ");
		produto.nome = sc.nextLine();
		System.out.print("Preço: ");
		produto.preco = sc.nextDouble();
		System.out.print("Quantidade: ");
		produto.quantidade = sc.nextInt();
		
		System.out.println();
		System.out.println("Dados do produto:");
		System.out.println(produto);
		System.out.println();
		
		System.out.println("Quantas unidades desse produto deseja adicionar ao estoque?");
		int quantidade = sc.nextInt();
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
