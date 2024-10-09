package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class Elemento extends Controller implements Initializable{
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	@FXML
	private ChoiceBox<String> EscolhaTipo;
	@FXML
	private ChoiceBox<Integer> EscolhaGrau;
	@FXML
	private ChoiceBox<String> EscolhaFoco;
	@FXML
	private VBox VboxOpcoes, VboxInformação;
	@FXML
	private Label menuLabel;
	
	private String[] Etipo = {"Fogo","Água","Terra","Vento","Luz","Escuridão"};
	private Integer[] Egrau = {1,2,3,4,5,6,7,8,9};
	private String[] Efoco = {"Ataque","Defesa","Cura","Suporte"};
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		EscolhaTipo.getItems().addAll(Etipo);
		EscolhaGrau.getItems().addAll(Egrau);
		EscolhaFoco.getItems().addAll(Efoco);
	}
	
	private String tipo = "";
	private int grau = 0;
	private String foco = "";
	
	public void imbuir(ActionEvent e) {
		tipo = EscolhaTipo.getValue();
		
		TituloInformação.setText("Imbuir");
		DescriçãoInformação.setText("Você imbui sua arma em " + tipo);
	}
	
	public void evocar(ActionEvent e) {
		tipo = EscolhaTipo.getValue();
		grau = EscolhaGrau.getValue();
		
		TituloInformação.setText("Evocar");
		DescriçãoInformação.setText("Você evoca o elemento " + tipo + " de grau " + grau);
	}
	
	public void atacar(ActionEvent e) {
		tipo = EscolhaTipo.getValue();
		grau = EscolhaGrau.getValue();
		foco = EscolhaFoco.getValue();
		
		TituloInformação.setText("Atacar");
		DescriçãoInformação.setText("Você invoca uma magia de " + tipo + " de grau " + grau + " focada em " + foco);
	}

	public String[] getETipo() {
		return Etipo;
	}

	public void setETipo(String[] tipo) {
		this.Etipo = tipo;
	}

	public Integer[] getEGrau() {
		return Egrau;
	}

	public void setEGrau(Integer[] grau) {
		this.Egrau = grau;
	}

	public String[] getEFoco() {
		return Efoco;
	}

	public void setEFoco(String[] foco) {
		this.Efoco = foco;
	}
}
