package exercicios_n1;
import java.util.Scanner;

public class Nº13 {
	
	/*
	 * 13-Ler dois valores 
	 * (considere que não serão lidos valores iguais) 
	 * e escrevê-los em ordem crescente. 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o primeiro numero");
		int num = input.nextInt();
		System.out.println("Digite o segundo numero");
		int num2 = input.nextInt();
		
		if (num < num2) {
			System.out.println(num);
			System.out.println(num2);			
		}else {
			System.out.println(num2);
			System.out.println(num);	
			}
		
		input.close();
	}

}
