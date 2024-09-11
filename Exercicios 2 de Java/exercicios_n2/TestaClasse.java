package exercicios_n2;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TestaClasse extends Objetos{


	@SuppressWarnings("unused")
	public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException {

		Scanner input = new Scanner(System.in);

		int opção = 0;
		int teste = 0;

		do {

			System.out.println("Escolha uma classe para testar");
			System.out.println("1 - Navio");
			System.out.println("2 - Elemento");
			System.out.println("3 - Monstro");		
			System.out.println("4 - Música");
			System.out.println("5 - Jogo");
			System.out.println("6 - Gato");
			System.out.println("7 - Raposa");
			System.out.println("8 - Metal de transição");
			System.out.println("9 - Arte");
			System.out.println("10 - Heroí");
			System.out.println("11 - Sair");

			opção = input.nextInt();
			int opção2 = 0;

			switch (opção) {

			case 1:

				do {
					navio1.menu();
					opção2 = input.nextInt();

					switch (opção2) {
					case 1:
						System.out.println("Nome: " + navio1.getNome());
						System.out.println("Classe: " + navio1.getClasse());
						System.out.println("Ano de construção: " + navio1.getAnoDeConstrução());
						break;
					case 2: navio1.navegar();
					break;
					case 3: navio1.atirar();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 2:
				do {
					elemento1.menu();
					opção2 = input.nextInt();

					switch (opção2) {

					case 1:
						System.out.println("Tipo: " + elemento1.getTipo());
						System.out.println("Grau: " + elemento1.getGrau());
						System.out.println("Foco: " + elemento1.getFoco());
						break;
					case 2: elemento1.imbuir();
					break;
					case 3: elemento1.evocar();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 3:
				do {
					monstro1.menu();
					opção2 = input.nextInt();

					switch (opção2) {

					case 1:
						System.out.println(monstro1.getNome());
						System.out.println(monstro1.getRaça());
						System.out.println(monstro1.getNivel());
						break;
					case 2: monstro1.atacar();
					break;
					case 3: monstro1.defender();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");

					}
					
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 4:
				do {
					musica1.menu();
					opção2 = input.nextInt();

					switch (opção2) {

					case 1:
						System.out.println("Nome: " + musica1.getNome());
						System.out.println("Segundos: " + musica1.getTamanho() + "s");
						System.out.println("Artista: " + musica1.getArtista());
						String esperar = input.next();
						break;
					case 2: 
						if(teste != 2) {
							musica1.tocar();
						}else {
							musica1.reiniciar();
							musica1.tocar();
						}
					break;
					case 3: musica1.pausar();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}
					teste = opção2;
					
				}while(opção2 != 4);
				musica1.tocar();
				musica1.pausar();
				System.out.print("\033[H\033[2J");

				break;

			case 5:
				do {
					jogo1.menu();
					opção2 = input.nextInt();
					switch (opção2) {

					case 1:
						System.out.println("Nome: " + jogo1.getNome());
						System.out.println("Gênero: " + jogo1.getGenero());
						System.out.println("Têma: " + jogo1.getTema());
						break;
					case 2: jogo1.jogar();
					break;
					case 3: jogo1.ouvirMusica();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}					
					String esperar = input.next();
				}while(opção2 != 4);

				jogo1.ouvirMusica();
				jogo1.fecharMusica();
				
				System.out.print("\033[H\033[2J");

				break;

			case 6:
				do {
					gato1.menu();
					opção2 = input.nextInt();

					switch (opção2) {

					case 1:
						System.out.println("Nome: " + gato1.getNome());
						System.out.println("Raça: " + gato1.getRaça());
						System.out.println("Idade: " + gato1.getIdade());
						break;
					case 2: gato1.andar();
					break;
					case 3: gato1.dormir();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 7:

				do {
					raposa1.menu();
					opção2 = input.nextInt();
					switch (opção2) {

					case 1:
						System.out.println("Raça: " + raposa1.getRaça());
						System.out.println("Habitat: " + raposa1.getHabitat());
						System.out.println("Cor: " + raposa1.getCor());
						break;
					case 2: raposa1.caçar();
					break;
					case 3: raposa1.correr();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 8:

				do {
					metal1.menu();
					opção2 = input.nextInt();
					switch (opção2) {

					case 1:
						System.out.println("Nome: " + metal1.getNome());
						System.out.println("Numero atômico: " + metal1.getNumeroAtomico());
						System.out.println("Densidade: " + metal1.getDensidade());
						break;
					case 2: metal1.fusionar();
					break;
					case 3: metal1.solidificar();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}				
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 9:
				do {
					arte1.menu();
					opção2 = input.nextInt();
					switch (opção2) {

					case 1:
						System.out.println("Metodo de desenho: " + arte1.getMetodoDesenho());
						System.out.println("Tipo: " + arte1.getTipo());
						System.out.println("Instrumento de desenho: " + arte1.getInstrumentoDesenho());
						break;
					case 2: arte1.desenhar();
					break;
					case 3: arte1.colorir();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}				
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 10:
				do {
					heroi1.menu();
					opção2 = input.nextInt();
					switch (opção2) {

					case 1:
						System.out.println("Ataque: " + heroi1.getAtaque());
						System.out.println("Defesa: " + heroi1.getDefesa());
						System.out.println("Vida: " + heroi1.getVida());
						break;
					case 2: heroi1.atacar();
					break;
					case 3: heroi1.defender();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}				
					String esperar = input.next();
				}while(opção2 != 4);

				System.out.print("\033[H\033[2J");

				break;

			case 11: System.out.println("Saindo");
			break;

			default: System.out.println("Esta opção é invalida!");
			}

		}while(opção != 11);

		input.close();
	}

}
