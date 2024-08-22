package exercicios_n1;
import java.util.Scanner;

public class Nº9 {
	
	/*
	 * 9-As maçãs custam R$ 1,30 cada se forem compradas menos de uma dúzia, 
	 * e R$ 1,00 se forem compradas pelo menos doze. 
	 * Escreva um programa que leia o número de maçãs compradas, 
	 * calcule e escreva o custo total da compra. 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o numero de maças compradas");
		int maçasCompradas = input.nextInt();
		
		float valorTotal = 0.00F;
		
		if (maçasCompradas >= 12) {
			valorTotal = maçasCompradas;
			System.out.println("O custo das maças é " + valorTotal);
		}else {
			valorTotal = maçasCompradas * 1.30F;
			System.out.printf("O custo das maças é %,.2f", valorTotal);
		}
		
		input.close();
	}

}
