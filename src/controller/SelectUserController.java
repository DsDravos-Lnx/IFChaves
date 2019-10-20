/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmprestimoDAO;
import dao.UsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Data;
import model.Emprestimo;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author joaqu
 */
public class SelectUserController implements Initializable {

    @FXML
    private TextField textFindUser;
      @FXML private TableView<Usuario> tableUser;
    @FXML private TableColumn<Usuario, Integer> idUser;
    @FXML private TableColumn<Usuario, String> idUserNome;
    @FXML private TableColumn<Usuario, String> idUserMat;
    @FXML private TableColumn<Usuario, String> idUserEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initTableUser();
         
         textFindUser.setOnKeyReleased((KeyEvent) -> {

            tableUser.setItems(setFindUser());
        });
        
    }    

    @FXML
    private void okUser(ActionEvent event) {
        
        if(!IfcechavesFX.IfcechavesFX.flagReserva){
            
             int id = tableUser.getSelectionModel().getSelectedItem().getId();
        String matricula = tableUser.getSelectionModel().getSelectedItem().getMatricula();
        String nome = tableUser.getSelectionModel().getSelectedItem().getNome();
        String email = tableUser.getSelectionModel().getSelectedItem().getEmail();

        Usuario user = new Usuario(id, nome, matricula, email);

        String dataEmprestimo = Data.getData();
        String[] s = dataEmprestimo.split(" ");
        String data = s[0];
        String hora = s[s.length - 1];

        Emprestimo ep = new Emprestimo();
        ep.setChave_id(IfcechavesFX.IfcechavesFX.chave.getId());
        ep.setUser_id(user.getId());
        ep.setChave_sala(IfcechavesFX.IfcechavesFX.chave.getSala());
        ep.setData(data);
        ep.setHora(hora);
        ep.setNome_user(user.getNome());
        ep.setStatus("Ativo");
        ep.setAdm(IfcechavesFX.IfcechavesFX.admLogado.getNome());
        ep.setData_devolu("/ / / ");
        ep.setHora_devolu(":");

        EmprestimoDAO.create(ep);

        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("IFCE-CHaves");
        dialogoInfo.setHeaderText("Emprestimo realizado com sucesso");
        Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("/imagens/icon.png"));

        dialogoInfo.showAndWait();
        EmprestimoDAO.updateChaveEmprestada(IfcechavesFX.IfcechavesFX.chave);
        IfcechavesFX.IfcechavesFX.chave = null;
            
            
        } else{
        
            int id = tableUser.getSelectionModel().getSelectedItem().getId();
            String matricula = tableUser.getSelectionModel().getSelectedItem().getMatricula();
            String nome = tableUser.getSelectionModel().getSelectedItem().getNome();
            String email = tableUser.getSelectionModel().getSelectedItem().getEmail();
            
             Usuario user = new Usuario(id, nome, matricula, email);
             
             IfcechavesFX.IfcechavesFX.userUpdt = user;
             
             IfcechavesFX.IfcechavesFX.changeScreen("reservar");
            
            
        }
       

//        String dataEmprestimo = Data.getData();
//        String[] s = dataEmprestimo.split(" ");
//        String data = s[0];
//        String hora = s[s.length - 1];

//        Emprestimo ep = new Emprestimo();
//        ep.setChave_id(IfcechavesFX.IfcechavesFX.chave.getId());
//        ep.setUser_id(user.getId());
//        ep.setChave_sala(IfcechavesFX.IfcechavesFX.chave.getSala());
//        ep.setData(data);
//        ep.setHora(hora);
//        ep.setNome_user(user.getNome());
//        ep.setStatus("Ativo");
//        ep.setAdm(IfcechavesFX.IfcechavesFX.admLogado.getNome());
//        ep.setData_devolu("/ / / ");
//        ep.setHora_devolu(":");
//
//        EmprestimoDAO.create(ep);
//
//        Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
//        dialogoInfo.setTitle("IFCE-CHaves");
//        dialogoInfo.setHeaderText("Emprestimo realizado com sucesso");
//        Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(new Image("/imagens/icon.png"));
//
//        dialogoInfo.showAndWait();
//        EmprestimoDAO.updateChaveEmprestada(IfcechavesFX.IfcechavesFX.chave);
//        IfcechavesFX.IfcechavesFX.chave = null;

    }

    @FXML
    private void cancelarUser(ActionEvent event) {
        
         IfcechavesFX.IfcechavesFX.chave = null;
         IfcechavesFX.IfcechavesFX.changeScreen("main");
    }
    
     private ObservableList<Usuario> userSearch = FXCollections.observableArrayList();
     
      //update user table
    public ObservableList<Usuario> actionUpdateUser() {
        userSearch = FXCollections.observableArrayList(UsuarioDAO.ListarUsers());
        return userSearch;
    }
    
      public ObservableList<Usuario> setFindUser() {

        ObservableList<Usuario> findUser = FXCollections.observableArrayList();

        for (int i = 0; i < userSearch.size(); i++) {

            if (userSearch.get(i).getNome().toLowerCase().contains(textFindUser.getText().toLowerCase())
                    || userSearch.get(i).getMatricula().toUpperCase().contains(textFindUser.getText().toLowerCase())
                        || userSearch.get(i).getEmail().toUpperCase().contains(textFindUser.getText().toLowerCase())){
                findUser.add(userSearch.get(i));
            }

        }

        return findUser;
    }
      
    
   //Inicia a tabela User
    public void initTableUser() {
        idUser.setCellValueFactory(new PropertyValueFactory("id"));
        idUserNome.setCellValueFactory(new PropertyValueFactory("nome"));
        idUserMat.setCellValueFactory(new PropertyValueFactory("matricula"));
        idUserEmail.setCellValueFactory(new PropertyValueFactory("email"));

        tableUser.setItems(actionUpdateUser());

    }
    
    
}
