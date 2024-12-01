package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public void initialize() {
        LabelInformacao1.setStyle("-fx-text-fill: black;");
        LabelInformacao2.setStyle("-fx-text-fill: black;");
        LabelInformacao3.setStyle("-fx-text-fill: black;");
        LabelNome.setStyle("-fx-text-fill: black;");

        AccordionObjetos.expandedPaneProperty().addListener((obs, oldPane, newPane) -> {
            if (newPane != null) {
                try {
                    consultarObjetos(newPane);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        }

    @FXML
    void abrirTelaAdicionar(ActionEvent event) {

    }

    @FXML
    void consultarObjetos(TitledPane pane) throws SQLException {
        if (AccordionObjetos.getExpandedPane() != null) {
            try {
                VBox targetVBox = (VBox) pane.getContent();
                targetVBox.getChildren().clear();

                String nomeObjeto = AccordionObjetos.getExpandedPane().getText().toLowerCase();
                connection = DatabaseConnection.getConnection(true);
                String query = "SELECT * FROM " + nomeObjeto;

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {

                    String recordName = null;
                    String buttonName = null;

                    switch (nomeObjeto) {
                        case "arte":
                            recordName = resultSet.getString("id");
                            buttonName = "Arte " + recordName;
                            break;

                        case "elemento":
                            recordName = resultSet.getString("tipo");
                            buttonName = "Magia de " + recordName + " " + resultSet.getString("id");
                            break;

                        case "heroi":
                            recordName = resultSet.getString("id");
                            buttonName = "Heroi" + recordName;
                            break;

                        case "raposa":
                            recordName = resultSet.getString("raca");
                            buttonName = recordName;
                            break;

                        default:
                            recordName = resultSet.getString("nome");
                            buttonName = recordName;
                    }


                    Button button = new Button(buttonName);
                    button.setPrefWidth(600);
                    button.setStyle(String.format("-fx-font-size: 29;"));
                    button.setAlignment(Pos.CENTER_LEFT);
                    button.setOnAction(event -> mostrarObjeto(button));

                    targetVBox.setSpacing(10);
                    targetVBox.setStyle(String.format("-fx-background-color: black;"));

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
    void mostrarObjeto(Button button) {
        String nomeObjeto = AccordionObjetos.getExpandedPane().getText().toLowerCase();

        LabelNome.setText(button.getText());


        try {
            String recordName = null;
            connection = DatabaseConnection.getConnection(true);
            String nome = LabelNome.getText();
            int id = 0;

            switch (nomeObjeto) {
                case "arte":
                    recordName = "id";
                    id = Integer.parseInt(nome.substring(nome.length() - 1));
                    break;

                case "elemento":
                    recordName = "id";
                    id = Integer.parseInt(nome.substring(nome.length() - 1));
                    break;

                case "heroi":
                    recordName = "id";
                    id = Integer.parseInt(nome.substring(nome.length() - 1));
                    break;

                case "raposa":
                    recordName = "raca";
                    nome = LabelNome.getText();
                    break;

                default:
                    recordName = "nome";
            }

            String queryBotao = "SELECT * FROM " + nomeObjeto + " WHERE " + recordName + " = ?";

            PreparedStatement stmBotao = connection.prepareStatement(queryBotao);

            if (id != 0 ){
                stmBotao.setInt(1, id);
            } else{
                stmBotao.setString(1, nome);
            }

            ResultSet rsBotao = stmBotao.executeQuery();

            while(rsBotao.next()) {
                LabelInformacao1.setText(rsBotao.getMetaData().getColumnName(2).substring(0, 1).toUpperCase() + rsBotao.getMetaData().getColumnName(2).substring(1).toLowerCase() + ": " + rsBotao.getString(2));
                LabelInformacao2.setText(rsBotao.getMetaData().getColumnName(3).substring(0, 1).toUpperCase() + rsBotao.getMetaData().getColumnName(3).substring(1).toLowerCase() + ": " + rsBotao.getString(3));
                LabelInformacao3.setText(rsBotao.getMetaData().getColumnName(4).substring(0, 1).toUpperCase() + rsBotao.getMetaData().getColumnName(4).substring(1).toLowerCase() + ": " + rsBotao.getString(4));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException exe) {
                System.out.println("Erro ao fechar recursos: " + exe.getMessage());
            }
        }
    }

    @FXML
    void voltarMenu(ActionEvent event) {

    }


}
