package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class MetalTransição extends Controller{
	
	private String nome = "Ósmio";
	private int numeroAtomico = 76;
	private float densidade = 22.59F;
	
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
	
	public void fusionar(ActionEvent e) {
		TituloInformação.setText("Fusionar");
		DescriçãoInformação.setText(nome + " entra em processo de fusão");
	}
	
	public void solidificar(ActionEvent e) {
		TituloInformação.setText("Solidificar");
		DescriçãoInformação.setText(nome + " está se solidificando");
	}
	
	public void oxidar(ActionEvent e) {
		TituloInformação.setText("Oxidar");
		DescriçãoInformação.setText(nome + " começa a oxidar");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroAtomico() {
		return numeroAtomico;
	}

	public void setNumeroAtomico(int numeroAtomico) {
		this.numeroAtomico = numeroAtomico;
	}

	public float getDensidade() {
		return densidade;
	}

	public void setDensidade(float densidade) {
		this.densidade = densidade;
	}
}
