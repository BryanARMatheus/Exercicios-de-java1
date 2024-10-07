package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Monstro extends Controller{
	
	private String nome;
	private String raça;
	private int nivel;
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	
	public void defender(ActionEvent e) {
		TituloInformação.setText("Fusionar");
		DescriçãoInformação.setText("O monstro se defende do ataque");
	}
	
	public void atacar(ActionEvent e) {
		TituloInformação.setText("Fusionar");
		DescriçãoInformação.setText("O monstro realiza um ataque fisico!");
	}
	
	public void desviar(ActionEvent e) {
		TituloInformação.setText("Fusionar");
		DescriçãoInformação.setText("O monstro desvia do ataque");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
