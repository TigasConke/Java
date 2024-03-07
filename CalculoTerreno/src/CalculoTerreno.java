//Escreva um programa que efetue a leitura dos valores de largura e comprimento de um terreno. Se o terreno for retangular, calcula os valores de seu perímetro e sua área. O programa exibe, no mínimo, as seguintes 
//informações para o usuário: largura e comprimento informados, sobre o formato do terreno, seu perímetro e área. O arquivo deve se chamar CalculoTerreno.java
public class CalculoTerreno {

	public static void main(String[] args) {
		
		double comprimento1 = 7, comprimento2 = 7, largura1 = 3, largura2 = 3, area, perimetro;
		
		if(comprimento1 == comprimento2 && largura1 == largura2){
		
			perimetro = (comprimento1 * 2) + (largura1 * 2);
			area = comprimento1 * largura1;
			
			System.out.println("O terreno tem formato retangular com " + comprimento1 + " metros de comprimento e " + largura1 + " metros de largura." );
			System.out.println("O terreno apresenta " + area + " metros quadrados de área e um perímetro de " + perimetro + " metros.");
		}
		
		else
			System.out.println("O terreno não é retangular e apresenta:");
			System.out.println("Comprimento: " + comprimento1 + " metros e " + comprimento2 + " metros" );
			System.out.println("Largura: " + largura1 + " metros e " + largura2 + " metros.");
		

	}

}
