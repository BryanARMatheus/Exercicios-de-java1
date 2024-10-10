package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

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
	@FXML
	private VBox VboxOpcoes, VboxInformação;
	@FXML
	private Label menuLabel;
	
	
	public void desenhar(ActionEvent e){
		Image arteDesenhar = new Image(getClass().getResourceAsStream("/Imagens/desenhoDesenhado.png"));
		TituloInformação.setText("Desenhar");
		ImagemInformação.setImage(arteDesenhar);
		DescriçãoInformação.setText("Você desenha uma nova obra");
	}
	
	public void colorir(ActionEvent e) {
		Image arteColorir = new Image(getClass().getResourceAsStream("/Imagens/desenhoColor.png"));
		TituloInformação.setText("Colorir");
		ImagemInformação.setImage(arteColorir);
		DescriçãoInformação.setText("Você adiciona cor ao seu desenho");
	}
	
	public void apagar(ActionEvent e) {
		Image arteApagar = new Image(getClass().getResourceAsStream("/Imagens/desenhadoApagado.png"));
		TituloInformação.setText("Apagar");
		ImagemInformação.setImage(arteApagar);
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
