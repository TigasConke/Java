import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int nlinhas,ncolunas;
		
		System.out.print("Quantas linhas terá a matriz? ");
		nlinhas = sc.nextInt();
		
		System.out.print("Quantas colunas terá a matriz?" );
		ncolunas = sc.nextInt();
		
		int[][] mat = new int[nlinhas][ncolunas];
		
		for(int i = 0; i < nlinhas; i++) {
			
			for(int j = 0; j < ncolunas; j++){
			
				System.out.print("Elemento [" + i + "," + j + "]: ");
				mat[i][j] = sc.nextInt();
			}
		}
			
			System.out.println("A matriz digitada foi:");
			for(int i = 0; i < nlinhas; i++) {
				
				for(int j = 0; j < ncolunas; j++) {
					
					System.out.print(mat[i][j] + " ");
					
				}
				System.out.println();
			
			}
			
			sc.close();
		}

	}


