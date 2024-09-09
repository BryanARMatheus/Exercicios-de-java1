package exercicios_n2;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Jogo implements MenuMetodos{
	private String nome;
	private String genero;
	private String tema;
	private Clip clip;
	
	Jogo(String nome, String genero, String tema) {
		this.setNome(nome);
		this.setGenero(genero);
		this.setTema(tema);
		
	}
	
	void jogar(){
		System.out.println("Você começa a jogar " + nome);
	}
	
	File arquivo = new File("Bio-engineering.wav");
	
	void ouvirMusica() throws LineUnavailableException, IOException, UnsupportedAudioFileException{
		System.out.println("Você escuta a musica do ambiente");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(arquivo);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
	}
	
	void fecharMusica() {
		clip.stop();
	}
	
	void observar(){
		System.out.println("Você observa o mundo do jogo");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Jogar");
		System.out.println("3 - Ouvir a musica");
		System.out.println("4 - Sair");
	}
	
}
