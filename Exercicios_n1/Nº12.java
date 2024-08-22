package exercicios_n1;
import java.util.Scanner;

public class Nº12 {
	
	/*
	 * 12-Ler dois valores 
	 * (considere que não serão lidos valores iguais) 
	 * e escrever o maior deles. 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o primeiro numero");
		int num = input.nextInt();
		System.out.println("Digite o segundo numero");
		int num2 = input.nextInt();
		
		if (num > num2) {
			System.out.println("O primeiro numero é maior que o segundo numero");
		}else {
			System.out.println("O segundo numero é maior que o primeiro numero");
		}
		
		input.close();
	}

}
