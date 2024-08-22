package exercicios_n1;
import java.util.Scanner;

public class Nº11 {
	
	/*
	 * 11-Ler o ano atual e o ano de nascimento de uma pessoa. 
	 * Escrever uma mensagem que diga se ela poderá ou não votar este ano 
	 * (não é necessário considerar o mês em que a pessoa nasceu).
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o ano que você nasceu");
		int anoNascimento = input.nextInt();
		System.out.println("Digite o ano atual");
		int anoAtual = input.nextInt();
		
		if (anoAtual - anoNascimento >= 18) {
			System.out.println("Você pode votar este ano");
		}else {
			System.out.println("Você não pode votar este ano");
		}
		
		input.close();
	}

}
