package formatar_numero;

import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		double x;
		x = 14.9872;
		System.out.println(String.format("%.2f" , x)); //String.format("%.numerodecasas", x) formata o número de casas pós ",".

	}

}
