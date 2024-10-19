package application;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Musica extends Controller implements Initializable{
	
	private String nome;
	private int tamanho;
	private String artista;
	
	@FXML
	private Pane menu;
	@FXML
	private Text musicaNome;
	@FXML
	private ImageView ImagemInformação;
	@FXML
	private Button botãoPlay, botãoPause, botãoReiniciar, botãoAvançar, botãoVoltar;
	@FXML
	private Slider ajustarVolume;
	@FXML
	private ProgressBar tempoMusica;
	
	private Media media;
	private MediaPlayer mediaPlayer;
	
	private File diretorio;
	private File[] arquivos;
	
	private ArrayList<File> musicas;
	
	private int numeroMusica;
	
	private Timer timer;
	private TimerTask tarefa;
	private boolean tocando;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		musicas = new ArrayList<File>();
		
		diretorio = new File("musica");
		
		arquivos = diretorio.listFiles();
		
		if (arquivos != null) {
			
			for(File arquivo: arquivos) {
				musicas.add(arquivo);
			}
		}
		
		media = new Media(musicas.get(numeroMusica).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		
		musicaNome.setText(musicas.get(numeroMusica).getName());
		
		ajustarVolume.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				
				mediaPlayer.setVolume(ajustarVolume.getValue() * 0.01);
				
			}
			
		});
	}
	
	//Place holder
	public void tocar() {
		
		tempoMusica();
		mediaPlayer.setVolume(ajustarVolume.getValue() * 0.01);
		mediaPlayer.play();
		
	}
	
	public void pausar() {
		
		pararTempoMusica();
		mediaPlayer.pause();
		
	}
	
	public void reiniciar() {
		tempoMusica.setProgress(0);
		mediaPlayer.seek(Duration.seconds(0));
	}
	
	public void proximaMusica() {
		if (numeroMusica < musicas.size() - 1) {
			
			numeroMusica++;
			
			mediaPlayer.stop();
			
			if (tocando) {
				pararTempoMusica();
			}
			
			media = new Media(musicas.get(numeroMusica).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			musicaNome.setText(musicas.get(numeroMusica).getName());
		}else {

			numeroMusica = 0;
			
			mediaPlayer.stop();
			
			if (tocando) {
				pararTempoMusica();
			}
			
			media = new Media(musicas.get(numeroMusica).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			musicaNome.setText(musicas.get(numeroMusica).getName());
		}
		tocar();
	}
	
	public void musicaAnterior() {
		if (numeroMusica < musicas.size() && numeroMusica != 0) {
			
			numeroMusica--;
			
			mediaPlayer.stop();
			
			if (tocando) {
				pararTempoMusica();
			}
			
			media = new Media(musicas.get(numeroMusica).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			musicaNome.setText(musicas.get(numeroMusica).getName());
		}else {

			numeroMusica = musicas.size() - 1;
			
			mediaPlayer.stop();
			
			if (tocando) {
				pararTempoMusica();
			}
			
			media = new Media(musicas.get(numeroMusica).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			
			musicaNome.setText(musicas.get(numeroMusica).getName());
		}
		tocar();
	}
	
	public void tempoMusica() {
		
		timer = new Timer();
		
		tarefa = new TimerTask() {
			
			public void run() {
				
				tocando = true;
				double tempoAtual = mediaPlayer.getCurrentTime().toSeconds();
				double tempoFinal = media.getDuration().toSeconds();
				tempoMusica.setProgress(tempoAtual/tempoFinal);
				
				if(tempoAtual/tempoFinal == 1) {
					
					pararTempoMusica();
					
				}
			}
		};
		
		timer.scheduleAtFixedRate(tarefa, 0, 1000);
	}
	
	public void pararTempoMusica() {
		
		tocando = false;
		timer.cancel();
	}
	
	@Override
	public void voltarMenu(ActionEvent event) throws IOException{
		
		if(this.timer != null) {
			pausar();
			reiniciar();
		}
		
		root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Pagina de Menu");
		stage.show();
		scene.getStylesheets().add(css);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
}
