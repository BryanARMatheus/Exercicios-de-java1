package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;

public class Gato extends Controller {
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
	
	public void check() {
		if(Estrôncio.isSelected()) {
			raça = "Maine Coon";
			nome = "Estrôncio";
			idade = 5;
		} else if (Ytterbium.isSelected()) {
			raça = "Angorá Turco";
			nome = "Ytterbium";
			idade = 11;
		}
	}
	
	public void andar(ActionEvent e) {
		check();
		TituloInformação.setText("Andar");
		DescriçãoInformação.setText(nome + " está andando");
	}
	
	public void comer(ActionEvent e) {
		check();
		TituloInformação.setText("Comer");
		DescriçãoInformação.setText(nome + " começou a comer");
	}
	
	public void dormir(ActionEvent e) {
		check();
		TituloInformação.setText("Andar");
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
