package exercicios_n2;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Musica implements MenuMetodos {
	private String nome;
	private int tamanho;
	private String artista;
	private Clip clip;
	private Clip clip1;
	private Clip clip2;
	
	Musica(String nome, int tamanho, String artista) {
		this.setNome(nome);
		this.setTamanho(tamanho);
		this.setArtista(artista);
	}
	
	File arquivo = new File("HUG AND KILL.wav");
	File arquivo2 = new File("_1NF3S _ _0N_.wav");
	File arquivo3 = new File("Sledge.wav");
	
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
	
	void tocarMusica2() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo2);
		clip1 = AudioSystem.getClip();
		clip1.open(audioStream);
		clip1.start();
	}
	
	void pausarMusica2() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		clip1.stop();
	}
	
	void reiniciarMusica2() {		
		clip1.close();
		clip1.setMicrosecondPosition(0);
	}
	
	void tocarMusica3() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo3);
		clip2 = AudioSystem.getClip();
		clip2.close();
		clip2.open(audioStream);
		clip2.start();
	}
	
	void pausarMusica3() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
		clip2.stop();
	}
	
	void reiniciarMusica3() {
		clip2.close();
		clip2.setMicrosecondPosition(0);
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
