package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Funcionario;

public class Lista {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		List<Funcionario> list = new ArrayList<>();
		
		System.out.println("Quantos empregados serão registrados?");
		int nfun = sc.nextInt();
		
		for(int i=0; i<nfun; i++) {
			
			System.out.println("Funcionário " + (i + 1) + ": ");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while(hasId(list, id)) {
	
				System.out.println("Id já existe! Tente outra id:");
				id = sc.nextInt();
				
			}
			
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			
			System.out.print("Salário: ");
			Double salario = sc.nextDouble();
			
			Funcionario funcionario = new Funcionario(id, nome, salario);
			
			list.add(funcionario);
			
			}
		
			System.out.print("Insira o Id do funcionário que irá receber um aumento: ");
			int idsalario = sc.nextInt(); 
			int pos = posicao(list, idsalario);
			if(pos == -1) {
				
				System.out.println("Esse Id não existe!");
				
			}
			else {
			
			System.out.print("Digite a porcentagem que irá aumentar: ");
			double percent = sc.nextDouble();		
			list.get(pos).aumentarSalario(percent);
			
			}
			
			System.out.println();
			System.out.println("Lista de funcionários:");
			
			for(Funcionario funcionario : list) {
			
				System.out.println(funcionario);
				
			}
			
			sc.close();
		
		}
	
	public static int posicao(List<Funcionario> list, int id) {
		
		for (int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getId() == id) {
				
				return i;
				
			}
	
			}
		
		return -1;
		
	}
	
	public static boolean hasId(List<Funcionario> list, int id) {
		Funcionario emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

	
}
