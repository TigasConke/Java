package menor_de_tres;

//Fazer um programa para ler três números inteiros. Em seguida, mostrar qual o menor dentre os três
//números lidos. Em caso de empate, mostrar apenas uma vez. 

import java.util.Scanner;

public class Menor_de_tres {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1, num2, num3;
		
		System.out.print("Primeiro valor: ");
		num1 = sc.nextInt();
		
		System.out.print("Segundo valor: ");
		num2 = sc.nextInt();
		
		System.out.print("Terceiro valor: ");
		num3 = sc.nextInt();
		
		if(num1 <= num2 && num1 <= num3) {
			
			System.out.println("MENOR = " + num1);
			
		} else if(num2 <= num1 && num2 <= num3) {
			
				System.out.println("MENOR = " + num2);
			
			} else System.out.println("MENOR = " + num3);
		
		
		
		sc.close();
	}

}
