/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Usuario;
import dao.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class EditarUser implements Initializable {

    @FXML
    private AnchorPane idfundo;
    @FXML
    private TextField textNomeUser;
    @FXML
    private TextField textMatuser;
    @FXML
    private Label labelErro;
    @FXML
    private Label labelOK;
    @FXML
    private Text nomeUser;
    @FXML
    private Text matriculaUser;
    @FXML
    private Button voltarid;
    @FXML
    private Text idEmail;
    @FXML
    private TextField textEmailUser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (IfcechavesFX.IfcechavesFX.userUpdt != null) {

            textNomeUser.setText(IfcechavesFX.IfcechavesFX.userUpdt.getNome());
            textMatuser.setText(IfcechavesFX.IfcechavesFX.userUpdt.getMatricula());
            textEmailUser.setText(IfcechavesFX.IfcechavesFX.userUpdt.getEmail());

        }
    }

    @FXML
    private void buttonCancelarAction(ActionEvent event) {
        IfcechavesFX.IfcechavesFX.userUpdt = null;
        IfcechavesFX.IfcechavesFX.changeScreen("main");
    }

    @FXML
    private void buttonAtualizarAction(ActionEvent event) {
        
        try {
            Usuario user = new Usuario();
            user.setId(IfcechavesFX.IfcechavesFX.userUpdt.getId());
            user.setNome(textNomeUser.getText());
            user.setMatricula(textMatuser.getText());
            user.setEmail(textEmailUser.getText());

            UsuarioDAO.update(user);
            IfcechavesFX.IfcechavesFX.userUpdt = null;
            labelOK.setText("Usuário atualizado com sucesso.");

            textNomeUser.setText("");
            textMatuser.setText("");
            textEmailUser.setText("");

        } catch (IllegalArgumentException e) {

            labelErro.setText(e.getMessage());

        }

    }

    @FXML
    private void actionVoltar(ActionEvent event) {

        IfcechavesFX.IfcechavesFX.userUpdt = null;
        IfcechavesFX.IfcechavesFX.changeScreen("main");
    }

}
