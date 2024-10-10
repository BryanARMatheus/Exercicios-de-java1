package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

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
	@FXML
	private VBox VboxOpcoes, VboxInformação;
	@FXML
	private Label menuLabel;
	
	Image monstroDefender = new Image(getClass().getResourceAsStream("/Imagens/monstroDefendendo.jpg"));
	Image monstroAtacar = new Image(getClass().getResourceAsStream("/Imagens/monstroAtaca.jpg"));
	Image monstroDesviar = new Image(getClass().getResourceAsStream("/Imagens/monstroDesvia.jpg"));
	
	
	public void defender(ActionEvent e) {
		TituloInformação.setText("Defender");
		ImagemInformação.setImage(monstroDefender);
		DescriçãoInformação.setText("O monstro se defende do ataque");
	}
	
	public void atacar(ActionEvent e) {
		TituloInformação.setText("Atacar");
		ImagemInformação.setImage(monstroAtacar);
		DescriçãoInformação.setText("O monstro realiza um ataque fisico!");
	}
	
	public void desviar(ActionEvent e) {
		TituloInformação.setText("Desviar");
		ImagemInformação.setImage(monstroDesviar);
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
