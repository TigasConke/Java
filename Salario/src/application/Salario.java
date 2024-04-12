package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Empregado;

public class Salario {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Empregado empregado;
		empregado = new Empregado();
		
		System.out.print("Nome: ");
		empregado.nome = sc.nextLine();
		System.out.println();
		System.out.println("Salário bruto: ");
		empregado.salario = sc.nextDouble();
		System.out.println();
		System.out.print("Taxa: ");
		empregado.taxa = sc.nextDouble();
		System.out.println();
		double salarioLiquido = empregado.salarioLiquido();
		System.out.println("Empregado: " + empregado.nome + ", R$ " + salarioLiquido + "." );
		System.out.println();
		
		System.out.print("Insira a porcentagem que deseja aumentar o salario: ");
		double porcentagem = sc.nextDouble();
		empregado.aumentarSalario(porcentagem);
		System.out.println();
		
		System.out.println();
		System.out.println("Dados atualizados: " + empregado);
		
		
		sc.close();
	}

}
