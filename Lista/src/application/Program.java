package application;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("Tiago");//adiciona "Tiago" a lista
		list.add("Rogério");//adiciona "Rogério" a lista
		list.add("Bruna");//adiciona "Bruna" a lista
		list.add("Aline");//adiciona "Aline" a lista
		list.add("Gabriele");//adiciona "Gabriele" a lista
		list.add(2, "Gilmara");//adiciona "Gilmara na posição 2 da lista
		list.remove("Tiago");//remove "Tiago" da lista
		list.remove(1);//remove elemento da posição 1
		list.removeIf(x -> x.charAt(1) == 'r');
		List <String> resultado = list.stream().filter(x -> x.charAt(2) == 'i').collect(Collectors.toList());//filtra os elementos que tem "i" no char 2
		
		for (String x : resultado) {
			
			System.out.println(resultado);
			
		}
		
	}

}
