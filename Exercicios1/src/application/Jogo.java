package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Jogo extends Controller{
	
	private String nome = "RainWorld";
	private String genero;
	private String tema;
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	@FXML
	private VBox VboxOpcoes, VboxInformação;
	@FXML
	private Label menuLabel;
	
	public void jogar(ActionEvent e) {
		TituloInformação.setText("Jogar");
		DescriçãoInformação.setText("Você começa a jogar " + nome);
	}
	
	public void ouvirMusica(ActionEvent e) {
		TituloInformação.setText("Ouvir musica");
		DescriçãoInformação.setText("Você escuta a musica do ambiente");
	}
	
	public void observar(ActionEvent e) {
		TituloInformação.setText("Observar");
		DescriçãoInformação.setText("Você observa o mundo do jogo");
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
	
}
