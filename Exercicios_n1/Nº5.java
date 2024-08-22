package exercicios_n1;
import java.util.Scanner;

public class Nº5 {
	
	/*
	 * 5-Uma revendedora de carros usados 
	 * paga a seus funcionários vendedores um salário fixo por mês, 
	 * mais uma comissão também fixa para cada carro vendido 
	 * e mais 5% do valor das vendas por ele efetuadas. 
	 * Escrever um algoritmo que leia o número de carros por ele vendidos, 
	 * o valor total de suas vendas, 
	 * o salário fixo e o valor que ele recebe por carro vendido. 
	 * Calcule e escreva o salário final do vendedor.
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o numero de carros vendidos");
		int numCarros = input.nextInt();
		
		System.out.println("Digite a comissão por veiculo vendido");
		float comCarroVendido = input.nextFloat();

		System.out.println("Digite o valor total adquirido das vendas");
		float vendasTotal = input.nextFloat();
		
		System.out.println("Digite o salario fixo do vendedor");
		float salario = input.nextFloat();
		
		float salarioFinal = (comCarroVendido * numCarros) + (vendasTotal * 5 / 100) + salario;
		System.out.printf("O salario final do vendedor é R$ %,.2f", salarioFinal);
		
		input.close();
	}

}
