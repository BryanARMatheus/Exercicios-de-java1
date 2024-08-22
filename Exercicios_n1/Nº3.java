package exercicios_n1;
import java.util.Scanner;

public class Nº3 {
	
	/*
	 * 3-Escreva um algoritmo para ler o salário mensal atual 
	 * de um funcionário e o percentual de reajuste.
	 * Calcular e escrever o valor do novo salário. 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Qual o salario atual? (Apenas em reais)");
		float salarioAtual = input.nextFloat();
		
		System.out.println("Qual é o percentual de reajuste?");
		float percReajuste = input.nextFloat();
		
		float aumento = salarioAtual * percReajuste / 100;
		
		double novoSalario =  salarioAtual + aumento;
		
		System.out.printf("O novo salario é: R$ %,.2f", novoSalario);
		
		input.close();
	}

}
