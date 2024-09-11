package exercicios_n2;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Musica implements MenuMetodos {
	private File arquivo;
	private String nome;
	private int tamanho;
	private String artista;
	private Clip clip;
	
	Musica(String nome, int tamanho, String artista) {
		this.setNome(nome);
		this.setTamanho(tamanho);
		this.setArtista(artista);
		arquivo = new File(nome);
	}

	void tocar() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	
	void pausar() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		clip.stop();
	}
	
	void reiniciar() {
		clip.close();
		clip.setMicrosecondPosition(0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Tocar");
		System.out.println("3 - Pausar");
		System.out.println("4 - Sair");
	}
}
