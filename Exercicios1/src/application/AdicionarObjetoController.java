package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdicionarObjetoController extends ObjetosController implements Initializable{

    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    String nomeDaColuna1;
    String nomeDaColuna2;
    String nomeDaColuna3;

    String nomeDoObjetoAdicionar = null;

    @FXML
    private Button ButtonAdicionarObjeto;

    @FXML
    private Label LabelComNomeObjeto;

    @FXML
    private TextField TextFieldInformacao1;

    @FXML
    private TextField TextFieldInformacao2;

    @FXML
    private TextField TextFieldInformacao3;

    @FXML
    private TitledPane objetoAtualizado;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        addFocusListenerToTextField(TextFieldInformacao1);
        addFocusListenerToTextField(TextFieldInformacao2);
        addFocusListenerToTextField(TextFieldInformacao3);
    }


    public void passarInformacoes(String nomeObjeto, String nomeColuna1, String nomeColuna2, String nomeColuna3, TitledPane sqlObjetoNome){
        nomeDoObjetoAdicionar = nomeObjeto;
        LabelComNomeObjeto.setText("Adicionar" + nomeObjeto);
        TextFieldInformacao1.setPromptText(nomeColuna1);
        TextFieldInformacao2.setPromptText(nomeColuna2);
        TextFieldInformacao3.setPromptText(nomeColuna3);
        nomeDaColuna1 = nomeColuna1;
        nomeDaColuna2 = nomeColuna2;
        nomeDaColuna3 = nomeColuna3;
        objetoAtualizado = sqlObjetoNome;
    }


    @FXML
    void adicionarObjeto(ActionEvent event) {
        try{
            connection = DatabaseConnection.getConnection(true);
            String queryAdd = "INSERT INTO " + nomeDoObjetoAdicionar +
                    "(" + nomeDaColuna1 + ", "
                    + nomeDaColuna2 + ", "
                    + nomeDaColuna3 + ")"
                    + " VALUES (?,?,?);";

            PreparedStatement statementAdd = connection.prepareStatement(queryAdd);

            String queryMeta = "SELECT * FROM " + nomeDoObjetoAdicionar + " WHERE 1 = 0";
            Statement metaStmt = connection.createStatement();
            ResultSet rsMeta = metaStmt.executeQuery(queryMeta);
            ResultSetMetaData metaData = rsMeta.getMetaData();

            configurarPreparedStatement(statementAdd, metaData, 1, TextFieldInformacao1.getText());
            configurarPreparedStatement(statementAdd, metaData, 2, TextFieldInformacao2.getText());
            configurarPreparedStatement(statementAdd, metaData, 3, TextFieldInformacao3.getText());

            statementAdd.executeUpdate();

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
