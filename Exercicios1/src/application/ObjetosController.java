package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import application.DatabaseConnection;
import java.sql.*;

public class ObjetosController {

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    @FXML
    private Accordion AccordionObjetos;

    @FXML
    private Button ButtonAdicionar;

    @FXML
    private Button ButtonDeletar;

    @FXML
    private Button ButtonModificar;

    @FXML
    private Button ButtonVoltar;

    @FXML
    private Label LabelInformacao1;

    @FXML
    private Label LabelInformacao2;

    @FXML
    private Label LabelInformacao3;

    @FXML
    private Label LabelNome;

    @FXML
    void abrirTelaAdicionar(ActionEvent event) {

    }

    @FXML
    void consultarObjetos(MouseEvent event) throws SQLException {
        try {
            String nomeObjeto = AccordionObjetos.getExpandedPane().getText();
            connection = DatabaseConnection.getConnection(true);
            String query = "SELECT nome FROM " + nomeObjeto;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String recordName = resultSet.getString("nome");

                Button button = new Button(recordName);

                //AccordionObjetos.getExpandedPane().;
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

    @FXML
    void deletarObjeto(ActionEvent event) {

    }

    @FXML
    void modificarObjeto(ActionEvent event) {

    }

    @FXML
    void voltarMenu(ActionEvent event) {

    }

    //@FXML
    /*private void fillDatabase() {
        LoginDAO loginDAO = new LoginDAO();
        try {
            loginDAO.executeSQLFromFile("/assets/sql/schema.sql");
            Utils.setAlert("CONFIRMATION", "Preenchimento do banco", "Tabelas criadas com sucesso!");
        } catch (Exception e) {
            Utils.setAlert("ERROR", "Preenchimento do banco", "Erro ao criar as tabelas: " + e.getMessage());
        }
        try {
            loginDAO.executeSQLFromFile("/assets/sql/dump.sql");
            Utils.setAlert("CONFIRMATION", "Preenchimento do banco", "As tabelas foram populadas com sucesso!");
        } catch (Exception e) {
            Utils.setAlert("ERROR", "Preenchimento do banco", "Erro ao popular as tabelas: " + e.getMessage());
        }
    }*/

	/*static Navio navio1 = new Navio("Bismarck","Couraçado", 1939);
	//static Navio navio2 = new Navio("Deutschland", "Cruzador pesado", 1931);
	
	static Elemento elemento1 = new Elemento("Fogo", 3, "Ofensivo");
	
	static Monstro monstro1 = new Monstro("Argoradon", "Dragão", 86);
	
	static Musica musica1 = new Musica("HUG AND KILL.wav", 218, "Kobaryo - ");
	static Musica musica2 = new Musica("_1NF3S__0N_.wav", 293, "DM DOKURO - ");
	static Musica musica3 = new Musica("Sledge.wav", 205, "Dance with the Dead - ");
	
	static Jogo jogo1 = new Jogo("Rain world", "Aventura", "Distópico");
	
	static Gato gato1 = new Gato("Maine Coon", "Estrôncio", 5);
	static Gato gato2 = new Gato("Angorá Turco", "Ytterbium", 11);
	
	static Raposa raposa1 = new Raposa("Raposa do ártico", "Tundras árticas", "Branca");
	
	static MetalTransição metal1 = new MetalTransição("ósmio", 76, 22.59F);
	
	static Arte arte1 = new Arte("tradicional", "manga", "Pincel");
	
	static Heroi heroi1 = new Heroi(30, 96, 360);
	*/
}
