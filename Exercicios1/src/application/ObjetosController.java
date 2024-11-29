package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

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
    public void consultarObjetos(MouseEvent event) throws SQLException {
        if (AccordionObjetos.getExpandedPane() != null) {
            try {
                TitledPane pane = (TitledPane) AccordionObjetos.getExpandedPane();
                VBox targetVBox = (VBox) pane.getContent();
                targetVBox.getChildren().clear();


                String query = null;
                String nomeObjeto = AccordionObjetos.getExpandedPane().getText().toLowerCase();
                connection = DatabaseConnection.getConnection(true);

                switch (nomeObjeto) {
                    case "arte":
                        query = "SELECT id FROM " + nomeObjeto;
                        break;

                    case "elemento":
                        query = "SELECT tipo,id FROM " + nomeObjeto;
                        break;

                    case "heroi":
                        query = "SELECT id FROM " + nomeObjeto;
                        break;

                    case "raposa":
                        query = "SELECT raca FROM " + nomeObjeto;
                        break;

                    default:
                        query = "SELECT nome FROM " + nomeObjeto;
                }

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {

                    String recordName = null;

                    switch (nomeObjeto) {
                        case "arte":
                            recordName = "Arte " + resultSet.getString("id");
                            break;

                        case "elemento":
                            recordName = "Magia de " + resultSet.getString("tipo") + "" + resultSet.getString("id");
                            break;

                        case "heroi":
                            recordName = "Heroi" + resultSet.getString("id");
                            break;

                        case "raposa":
                            recordName = resultSet.getString("raca");
                            break;

                        default:
                            recordName = resultSet.getString("nome");
                    }


                    Button button = new Button(recordName);
                    button.setPrefWidth(600);
                    button.setStyle(String.format("-fx-font-size: 29;"));
                    button.setAlignment(Pos.CENTER_LEFT);
                    targetVBox.setSpacing(10);

                    targetVBox.getChildren().add(button);
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


}
