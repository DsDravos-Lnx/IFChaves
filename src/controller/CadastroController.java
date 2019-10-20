package controller;

import dao.AdminstradorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Administrador;

public class CadastroController {

    @FXML
    private TextField textNome;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textUsuario;
    @FXML
    private TextField textSenha;
    @FXML
    private TextField textConfSenha;
    @FXML
    private Label idLabelAdmExist;
    @FXML
    private Label idLabelAdmSucess;

    @FXML
    void buttonCadastrarAction(ActionEvent event) {

        if (textNome.getText().equals("") || textEmail.getText().equalsIgnoreCase("")
                || textUsuario.getText().equals("") || (textSenha.getText().equals(""))
                || textConfSenha.getText().equals("")) {

            idLabelAdmExist.setText("Contém campos vazios");

        } else {

            Administrador adm = new Administrador();
            try {
                adm.setNome(textNome.getText());
                adm.setEmail(textEmail.getText());
                adm.setUsuario(textUsuario.getText());
                adm.setSenha(textSenha.getText());

                AdminstradorDAO daoAdm = new AdminstradorDAO();

                if (daoAdm.CheckUser(textUsuario.getText()) == 1) {
                    idLabelAdmExist.setText("*Esse Administrador já existe.");
                } else {
                    if (!textSenha.getText().equals(textConfSenha.getText())) {
                        idLabelAdmExist.setText("As senhas não são iguais");
                        textConfSenha.setText("");
                    } else {
                        daoAdm.create(adm);
                        idLabelAdmSucess.setText("Administrador cadastrado com sucesso.");

                    }
                }

            } catch (IllegalArgumentException e) {
                idLabelAdmExist.setText(e.getMessage());
            }

        }

    }
//        IfcechavesFX.IfcechavesFX.chave = null;

    @FXML
    void buttonCancelarAction(ActionEvent event) {
        IfcechavesFX.IfcechavesFX.changeScreen("login");
    }
}
