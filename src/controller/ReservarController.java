/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Data;
import model.Reserva;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class ReservarController implements Initializable {

    @FXML
    private AnchorPane idfundo;
    @FXML
    private TextField textNomechave;
    @FXML
    private TextField textNomeUser;
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
    private TextField dataInicio;
    @FXML
    private DatePicker dataPicker;
    @FXML
    private Text idEmail1;

    /**
     * Initializes the controller class.
     */
        
        
        String dataEmprestimo = Data.getData();
        String[] s = dataEmprestimo.split(" ");
        String data = s[0];
        String hora = s[s.length - 1];
       
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      

        if (IfcechavesFX.IfcechavesFX.userUpdt != null || IfcechavesFX.IfcechavesFX.chave != null) {

            textNomeUser.setText(IfcechavesFX.IfcechavesFX.userUpdt.getNome());
            textNomechave.setText(IfcechavesFX.IfcechavesFX.chave.getSala());
            dataInicio.setText(data);
            

        }
    }    

    @FXML
    private void buttonCancelarAction(ActionEvent event) {
    }

    @FXML
    private void buttonAtualizarReservar(ActionEvent event) {
        
        LocalDate  devData = dataPicker.getValue();
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String data_reservada = formmat1.format(devData);

     
        Reserva res = new Reserva();
        res.setDia_inicio(dataInicio.getText());
        res.setHora_inicio(hora);
        res.setNome_user(textNomeUser.getText());
        res.setNome_admin(IfcechavesFX.IfcechavesFX.admLogado.getNome());
        res.setChave_sala(textNomechave.getText());
        res.setHora_encerra(hora);
        res.setDia_encerra(data_reservada);
        res.setChave_id(IfcechavesFX.IfcechavesFX.chave.getId());
        res.setUser_id(IfcechavesFX.IfcechavesFX.userUpdt.getId());
        res.setAdmin_id(IfcechavesFX.IfcechavesFX.admLogado.getId());
        
        System.out.println(res.toString());
        
        
        
    }

    @FXML
    private void actionVoltar(ActionEvent event) {
    }
    
}
