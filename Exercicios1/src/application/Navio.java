package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Navio extends Controller implements Initializable{
	private String nome;
	private String classe;
	private int anoDeConstrução;
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	@FXML
	private RadioButton Bismark, Deutschland;
	@FXML
	private VBox VboxOpcoes, VboxInformação;
	@FXML
	private Label menuLabel;
	
	Image bismark = new Image(getClass().getResourceAsStream("/Imagens/Bismark.jpg"));
	Image deutschland = new Image(getClass().getResourceAsStream("/Imagens/Deutschland.jpg"));
	
	public void check() {
		if(Bismark.isSelected()) {
			nome = "Bismark";
			classe = "Couraçado";
			anoDeConstrução = 1939;

			TituloInformação.setText("Bismark");
			ImagemInformação.setImage(bismark);
			DescriçãoInformação.setText("Nome: " + nome + "\nClasse: " + classe + "\nAno De Construção: " + anoDeConstrução);

		} else if (Deutschland.isSelected()){
			nome = "Deutschland";
			classe = "Cruzador pesado";
			anoDeConstrução = 1931;

			TituloInformação.setText("Deutschland");
			ImagemInformação.setImage(deutschland);
			DescriçãoInformação.setText("Nome: " + nome + "\nClasse: " + classe + "\nAno De Construção: " + anoDeConstrução);

		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Bismark.isSelected()) {
			nome = "Bismark";
			classe = "Couraçado";
			anoDeConstrução = 1939;

			TituloInformação.setText("Bismark");
			ImagemInformação.setImage(bismark);
			DescriçãoInformação.setText("Nome: " + nome + "\nClasse: " + classe + "\nAno De Construção: " + anoDeConstrução);

		} else if (Deutschland.isSelected()){
			nome = "Deutschland";
			classe = "Cruzador pesado";
			anoDeConstrução = 1931;

			TituloInformação.setText("Deutschland");
			ImagemInformação.setImage(deutschland);
			DescriçãoInformação.setText("Nome: " + nome + "\nClasse: " + classe + "\nAno De Construção: " + anoDeConstrução);

		}
	}
	
	public void virar(ActionEvent e) {
		Image barcoVirar = new Image(getClass().getResourceAsStream("/Imagens/virarBarco.jpg"));
		TituloInformação.setText("Virar");
		ImagemInformação.setImage(barcoVirar);
		DescriçãoInformação.setText("Você muda a direção do navio");
	}
	
	public void navegar(ActionEvent e) {
		Image barcoNavegar = new Image(getClass().getResourceAsStream("/Imagens/navioNavegando.jpg"));
		TituloInformação.setText("Navegar");
		ImagemInformação.setImage(barcoNavegar);
		DescriçãoInformação.setText("O navio começa a navegar");
	}
	
	public void atirar(ActionEvent e) {
		Image barcoAtirar = new Image(getClass().getResourceAsStream("/Imagens/barcoAtirar.jpg"));
		TituloInformação.setText("Atirar");
		ImagemInformação.setImage(barcoAtirar);
		DescriçãoInformação.setText("Você atira com as armas principais do navio!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getAnoDeConstrução() {
		return anoDeConstrução;
	}

	public void setAnoDeConstrução(int anoDeConstrução) {
		this.anoDeConstrução = anoDeConstrução;
	}
}
