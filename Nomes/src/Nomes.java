import java.util.Locale;
import java.util.Scanner;
public class Nomes {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String nome1;
		double salario1;
	
		
		System.out.println("Digite o nome da primeira pessoa:");
		nome1 = sc.nextLine(); 
		System.out.println("Digite o salário dessa pessoa:");
		salario1 = sc.nextDouble();
		
		System.out.println(nome1 + " recebe R$" + String.format("%.2f", salario1) + "." );
		
		sc.close();
		
	}

}
