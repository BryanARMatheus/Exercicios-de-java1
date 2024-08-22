package exercicios_n1;
import java.util.Scanner;

public class Nº6 {
	
	/*
	 * 6-Escreva um algoritmo para ler uma temperatura em graus Fahrenheit, 
	 * calcular e escrever o valor correspondente em graus Celsius. 
	 * Observação: Para testar se a sua resposta 
	 * está correta saiba que 100°C = 212°F
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a temperatura em Fahrenheit");
		float fahrenheit = input.nextFloat();

		float celsius = (fahrenheit - 32) * 5 / 9;
		System.out.printf("A temperatura em graus Celsius é %,.2f", celsius);
		
		input.close();
	}

}
