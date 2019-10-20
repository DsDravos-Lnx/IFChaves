package controller;

import dao.AdminstradorDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Chave;


public class LoginController implements Initializable {
   
    private static Chave key;
    @FXML
    private TextField user;

    @FXML
    private PasswordField pass;
    
    @FXML
    private Label textLabel;
    
    

    @FXML
    void buttonLoginAction(ActionEvent event) {
        AdminstradorDAO adm = new AdminstradorDAO();
        int checkin = adm.CheckLogin(user.getText(), pass.getText());
        if (checkin == 1){
            IfcechavesFX.IfcechavesFX.changeScreen("main");
        }else{
            textLabel.setText("*Login ou senha incorretos");
        }
    }
    
    @FXML
    void buttonCadastroAction (ActionEvent event){
        IfcechavesFX.IfcechavesFX.changeScreen("cadastro");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private AdminstradorDAO AdminstradorDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
