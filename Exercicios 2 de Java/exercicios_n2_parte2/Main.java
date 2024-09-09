package exercicios_n2_parte2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		Fração fração3 = new Fração(0,0); 
		
		System.out.println("Calculadora de frações");
		System.out.println("Insira o numero de frações que serão calculadas");
		int numFrações = input.nextInt();
		
		System.out.println("Em caso de parenteses insira as contas contidas dentro primeiro");
		System.out.println("Insira o primeiro numerador");
		int numerador = input.nextInt();
		System.out.println("Insira o primeiro denominador");
		int denominador = input.nextInt();
		Fração fração1 = new Fração(numerador,denominador);		

		
		
		if (numFrações > 2) {
			
			for(int i = 2;i != numFrações + 1; i++) {
				
				input.nextLine();
				System.out.println("Escolha a operação");
				String operação = input.nextLine();
				
				System.out.println("Insira o " + i + " numerador");
				int numerador2 = input.nextInt();
				System.out.println("Insira o " + i + " denominador");
				int denominador2 = input.nextInt();
				
				Fração fração2 = new Fração(numerador2, denominador2);
				
				switch(operação) {
				case "+": fração3 = fração1.soma(fração2);
					break;
				case "-": fração3 = fração1.subtração(fração2);
					break;
				case "*": fração3 = fração1.multiplicação(fração2);
					break;
				case "/": fração3 = fração1.divisão(fração2);
					break;
				}

				fração1 = fração3;
			}
		}else {
			input.nextLine();
			
			System.out.println("Escolha a operação");
			String operação = input.nextLine();
			
			System.out.println("Insira o segundo numerador");
			int numerador2 = input.nextInt();
			System.out.println("Insira o segundo denominador");
			int denominador2 = input.nextInt();
			Fração fração2 = new Fração(numerador2, denominador2);
			
			switch(operação) {
			case "+": fração3 = fração1.soma(fração2);
				break;
			case "-": fração3 = fração1.subtração(fração2);
				break;
			case "*": fração3 = fração1.multiplicação(fração2);
				break;
			case "/": fração3 = fração1.divisão(fração2);
				break;
			}
		}
		
		fração3.simplificar();
		
		System.out.println(fração3.toString());
				
		input.close();
	}

}
