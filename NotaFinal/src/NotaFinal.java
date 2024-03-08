import java.util.Locale;
import java.util.Scanner;
public class NotaFinal {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner nu = new Scanner(System.in);
		
		double lab, avaliacao, exame, media;
		char conceito;
		
		System.out.println("BEM VINDO!");
		System.out.println("Insira a nota do Trabalho de Laboratório:");
		lab = nu.nextDouble();
		
		System.out.println("Insira a nota da Avaliação Semestral:");
		avaliacao = nu.nextDouble();
		
		System.out.println("Insira a nota do Exame Final:");
		exame = nu.nextDouble();
		
		media = ((lab * 2) + (avaliacao * 3)+ (exame * 5)) / 10 ;
		
		if(media >= 0 && media < 5) {
			
			conceito = 'E';
			
			System.out.println("Nota:" + media);
			System.out.println("Conceito:" + conceito);
		}
		
		else if(media >= 5 && media < 6) {
			
			conceito = 'D';
			
			System.out.println("Nota:" + media);
			System.out.println("Conceito:" + conceito);
			
		}
		
		else if(media >= 6 && media < 7) {
			
			conceito = 'C';
			
			System.out.println("Nota:" + media);
			System.out.println("Conceito:" + conceito);
			
		}
		
		else if(media >= 7 && media < 8) {
			
			conceito = 'B';
			
			System.out.println("Nota:" + media);
			System.out.println("Conceito:" + conceito);
			
		}
		
		else if(media >= 8 && media <= 10) {
			
			conceito = 'A';
			
			System.out.println("Nota:" + media);
			System.out.println("Conceito:" + conceito);
			
		}
		else System.out.println("Nota superior a 10! Verifique as notas e tente novamente.");
		
		nu.close();
		
		
		
	}

}
