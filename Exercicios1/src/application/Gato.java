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

public class Gato extends Controller implements Initializable{
	private String raça;
	private String nome;
	private int idade;
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	@FXML
	private RadioButton Estrôncio, Ytterbium;
	@FXML
	private VBox VboxOpcoes, VboxInformação;
	@FXML
	private Label menuLabel;
	
	Image estroncio = new Image(getClass().getResourceAsStream("/Imagens/Estroncio.jpg"));
	Image ytterbium = new Image(getClass().getResourceAsStream("/Imagens/Ytterbium.jpg"));
	
	public void check() {
		if(Estrôncio.isSelected()) {
			raça = "Maine Coon";
			nome = "Estrôncio";
			idade = 5;

			TituloInformação.setText("Estrôncio");
			ImagemInformação.setImage(estroncio);
			DescriçãoInformação.setText("Raça: " + raça + "\nNome: " + nome + "\nIdade: " + idade);

		} else if (Ytterbium.isSelected()) {
			raça = "Angorá Turco";
			nome = "Ytterbium";
			idade = 11;

			TituloInformação.setText("Ytterbium");
			ImagemInformação.setImage(ytterbium);
			DescriçãoInformação.setText("Raça: " + raça + "\nNome: " + nome + "\nIdade: " + idade);

		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Estrôncio.isSelected()) {
			raça = "Maine Coon";
			nome = "Estrôncio";
			idade = 5;

			TituloInformação.setText("Estrôncio");
			ImagemInformação.setImage(estroncio);
			DescriçãoInformação.setText("Raça: " + raça + "\nNome: " + nome + "\nIdade: " + idade);

		} else if (Ytterbium.isSelected()) {
			raça = "Angorá Turco";
			nome = "Ytterbium";
			idade = 11;

			TituloInformação.setText("Ytterbium");
			ImagemInformação.setImage(ytterbium);
			DescriçãoInformação.setText("Raça: " + raça + "\nNome: " + nome + "\nIdade: " + idade);

		}
	}
	
	public void andar(ActionEvent e) {
		Image gatoAndar = new Image(getClass().getResourceAsStream("/Imagens/gatoAndar.jpg"));
		TituloInformação.setText("Andar");
		ImagemInformação.setImage(gatoAndar);
		DescriçãoInformação.setText(nome + " está andando");
	}
	
	public void comer(ActionEvent e) {
		Image gatoComer = new Image(getClass().getResourceAsStream("/Imagens/gatoComer.jpg"));
		TituloInformação.setText("Comer");
		ImagemInformação.setImage(gatoComer);
		DescriçãoInformação.setText(nome + " começou a comer");
	}
	
	public void dormir(ActionEvent e) {
		Image gatoDormir = new Image(getClass().getResourceAsStream("/Imagens/gatoDormir.png"));
		TituloInformação.setText("Andar");
		ImagemInformação.setImage(gatoDormir);
		DescriçãoInformação.setText("shhh " + nome + " está dormindo");
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


}
