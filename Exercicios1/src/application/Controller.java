package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Controller extends Main {
	
	protected Stage stage;
	protected Scene scene;
	protected Parent root;
	
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
	
	
	
	String css = this.getClass().getResource("application.css").toExternalForm();
	
	
	Image floppaMenu = new Image(getClass().getResourceAsStream("/Imagens/menuImage.jpg"));	
	
	public void voltarMenu(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
		TituloInformação.setText("Bem vindo");
		ImagemInformação.setImage(floppaMenu);
		DescriçãoInformação.setText("Informações cruciais apareceram aqui");
	}
	
	public void mudarNavio(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Navio.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarElemento(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Elemento.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarMonstro(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Monstro.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarMusica(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Musica.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarJogo(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Jogo.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarGato(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Gato.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarRaposa(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Raposa.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarMetal(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("MetalTransição.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarArte(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Arte.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void mudarHeroi(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Heroi.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public void descriçãoNavio(MouseEvent event) throws IOException{
		Image navioMenu = new Image(getClass().getResourceAsStream("/Imagens/navios.png"));
		TituloInformação.setText("Navio");
		ImagemInformação.setImage(navioMenu);
		DescriçãoInformação.setText("Uma classe que representa navios");
	}
	
	public void descriçãoElemento(MouseEvent event) throws IOException{
		Image elementoMenu = new Image(getClass().getResourceAsStream("/Imagens/elementos.png"));
		TituloInformação.setText("Elemento");
		ImagemInformação.setImage(elementoMenu);
		DescriçãoInformação.setText("Uma classe que representa elementos como fogo e água");
	}
	
	public void descriçãoMonstro(MouseEvent event) throws IOException{
		Image monstroMenu = new Image(getClass().getResourceAsStream("/Imagens/monstros.png"));
		TituloInformação.setText("Monstro");
		ImagemInformação.setImage(monstroMenu);
		DescriçãoInformação.setText("Uma classe que representa monstros especificamente de jogos eletrônicos");
	}
	
	public void descriçãoMusica(MouseEvent event) throws IOException{
		Image musicaMenu = new Image(getClass().getResourceAsStream("/Imagens/takoPlayer.png"));
		TituloInformação.setText("Tako Player");
		ImagemInformação.setImage(musicaMenu);
		DescriçãoInformação.setText("Um projeto de MP3 player que pode tocar audios");
	}
	
	public void descriçãoJogo(MouseEvent event) throws IOException{
		Image jogoMenu = new Image(getClass().getResourceAsStream("/Imagens/jogos.png"));
		TituloInformação.setText("Jogo");
		ImagemInformação.setImage(jogoMenu);
		DescriçãoInformação.setText("Uma classe que representa jogos");
	}
	
	public void descriçãoGato(MouseEvent event) throws IOException{
		Image gatoMenu = new Image(getClass().getResourceAsStream("/Imagens/gatos.png"));
		TituloInformação.setText("Gato");
		ImagemInformação.setImage(gatoMenu);
		DescriçãoInformação.setText("Uma classe que representa gatos");
	}
	
	public void descriçãoRaposa(MouseEvent event) throws IOException{
		Image raposaMenu = new Image(getClass().getResourceAsStream("/Imagens/raposas.png"));
		TituloInformação.setText("Raposa");
		ImagemInformação.setImage(raposaMenu);
		DescriçãoInformação.setText("Uma classe que representa raposas");
	}
	
	public void descriçãoMetal(MouseEvent event) throws IOException{
		Image metalMenu = new Image(getClass().getResourceAsStream("/Imagens/metaisTransição.png"));
		TituloInformação.setText("Metais de Transição");
		ImagemInformação.setImage(metalMenu);
		DescriçãoInformação.setText("Uma classe que representa metais de transição baseados na tabela periódica");
	}
	
	public void descriçãoArte(MouseEvent event) throws IOException{
		Image arteMenu = new Image(getClass().getResourceAsStream("/Imagens/artes.png"));
		TituloInformação.setText("Arte");
		ImagemInformação.setImage(arteMenu);
		DescriçãoInformação.setText("Uma classe que representa formas de arte");
	}
	
	public void descriçãoHeroi(MouseEvent event) throws IOException{
		Image heroiMenu = new Image(getClass().getResourceAsStream("/Imagens/herois.png"));
		TituloInformação.setText("Heroí");
		ImagemInformação.setImage(heroiMenu);
		DescriçãoInformação.setText("Uma classe que representa heroís principalmente de jogos eletrônicos");
	}
	
	public void descriçãoMenu(MouseEvent event) throws IOException{
		TituloInformação.setText("Bem vindo");
		ImagemInformação.setImage(floppaMenu);
		DescriçãoInformação.setText("Informações cruciais apareceram aqui");
	}


}
