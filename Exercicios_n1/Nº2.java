package exercicios_n1;
import java.util.Scanner;

public class Nº2 {
	
	/*
	 * 2-Escreva um algoritmo para ler o número total de eleitores 
	 * de um município, o número de votos brancos, nulos e válidos.
	 * Calcular e escrever o percentual 
	 * que cada um representa em relação ao total de eleitores. 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Qual a quantidade de eleitores");
		float qtdEleitores = input.nextFloat();
		
		System.out.println("Qual a quantidade de votos brancos");
		float votosBrancos = input.nextFloat()/qtdEleitores*100;
		
		System.out.println("Qual a quantidade de votos nulos");
		float votosNulos = input.nextFloat()/qtdEleitores*100;
		
		System.out.println("Qual a quantidade de votos validos");
		float votosValidos = input.nextFloat()/qtdEleitores*100;
		
		System.out.printf("Percentual de votos brancos: %,.2f \n", votosBrancos);
		System.out.printf("Percentual de votos nulos: %,.2f \n", votosNulos);
		System.out.printf("Percentual de votos validos: %,.2f \n", votosValidos);
		
		
		input.close();
	}

}
