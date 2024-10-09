package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	
	public void check() {
		if(Bismark.isSelected()) {
			nome = "Bismark";
			classe = "Couraçado";
			anoDeConstrução = 1939;

			TituloInformação.setText("Bismark");
			DescriçãoInformação.setText("Nome: " + nome + "\nClasse: " + classe + "\nAno De Construção: " + anoDeConstrução);

		} else if (Deutschland.isSelected()){
			nome = "Deutschland";
			classe = "Cruzador pesado";
			anoDeConstrução = 1931;

			TituloInformação.setText("Deutschland");
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
			DescriçãoInformação.setText("Nome: " + nome + "\nClasse: " + classe + "\nAno De Construção: " + anoDeConstrução);

		} else if (Deutschland.isSelected()){
			nome = "Deutschland";
			classe = "Cruzador pesado";
			anoDeConstrução = 1931;

			TituloInformação.setText("Deutschland");
			DescriçãoInformação.setText("Nome: " + nome + "\nClasse: " + classe + "\nAno De Construção: " + anoDeConstrução);

		}
	}
	
	public void virar(ActionEvent e) {
		TituloInformação.setText("Virar");
		DescriçãoInformação.setText("Você muda a direção do navio");
	}
	
	public void navegar(ActionEvent e) {
		TituloInformação.setText("Navegar");
		DescriçãoInformação.setText("O navio começa a navegar");
	}
	
	public void atirar(ActionEvent e) {
		TituloInformação.setText("Atirar");
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
