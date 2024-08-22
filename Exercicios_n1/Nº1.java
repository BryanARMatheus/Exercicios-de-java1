package exercicios_n1;
import java.util.Scanner;

public class Nº1 {
	
	/*
	 * 1-Faça um algoritmo que leia a idade de uma pessoa 
	 * expressa em anos, meses e dias e escreva 
	 * a idade dessa pessoa expressa apenas em dias. 
	 * Considerar ano com 365 dias e mês com 30 dias.
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a sua idade em anos, meses e dias");
		System.out.println("Ex: estou vivo a 18 anos, 6 meses e 9 dias");
		
		int ano = input.nextInt()*365;
		int mes = input.nextInt()*30;
		int dia = input.nextInt();
		
		int resultado = dia + mes + ano;
				
		System.out.print("Você esta vivo a " + resultado + " dias");

		
		input.close();
	}

}
