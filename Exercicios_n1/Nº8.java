package exercicios_n1;
import java.util.Scanner;

public class Nº8 {
	
	/*
	 * 8-Ler um valor e escrever se é positivo ou negativo 
	 * (considere o valor zero como positivo). 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite um valor");
		int num = input.nextInt();

		if (num >= 0) {
			System.out.println("O valor digitado é positivo");
		}else {
			System.out.println("O valor digitado é negativo");
		}
		
		input.close();
	}

}
