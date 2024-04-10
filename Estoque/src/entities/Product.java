package entities;

public class Product {
	
	public String nome;
	public double preco;
	public int quantidade;
	
	public double valorTotalEmEstoque() {
		
		return preco * quantidade;
		
	}

	public int adicionarProdutos(int quantidade) {
		
		return this.quantidade += quantidade;
			  
	}
	
	public int removerProdutos(int quantidade) {
		
		return this.quantidade -= quantidade;
		
	}
	
	public String toString() {
		
		return nome
				+ ", R$ "
				+ String.format("%.2f", preco)
				+ ", "
				+ quantidade
				+ " unidades, Total: R$"
				+ String.format("%.2f",valorTotalEmEstoque());
				
		
	}

}

	
	