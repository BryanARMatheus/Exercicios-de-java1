package exercicios_n1;
import java.util.Scanner;

public class Nº10 {
	
	/*
	 * 10-Ler as notas da 1a. e 2a. avaliações de um aluno. 
	 * Calcular a média aritmética simples e 
	 * escrever uma mensagem que diga se 
	 * o aluno foi ou não aprovado 
	 * (considerar que nota igual ou maior que 6 o aluno é aprovado). 
	 * Escrever também a média calculada. 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a primeira nota");
		float nota1 = input.nextFloat();
		System.out.println("Digite a segunda nota");
		float nota2 = input.nextFloat();
		
		float media = (nota1 + nota2) / 2;
		
		if (media >= 6) {
			System.out.println("O aluno foi aprovado");
			System.out.printf("Média: %,.1f", media);

		}else {
			System.out.println("O aluno foi reprovado");
			System.out.printf("Média: %,.1f", media);
		}
		
		input.close();
	}

}
