
package controller;

import dao.UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class CadastroUserController {

    @FXML
    private AnchorPane idfundo;

    @FXML
    private TextField textNome;

    @FXML
    private TextField textMatricula;

    @FXML
    private TextField textEmail;
    
    @FXML
    private Label labelErro;
     
    @FXML
    private Label labelOK;

    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    

    @FXML
    private void buttonCancelarAction(ActionEvent event) {
        
         IfcechavesFX.IfcechavesFX.changeScreen("main");
    }

    @FXML
    private void buttonCadastrarAction(ActionEvent event) { 
        
       try {
             Usuario user = new Usuario();
             user.setNome(textNome.getText());
             user.setMatricula(textMatricula.getText());
             user.setEmail(textEmail.getText());
             
             UsuarioDAO.create(user);
             
             labelOK.setText("Cadastrado com sucesso");
             textNome.setText("");
             textMatricula.setText("");
             textEmail.setText("");
             
            

        } catch (IllegalArgumentException e) {
            
            labelErro.setText(e.getMessage());
            System.out.println(e.getMessage());
        }
       
       
    }
    
}
