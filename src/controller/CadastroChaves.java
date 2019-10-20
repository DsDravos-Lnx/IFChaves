/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ChaveDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Chave;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class CadastroChaves implements Initializable {

    @FXML
    private AnchorPane idfundo;
    @FXML
    private TextField  idSala;
    @FXML
    private TextField  idBloco;
    @FXML
    private Label labelErro;
    @FXML
    private Label labelOK;
    
    @FXML
    private Button btnVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonCancelarAction(ActionEvent event) { 
        
            IfcechavesFX.IfcechavesFX.changeScreen("main");
    }

    @FXML
    private void buttonCadastrarAction(ActionEvent event) { 
         
        try {
             Chave chave = new Chave(idSala.getText(), idBloco.getText(),"Disponivel");
             ChaveDAO.create(chave);
             labelOK.setText("Chave cadastrada com sucesso");
             
            
      
        } catch (IllegalArgumentException e) {
            labelErro.setText(e.getMessage());
            System.out.println(e.getMessage());
        }
       
        
        
        //ChaveDAO.create(chave);
        
        
    }
    
     @FXML
    void buttonActionVoltar(ActionEvent event) {
        
        IfcechavesFX.IfcechavesFX.changeScreen("main");

    }

    
}
