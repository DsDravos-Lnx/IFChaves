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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Chave;
import dao.ChaveDAO;
import javafx.scene.control.Button;
/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class EditarChave implements Initializable {

    @FXML
    private Button voltarid;
    @FXML
    private AnchorPane idfundo;
    @FXML
    private TextField idSala;
    @FXML
    private TextField idBloco;
    @FXML
    private Label labelErro;
    @FXML
    private Label labelOK;
    
   
   
    /**
     * Initializes the controller class.
    
     */
    
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      if(IfcechavesFX.IfcechavesFX.chaveUpt != null){
        
        idSala.setText(IfcechavesFX.IfcechavesFX.chaveUpt.getSala());
        idBloco.setText(IfcechavesFX.IfcechavesFX.chaveUpt.getBloco());
        System.out.println(IfcechavesFX.IfcechavesFX.chaveUpt.getId());
        System.out.println(IfcechavesFX.IfcechavesFX.chaveUpt.getStatus());
        
      }
       
    }    
   
    
   
    @FXML
    private void buttonCancelarAction(ActionEvent event) {
        
        
         IfcechavesFX.IfcechavesFX.chaveUpt = null;
         IfcechavesFX.IfcechavesFX.changeScreen("main");
        
         
    }
    
    @FXML
    void actionVoltar(ActionEvent event) {
        
         IfcechavesFX.IfcechavesFX.chaveUpt = null;
         IfcechavesFX.IfcechavesFX.changeScreen("main");
    }

    @FXML
    private void buttonAtualizarAction(ActionEvent event) {
        
        Chave chaveAtualizada = new Chave();
        chaveAtualizada.setId(IfcechavesFX.IfcechavesFX.chaveUpt.getId());
        chaveAtualizada.setSala(idSala.getText());
        chaveAtualizada.setBloco(idBloco.getText());
        chaveAtualizada.setStatus(IfcechavesFX.IfcechavesFX.chaveUpt.getStatus());
        
        dao.ChaveDAO.update(chaveAtualizada);
        
        IfcechavesFX.IfcechavesFX.chaveUpt = null;
        labelOK.setText("Chave atualizada com sucesso");
        
        
        
        
    }
    
}
