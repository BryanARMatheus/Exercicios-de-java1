package exercicios_n2;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main extends Objetos{


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

					System.out.println("Escolha o objeto");
					System.out.println("1 - " + navio1.getNome());
					System.out.println("2 - " + navio2.getNome());
					opção = input.nextInt();

				} while(opção != 1 && opção != 2);
				navio1.menu();
				opção2 = input.nextInt();

				do {
					if(opção == 1) {
						switch (opção2) {

						case 1:
							System.out.println(navio1.getNome());
							System.out.println(navio1.getClasse());
							System.out.println(navio1.getAnoDeConstrução());
							break;
						case 2: navio1.navegar();
						break;
						case 3: navio1.atirar();
						break;
						case 4: System.out.println("Voltando ao menu principal");
						break;
						default: System.out.println("Digite um valor existente!");

						}

					}else {

						switch (opção2) {
						case 1:
							System.out.println(navio2.getNome());
							System.out.println(navio2.getClasse());
							System.out.println(navio2.getAnoDeConstrução());
							break;
						case 2: navio2.navegar();
						break;
						case 3: navio2.atirar();
						break;
						case 4: System.out.println("Voltando ao menu principal");
						break;
						default: System.out.println("Digite um valor existente!");

						}
					}
					String esperar = input.next();
				}while(opção2 != 4);

				break;

			case 2:

				elemento1.menu();
				opção2 = input.nextInt();
				do {
					switch (opção2) {

					case 1:
						System.out.println(elemento1.getTipo());
						System.out.println(elemento1.getGrau());
						System.out.println(elemento1.getFoco());
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

				break;

			case 3:
				monstro1.menu();
				opção2 = input.nextInt();
				do {
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
				break;

			case 4:
				do {

					System.out.println("Escolha a musica");
					System.out.println("1 - " + musica1.getArtista() + musica1.getNome());
					System.out.println("2 - " +  musica2.getArtista() + musica2.getNome());
					System.out.println("3 - " +  musica3.getArtista() + musica3.getNome());
					opção = input.nextInt();

				} while(opção != 1 && opção != 2 && opção != 3);
				
				do {
				musica1.menu();
				opção2 = input.nextInt();

					if(opção == 1) {
						switch (opção2) {

						case 1:
							System.out.print(musica1.getNome());
							System.out.print(musica1.getTamanho());
							System.out.print(musica1.getArtista());
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
						musica1.pausar();
						break;
						default: System.out.println("Digite um valor existente!");
						}
						teste = opção2;

					}else if(opção == 2) {
						
						switch (opção2) {

						case 1:
							System.out.print(musica2.getNome());
							System.out.print(musica2.getTamanho());
							System.out.print(musica2.getArtista());

							break;
						case 2: 
							if(teste != 2) {
								musica2.tocarMusica2();
							}else {
								musica2.reiniciarMusica2();
								musica2.tocarMusica2();
							}
						break;
						case 3: musica2.pausarMusica2();
						break;
						case 4: System.out.println("Voltando ao menu principal");
						musica2.pausarMusica2();
						break;
						default: System.out.println("Digite um valor existente!");
						}
						teste = opção2;
						
					}else {

						switch (opção2) {

						case 1:
							System.out.print(musica3.getNome());
							System.out.print(musica3.getTamanho());
							System.out.print(musica3.getArtista());
							break;
						case 2: 
							if(teste != 2) {
								musica3.tocarMusica3();
							}else {
								musica3.reiniciarMusica3();
								musica3.tocarMusica3();
							}
						break;
						case 3: musica3.pausarMusica3();
						break;
						case 4: System.out.println("Voltando ao menu principal");
						musica3.pausarMusica3();
						break;
						default: System.out.println("Digite um valor existente!");
						}
						teste = opção2;
						};
						String esperar = input.next();
				}while(opção2 != 4);


				break;

			case 5:
				jogo1.menu();
				opção2 = input.nextInt();
				do {
					switch (opção2) {

					case 1:
						System.out.print(jogo1.getNome());
						System.out.print(jogo1.getGenero());
						System.out.print(jogo1.getTema());
						break;
					case 2: jogo1.jogar();
					break;
					case 3: jogo1.ouvirMusica();
					break;
					case 4: System.out.println("Voltando ao menu principal");
					break;
					default: System.out.println("Digite um valor existente!");
					}					
				}while(opção2 != 4);
				
				break;

			case 6:
				do {

					System.out.println("Escolha o objeto");
					System.out.println("1 - " + gato1.getNome());
					System.out.println("2 - " + gato2.getNome());
					opção = input.nextInt();

				} while(opção != 1 && opção != 2);
				gato1.menu();
				opção2 = input.nextInt();

				do {
					if(opção == 1) {
						switch (opção2) {

						case 1:
							System.out.print(gato1.getNome());
							System.out.print(gato1.getRaça());
							System.out.print(gato1.getIdade());
							break;
						case 2: gato1.andar();
						break;
						case 3: gato1.dormir();
						break;
						case 4: System.out.println("Voltando ao menu principal");
						break;
						default: System.out.println("Digite um valor existente!");

						}

					}else {

						switch (opção2) {
						case 1:
							System.out.print(gato2.getNome());
							System.out.print(gato2.getRaça());
							System.out.print(gato2.getIdade());
							break;
						case 2: gato2.andar();
						break;
						case 3: gato2.dormir();
						break;
						case 4: System.out.println("Voltando ao menu principal");
						break;
						default: System.out.println("Digite um valor existente!");

						}
					}
					String esperar = input.next();
				}while(opção2 != 4);

				break;

			case 7:

				raposa1.menu();
				opção2 = input.nextInt();
				do {
					switch (opção2) {

					case 1:
						System.out.print(raposa1.getRaça());
						System.out.print(raposa1.getHabitat());
						System.out.print(raposa1.getCor());
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

				break;

			case 8:

				metal1.menu();
				opção2 = input.nextInt();
				do {
					switch (opção2) {

					case 1:
						System.out.print(metal1.getNome());
						System.out.print(metal1.getNumeroAtomico());
						System.out.print(metal1.getDensidade());
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

				break;
			case 9:
				arte1.menu();
				opção2 = input.nextInt();
				do {
					switch (opção2) {

					case 1:
						System.out.print(arte1.getMetodoDesenho());
						System.out.print(arte1.getTipo());
						System.out.print(arte1.getInstrumentoDesenho());
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
				break;

			case 10:
				heroi1.menu();
				opção2 = input.nextInt();
				do {
					switch (opção2) {

					case 1:
						System.out.print(heroi1.getAtaque());
						System.out.print(heroi1.getDefesa());
						System.out.print(heroi1.getVida());
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
				break;

			case 11: System.out.println("Saindo");
			break;
			
			default:
				System.out.println("Esta opção é invalida!");
			}

		}while(opção != 11);

		input.close();
	}

}
