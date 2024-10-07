package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class Arte extends Controller{
	
	private String metodoDesenho;
	private String tipo;
	private String instrumentoDesenho;
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	
	public void desenhar(ActionEvent e){
		TituloInformação.setText("Desenhar");
		DescriçãoInformação.setText("Você desenha uma nova obra");
	}
	
	public void colorir(ActionEvent e) {
		TituloInformação.setText("Colorir");
		DescriçãoInformação.setText("Você adiciona cor ao seu desenho");
	}
	
	public void apagar(ActionEvent e) {
		TituloInformação.setText("Apagar");
		DescriçãoInformação.setText("Você identifica um erro no desenho e o apaga");
	}

	public String getMetodoDesenho() {
		return metodoDesenho;
	}

	public void setMetodoDesenho(String metodoDesenho) {
		this.metodoDesenho = metodoDesenho;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getInstrumentoDesenho() {
		return instrumentoDesenho;
	}

	public void setInstrumentoDesenho(String instrumentoDesenho) {
		this.instrumentoDesenho = instrumentoDesenho;
	}
	

}
