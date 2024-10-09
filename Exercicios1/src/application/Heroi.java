package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class Heroi extends Controller{
	
	private int ataque = 100;
	private int defesa;
	private int vida;
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	@FXML
	private VBox VboxOpcoes, VboxInformação;
	@FXML
	private Text menuLabel;
	
	public void atacar(ActionEvent e) {
		TituloInformação.setText("Atacar");
		DescriçãoInformação.setText("O heroi ataca o mostro e dá " + ataque + " de dano!");
	}
	
	public void defender(ActionEvent e) {
		TituloInformação.setText("Defender");
		DescriçãoInformação.setText("O heroi se defende do ataque");
	}
	
	public void desviar(ActionEvent e) {
		TituloInformação.setText("Desviar");
		DescriçãoInformação.setText("O heroi desvia do ataque");
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
}
