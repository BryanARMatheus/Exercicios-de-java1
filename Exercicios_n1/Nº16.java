package exercicios_n1;
import java.util.Scanner;

public class Nº16 {
	
	/*
	 * 16-Na empresa em que trabalhamos, há tabelas com o gasto de cada mês. 
	 * Para fechar o balanço do primeiro trimestre, 
	 * precisamos somar o gasto total. 
	 * Sabendo que, em janeiro, foram gastos 15 mil reais, 
	 * em fevereiro, 23 mil reais e, em março, 17 mil reais, 
	 * faça um programa que calcule e imprima 
	 * a despesa total no trimestre e a média mensal de gastos.
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		float totalTrimestre = 55000F;
		
		System.out.printf("Os gastos do trimestre são: R$ %,.2f \n", totalTrimestre);
		
		System.out.printf("O gasto medio mensal do trimestre é: R$ %,.2f", totalTrimestre / 3);

		input.close();
	}

}
