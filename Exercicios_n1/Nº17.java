package exercicios_n1;
import java.util.Scanner;

/*
 *17-Programa que leia as notas e calcule a média de LP1 deste semestre, 
 *referente a um determinado aluno.
 *
 *Fórmula para cálculo de média de LP1.
 *(P1*0.6+((E1+E2)/2)0.4)*0.5+
 *(max(((P1*0.6+((E1+E2)/2)*0.4)-5.9),0)/
 *((P1*0.6+((E1+E2)/2)*0.4)-5.9))(API*0.5)
 *+X+(SUB*0.2)
 */

public class Nº17 {
	
	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Insira a nota da primeira prova");
		float prova1 = input.nextFloat();
		System.out.println("Insira a nota da primeira lista");
		float exercicios1 = input.nextFloat();
		System.out.println("Insira a nota da segunda lista");
		float exercicios2 = input.nextFloat();
		System.out.println("Insira a nota da API");
		float api = input.nextFloat();
		
		float primeiraMetade = (prova1 * 0.6F + ((exercicios1 + exercicios2) / 2) * 0.4F) * 0.5F ;
		
		float segundaMetade = Math.max(primeiraMetade * 2 - 5.9F,0) / (primeiraMetade * 2 - 5.9F) * (api * 0.5F);

		System.out.println("Insira a quantidade de nota por atividades extras");
		float atividadesExtras = input.nextFloat();
		
		float recupera = 0.0F;

		if (primeiraMetade + segundaMetade + atividadesExtras < 6) {
		System.out.println("Insira a nota da recuperação");
		recupera = input.nextFloat() * 0.2F;
		}
		
		float notaFinal = primeiraMetade + segundaMetade + atividadesExtras + recupera;
		
		if (notaFinal > 10){
			System.out.println("A nota final do aluno é: 10.0");
		}else {
			System.out.printf("A nota final do aluno é: %,.1f \n", notaFinal);			
		}
		
		if (notaFinal > 6){
		    System.out.println("O aluno foi aprovado na disciplina");
		}else{
		    System.out.println("O aluno foi reprovado na disciplina");
		}

		input.close();
	}

}
