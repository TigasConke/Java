import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		int idade;
		double salario, altura;
		char genero;
		String nome;
		
		idade = 20;
		salario = 2689.98;
		genero = 'M';
		nome = "Marcio da Silva";
		altura = 1.76;
		
		System.out.println("Idade = " + idade);
		System.out.println("Salário = " + salario);
		System.out.println("Gênero = " + genero);
		System.out.println("Nome = " + nome);
		System.out.println("Altura = " + altura);
	}

}
