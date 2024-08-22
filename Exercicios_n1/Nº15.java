package exercicios_n1;
import java.util.Scanner;

public class Nº15 {
	
	/*
	 * 15-A jornada de trabalho semanal de um funcionário é de 40 horas. 
	 * O funcionário que trabalhar mais de 40 horas receberá hora extra, 
	 * cujo cálculo é o valor da hora regular com um acréscimo de 50%. 
	 * Escreva um algoritmo que leia o número de horas trabalhadas em um mês, 
	 * o salário por hora e escreva o salário total do funcionário, 
	 * que deverá ser acrescido das horas extras, caso tenham sido trabalhadas 
	 * (considere que o mês possua 4 semanas exatas). 
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		

		System.out.println("Quantas horas mensais foram trabalhadas?");
		int horasTrabalhadas = input.nextInt();
		
		System.out.println("Digite o salario por hora");
		float salarioHora = input.nextFloat();

		
		if (horasTrabalhadas > 160) {
			
			float salarioTotal = salarioHora * 160 + ((horasTrabalhadas - 160) * salarioHora * 1.5F);
			System.out.printf("O salario do mês do funcionario é: R$ %,.2f", salarioTotal);
			
		}else {
			
			float salarioTotal = salarioHora * horasTrabalhadas;
			System.out.printf("O salario do mês do funcionario é: R$ %,.2f", salarioTotal);
			
			}	
		
		input.close();
	}

}
