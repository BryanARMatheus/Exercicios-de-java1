package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

import static java.lang.Integer.parseInt;

public class ObjetosController extends MainController{

    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    String objetoInformacoes1;
    String objetoInformacoes2;
    String objetoInformacoes3;
    String nomeColuna1;
    String nomeColuna2;
    String nomeColuna3;

    @FXML
    TitledPane sqlObjetoNome = null;

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
    private TextField TextFieldInformacao1;

    @FXML
    private TextField TextFieldInformacao2;

    @FXML
    private TextField TextFieldInformacao3;


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
    void abrirTelaAdicionar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("AdicionarObjetoScreen.fxml")));
        root = loader.load();

        String nomeObjeto = AccordionObjetos.getExpandedPane().getText().toLowerCase();

        AdicionarObjetoController adicionarObjetoCtr = loader.getController();
        adicionarObjetoCtr.passarInformacoes(nomeObjeto, nomeColuna1, nomeColuna2, nomeColuna3, sqlObjetoNome);

        Stage adicionarstage = new Stage();
        Scene adicionarscene = new Scene(root);
        adicionarstage.setScene(adicionarscene);
        adicionarstage.setTitle("Adicionar objeto");
        adicionarstage.show();
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


                sqlObjetoNome = AccordionObjetos.getExpandedPane();

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                nomeColuna1 = resultSet.getMetaData().getColumnName(2);
                nomeColuna2 = resultSet.getMetaData().getColumnName(3);
                nomeColuna3 = resultSet.getMetaData().getColumnName(4);

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
    void deletarObjeto(ActionEvent event){
        try{
        connection = DatabaseConnection.getConnection(true);
        String nomeObjeto = AccordionObjetos.getExpandedPane().getText().toLowerCase();

        String queryDelete = "DELETE FROM " + nomeObjeto +
                " WHERE " + nomeColuna1 + " = ?"
                + " AND " + nomeColuna2 + " = ?"
                + " AND " + nomeColuna3 + " = ?;";

        PreparedStatement stmDelete = connection.prepareStatement(queryDelete);

        String queryMetadate = "SELECT * FROM " + nomeObjeto + " WHERE 1 = 0";
        Statement metaStmt = connection.createStatement();
        ResultSet rsMeta = metaStmt.executeQuery(queryMetadate);
        ResultSetMetaData metaData = rsMeta.getMetaData();

        configurarPreparedStatement(stmDelete, metaData, 1, objetoInformacoes1);
        configurarPreparedStatement(stmDelete, metaData, 2, objetoInformacoes2);
        configurarPreparedStatement(stmDelete, metaData, 3, objetoInformacoes3);

        stmDelete.executeUpdate();

        consultarObjetos(sqlObjetoNome);

        }catch(SQLException delEx){
            throw new RuntimeException(delEx);
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
    void modoDeEdicao(ActionEvent event) {

        if (TextFieldInformacao1 == null) {
            TextFieldInformacao1 = new TextField(objetoInformacoes1);
            TextFieldInformacao2 = new TextField(objetoInformacoes2);
            TextFieldInformacao3 = new TextField(objetoInformacoes3);
        }

        TextFieldInformacao1.setPrefWidth(LabelInformacao1.getWidth());
        TextFieldInformacao2.setPrefWidth(LabelInformacao2.getWidth());
        TextFieldInformacao3.setPrefWidth(LabelInformacao3.getWidth());

        addFocusListenerToTextField(TextFieldInformacao1);
        addFocusListenerToTextField(TextFieldInformacao2);
        addFocusListenerToTextField(TextFieldInformacao3);

        LabelInformacao1.setVisible(false);
        LabelInformacao2.setVisible(false);
        LabelInformacao3.setVisible(false);

        VBox parent = (VBox) LabelInformacao1.getParent();
        parent.getChildren().add(1, TextFieldInformacao1);
        parent.getChildren().add(2, TextFieldInformacao2);
        parent.getChildren().add(3, TextFieldInformacao3);

        ButtonModificar.setOnAction(eve -> salvarAlteracao(eve));
        ButtonModificar.setText("Salvar");

    }

    void salvarAlteracao(ActionEvent event){

        ButtonModificar.disableProperty().bind(TextFieldInformacao1.textProperty().isEmpty()
                .or(TextFieldInformacao2.textProperty().isEmpty())
                .or(TextFieldInformacao3.textProperty().isEmpty()));

        try {
            connection = DatabaseConnection.getConnection(true);
            String nomeObjeto = AccordionObjetos.getExpandedPane().getText().toLowerCase();

            String queryUpdate = "UPDATE " + nomeObjeto + " SET "
                    + nomeColuna1 + " = ?, "
                    + nomeColuna2 + " = ?, "
                    + nomeColuna3 + " = ? "
                    + "WHERE " + nomeColuna1 + " = ? AND "
                    + nomeColuna2 + " = ? AND "
                    + nomeColuna3 + " = ?";

            PreparedStatement stmUpdate = connection.prepareStatement(queryUpdate);

            stmUpdate.setString(1, TextFieldInformacao1.getText());
            stmUpdate.setString(2, TextFieldInformacao2.getText());
            stmUpdate.setString(3, TextFieldInformacao3.getText());

            stmUpdate.setString(4, objetoInformacoes1);
            stmUpdate.setString(5, objetoInformacoes2);
            stmUpdate.setString(6, objetoInformacoes3);

            stmUpdate.executeUpdate();

            objetoInformacoes1 = TextFieldInformacao1.getText();
            objetoInformacoes2 = TextFieldInformacao2.getText();
            objetoInformacoes3 = TextFieldInformacao3.getText();

            consultarObjetos(sqlObjetoNome);

        } catch(SQLException delEx){
            throw new RuntimeException(delEx);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException exe) {
                System.out.println("Erro ao fechar recursos: " + exe.getMessage());
            }
        }

        LabelInformacao1.setText(objetoInformacoes1);
        LabelInformacao2.setText(objetoInformacoes2);
        LabelInformacao3.setText(objetoInformacoes3);

        VBox parent = (VBox) TextFieldInformacao1.getParent();
        parent.getChildren().remove(TextFieldInformacao1);
        parent.getChildren().remove(TextFieldInformacao2);
        parent.getChildren().remove(TextFieldInformacao3);

        LabelInformacao1.setVisible(true);
        LabelInformacao2.setVisible(true);
        LabelInformacao3.setVisible(true);

        ButtonModificar.setOnAction(evento -> modoDeEdicao(event));
        ButtonModificar.setText("Modificar");

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
                    id = parseInt(nome.substring(nome.length() - 1));
                    break;

                case "elemento":
                    recordName = "id";
                    id = parseInt(nome.substring(nome.length() - 1));
                    break;

                case "heroi":
                    recordName = "id";
                    id = parseInt(nome.substring(nome.length() - 1));
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
                objetoInformacoes1 = rsBotao.getString(2);
                objetoInformacoes2 = rsBotao.getString(3);
                objetoInformacoes3 = rsBotao.getString(4);

                nomeColuna1 = rsBotao.getMetaData().getColumnName(2);
                nomeColuna2 = rsBotao.getMetaData().getColumnName(3);
                nomeColuna3 = rsBotao.getMetaData().getColumnName(4);

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

    void addFocusListenerToTextField(TextField textField) {
        textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) {
                String newValue = textField.getText();

                if (newValue.isEmpty()) {
                    textField.setText(textField.getPromptText());
                } else {
                    textField.setPromptText(newValue);
                }
            }
        });
    }

    void configurarPreparedStatement(PreparedStatement stm, ResultSetMetaData metaData, int paramIndex, String value) throws SQLException {
        int columnType = metaData.getColumnType(paramIndex + 1);

        switch (columnType) {
            case Types.INTEGER:
            case Types.SMALLINT:
            case Types.TINYINT:
            case Types.BIGINT:
                stm.setInt(paramIndex, Integer.parseInt(value));
                break;
            case Types.FLOAT:
            case Types.DOUBLE:
            case Types.DECIMAL:
                stm.setDouble(paramIndex, Double.parseDouble(value));
                break;
            case Types.VARCHAR:
            case Types.CHAR:
            case Types.LONGVARCHAR:
            case Types.NVARCHAR:
                stm.setString(paramIndex, value);
                break;
            case Types.BOOLEAN:
                stm.setBoolean(paramIndex, Boolean.parseBoolean(value));
                break;
            default:
                stm.setObject(paramIndex, value);
        }
    }
}
