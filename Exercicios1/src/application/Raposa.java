package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Raposa extends Controller{
	
	private String raça;
	private String habitat;
	private String cor;
	
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
	
	Image raposaCacar = new Image(getClass().getResourceAsStream("/Imagens/raposaCacando.jpg"));
	Image raposaCorrer = new Image(getClass().getResourceAsStream("/Imagens/raposaCorrendo.jpg"));
	Image raposaComunicar = new Image(getClass().getResourceAsStream("/Imagens/raposaComunica.jpg"));
	
	public void cacar(ActionEvent e) {
		TituloInformação.setText("Caçar");
		ImagemInformação.setImage(raposaCacar);
		DescriçãoInformação.setText("A raposa está caçando um coelho");
	}
	
	public void correr(ActionEvent e) {
		TituloInformação.setText("Correr");
		ImagemInformação.setImage(raposaCorrer);
		DescriçãoInformação.setText("A raposa está correndo!");
	}
	
	public void comunicar(ActionEvent e) {
		TituloInformação.setText("Comunicar");
		ImagemInformação.setImage(raposaComunicar);
		DescriçãoInformação.setText("As raposas se comunicam entre si");
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
