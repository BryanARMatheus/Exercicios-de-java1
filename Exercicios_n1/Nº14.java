package exercicios_n1;
import java.util.Scanner;

public class Nº14 {
	
	/*
	 * 14-Ler a hora de início e a hora de fim de um jogo de Xadrez 
	 * (considere apenas horas inteiras, sem os minutos) 
	 * e calcule a duração do jogo em horas, 
	 * sabendo-se que o tempo máximo de duração do jogo é de 24 horas 
	 * e que o jogo pode iniciar em um dia 
	 * e terminar no dia seguinte.
	 */
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a hora de inicio (utilize metodo de hora militar)");
		System.out.println("Considere meia noite como 00");
		int horaInicio = input.nextInt();
		System.out.println("Digite a hora de termino");
		int horaFim = input.nextInt();
		
		if (horaInicio < horaFim) {

			System.out.println("O jogo durou " + (horaFim - horaInicio) + " horas");
		
		}else {
			
			if(horaFim + horaInicio > 24) {
				System.out.println("O jogo durou " + (24 - horaInicio + horaFim) + " horas");
			}else if (24 - horaInicio + horaFim > 24) {
				System.out.println("Um jogo não pode durar mais de 24 horas!");
			}else {
				System.out.println("O jogo durou " + (horaFim + horaInicio) + " horas");
			}
			
		}
		
		input.close();
	}

}
