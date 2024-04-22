package application;

import java.util.Locale;
import java.util.Scanner;
import entities.ContaBancaria;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		ContaBancaria conta;
		System.out.print("Insira o número da conta: ");
		int numeroConta = sc.nextInt();
		System.out.print("Insira o nome do titular da conta: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Deseja realizar um depósito inicial? Digite s para sim e n para não: ");
		char resposta = sc.next().charAt(0);
		
		if(resposta == 's') {
			
			System.out.print("Digite o valor do depósito: ");
			double depositoInicial = sc.nextDouble();
			conta = new ContaBancaria(numeroConta, nome, depositoInicial);
			
		}
		else {
			
			conta = new ContaBancaria(numeroConta, nome);
			
		}
		
		System.out.println();
		System.out.println("Dados da conta: ");
		System.out.println(conta);
		
		System.out.println();
		System.out.print("Digite o valor que desaja depositar: ");
		double valorDeDeposito = sc.nextDouble();
		conta.deposito(valorDeDeposito);
		System.out.println("Saldo atualizado!");
		System.out.println(conta);
		
		System.out.println();
		System.out.print("Digite o valor que desaja sacar: ");
		double valorDeSaque = sc.nextDouble();
		conta.saque(valorDeSaque);
		System.out.println("Saldo atualizado!");
		System.out.println(conta);
		
		sc.close();
		
	}

}
