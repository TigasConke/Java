package application;
import java.util.Locale;
import java.util.Scanner;
import util.CurrencyConverter;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner cot = new Scanner(System.in);
		
		System.out.print("Digite o preço do dolar: ");
		double dolarCotacao = cot.nextDouble();
		System.out.println();
		System.out.print("Digite quantos dólares deseja comprar: ");
		double qtdDolares = cot.nextDouble();
		System.out.println();
		
		double pagoReais = CurrencyConverter.pagoReais(dolarCotacao, qtdDolares); 
		
		System.out.println("Total a pagar = R$" + String.format("%.2f", pagoReais));
		
		cot.close();
	}

}
