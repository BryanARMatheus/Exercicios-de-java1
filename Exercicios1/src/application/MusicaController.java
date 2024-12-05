package application;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.MapChangeListener;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;

public class MusicaController extends MainController implements Initializable{
	
	private String nome;
	private int tamanho;
	private String artista;

	int i = 0;
	int numeroDaMusica;

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
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
	@FXML
	private ImageView ImageViewMusicaThumb;
	@FXML
	private VBox VBoxListaMusicas;
	
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
		
		diretorio = new File("C:\\Users\\Noite\\Desktop\\biewqji\\Exercicios-de-java1\\Exercicios1\\src\\Musica");
		
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
		try {
			atualizarCapaMusica();
			adicionarMusicasBanco();
			criarBotao(VBoxListaMusicas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		};
	}

	public void atualizarCapaMusica() {

		media.getMetadata().addListener((MapChangeListener<? super String, ? super Object>) (change) -> {
			if (media.getMetadata().containsKey("image")) {

				Image capa = (Image) media.getMetadata().get("image");

				ImageViewMusicaThumb.setImage(capa);
			}
		});
	}

	@FXML
	void adicionarMusicasBanco(){
		for(File arquivo: arquivos) {
			try {
				connection = DatabaseConnection.getConnection(true);
				String query = "INSERT INTO musica (nome,segundos,artista,numero_musica,caminho_musica) VALUES (?,?,?,?,?);";

				Media media = new Media(arquivo.toURI().toString());
				MediaPlayer tempMediaPlayer = new MediaPlayer(media);

				PreparedStatement stmInsert = connection.prepareStatement(query);

					String nomeMusica = musicas.get(numeroMusica + i).getName();
					double duracao = tempMediaPlayer.getTotalDuration().toSeconds();
					int duracaoSegundos = Integer.parseInt(String.valueOf(Math.round(duracao)));


					String artista = null;
					String thumbnailPath = null;

					if (media.getMetadata().containsKey("album")) {
						artista = (String) media.getMetadata().get("album");
					}

					if (media.getMetadata().containsKey("image")) {
						Image thumbnailImage = (Image) media.getMetadata().get("image");
					}

					String caminhoMusica = musicas.get(numeroMusica).getAbsolutePath();


					stmInsert.setString(1, nomeMusica);
					stmInsert.setInt(2, duracaoSegundos);
					stmInsert.setString(3, artista);
					stmInsert.setInt(4, numeroMusica);
					stmInsert.setString(5, caminhoMusica);

					stmInsert.executeUpdate();

					i++;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (resultSet != null) resultSet.close();
					if (statement != null) statement.close();
					if (connection != null) connection.close();
				} catch (SQLException e) {
					System.out.println("Erro ao fechar recursos: " + e.getMessage());
				}
			}
		}
	}

	@FXML
	void criarBotao(VBox VBoxListaMusicas) throws SQLException {
			try {
				VBoxListaMusicas.getChildren().clear();

				connection = DatabaseConnection.getConnection(true);
				String query = "SELECT * FROM musica;";


				PreparedStatement stmCriar = connection.prepareStatement(query);

				ResultSet resultSet = stmCriar.executeQuery(query);

				while (resultSet.next()) {

					String buttonName = null;
					String musicName = null;

					buttonName = resultSet.getString("nome");
					musicName = buttonName;

					Button button = new Button(buttonName);
					button.setPrefWidth(600);
					button.setStyle(String.format("-fx-font-size: 22;"));
					button.setAlignment(Pos.CENTER_LEFT);
					button.setOnAction(event -> tocarBotao(button));

					VBoxListaMusicas.setSpacing(10);
					VBoxListaMusicas.setStyle(String.format("-fx-background-color: black;"));

					VBoxListaMusicas.getChildren().add(button);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					if (resultSet != null) resultSet.close();
					if (statement != null) statement.close();
					if (connection != null) connection.close();
				} catch (SQLException e) {
					System.out.println("Erro ao fechar recursos: " + e.getMessage());
				}
			}

	}

	void tocarBotao(Button button){
		String nomeMusicaBotao = button.getText();

		try {

			connection = DatabaseConnection.getConnection(true);
			String query = "SELECT * FROM musica WHERE nome = '" + nomeMusicaBotao + "';";

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			resultSet.next();
			numeroDaMusica = resultSet.getInt("numero_musica");
			media = new Media(musicas.get(numeroDaMusica).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			tocar();
			atualizarCapaMusica();

			musicaNome.setText(nomeMusicaBotao);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e) {
				System.out.println("Erro ao fechar recursos: " + e.getMessage());
			}
		}
	}
	
	//Place holder
	public void tocar() {
		
		tempoMusica();
		mediaPlayer.setVolume(ajustarVolume.getValue() * 0.01);
		mediaPlayer.play();

		atualizarCapaMusica();
		
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
		atualizarCapaMusica();

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
		atualizarCapaMusica();

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
