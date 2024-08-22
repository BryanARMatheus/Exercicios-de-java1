package exercicios_n1;
import java.util.Scanner;

public class Nº7 {
	
	/*
	 * 7-Ler um valor e escrever a mensagem É MAIOR QUE 10! 
	 * se o valor lido for maior que 10,
	 * caso contrário escrever NÃO É MAIOR QUE 10! 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite um valor");
		int num = input.nextInt();

		if (num > 10) {
			System.out.println("O valor digitado é maior que 10");
		}else {
			System.out.println("O valor digitado não é maior que 10");
		}
		
		input.close();
	}

}
