package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Controller extends Objetos{
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
	private Label TituloInformação;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Label DescriçãoInformação;
	
	public void voltarMenu(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		TituloInformação.setText("Bem vindo");
		DescriçãoInformação.setText("Informações cruciais apareceram aqui");
	}
	
	public void mudarNavio(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Navio.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarElemento(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Elemento.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarMonstro(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Monstro.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarMusica(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Musica.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarJogo(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Jogo.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarGato(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Gato.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarRaposa(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Raposa.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarMetal(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("MetalTransição.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarArte(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Arte.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void mudarHeroi(ActionEvent event) throws IOException{
		root = FXMLLoader.load(getClass().getResource("Heroi.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void descriçãoNavio(MouseEvent event) throws IOException{
		TituloInformação.setText("Navio");
		DescriçãoInformação.setText("Uma classe que representa navios");
	}
	
	public void descriçãoElemento(MouseEvent event) throws IOException{
		TituloInformação.setText("Elemento");
		DescriçãoInformação.setText("Uma classe que representa elementos como fogo e água");
	}
	
	public void descriçãoMonstro(MouseEvent event) throws IOException{
		TituloInformação.setText("Monstro");
		DescriçãoInformação.setText("Uma classe que representa monstros especificamente de jogos eletrônicos");
	}
	
	public void descriçãoMusica(MouseEvent event) throws IOException{
		TituloInformação.setText("Tako Player");
		DescriçãoInformação.setText("Um projeto de MP3 player que pode tocar audios");
	}
	
	public void descriçãoJogo(MouseEvent event) throws IOException{
		TituloInformação.setText("Jogo");
		DescriçãoInformação.setText("Uma classe que representa jogos");
	}
	
	public void descriçãoGato(MouseEvent event) throws IOException{
		TituloInformação.setText("Gato");
		DescriçãoInformação.setText("Uma classe que representa gatos");
	}
	
	public void descriçãoRaposa(MouseEvent event) throws IOException{
		TituloInformação.setText("Raposa");
		DescriçãoInformação.setText("Uma classe que representa raposas");
	}
	
	public void descriçãoMetal(MouseEvent event) throws IOException{
		TituloInformação.setText("Metais de Transição");
		DescriçãoInformação.setText("Uma classe que representa metais de transição baseados na tabela periódica");
	}
	
	public void descriçãoArte(MouseEvent event) throws IOException{
		TituloInformação.setText("Arte");
		DescriçãoInformação.setText("Uma classe que representa formas de arte");
	}
	
	public void descriçãoHeroi(MouseEvent event) throws IOException{
		TituloInformação.setText("Heroí");
		DescriçãoInformação.setText("Uma classe que representa heroís principalmente de jogos eletrônicos");
	}
	
	public void descriçãoMenu(MouseEvent event) throws IOException{
		TituloInformação.setText("Bem vindo");
		DescriçãoInformação.setText("Informações cruciais apareceram aqui");
	}
}
