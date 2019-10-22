/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmprestimoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Emprestimo;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author smither
 */
public class LoanScreenController implements Initializable {

    private ObservableList<Emprestimo> loanSearch = FXCollections.observableArrayList();
    
    @FXML
    private TextField reportSearch;

    @FXML
    private TableView<Emprestimo> reportTable;

    @FXML
    private TableColumn<Emprestimo, String> reportUser;

    @FXML
    private TableColumn<Emprestimo, String> keyReport;

    @FXML
    private TableColumn<Emprestimo, String> dateReport;

    @FXML
    private TableColumn<Emprestimo, String> timeReport;

    @FXML
    private TableColumn<Emprestimo, String> dateDevReport;

    @FXML
    private TableColumn<Emprestimo, String> timeDevReport;

    @FXML
    private TableColumn<Emprestimo, String> adminReport;

    @FXML
    void actionButtonReturn(ActionEvent event) {
        IfcechavesFX.IfcechavesFX.changeScreen("main");
    }
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();

        reportSearch.setOnKeyReleased((KeyEvent) -> {
            reportTable.setItems(setFindReport());
        });
    }    
    public void initTable() {
        reportUser.setCellValueFactory(new PropertyValueFactory("nome_user"));
        keyReport.setCellValueFactory(new PropertyValueFactory("chave_sala"));
        dateReport.setCellValueFactory(new PropertyValueFactory("data"));
        timeReport.setCellValueFactory(new PropertyValueFactory("hora"));
        dateDevReport.setCellValueFactory(new PropertyValueFactory("data_devolu"));
        timeDevReport.setCellValueFactory(new PropertyValueFactory("hora_devolu"));
        adminReport.setCellValueFactory(new PropertyValueFactory("adm"));
        reportTable.setItems(actionUpdateTable());
    }
    
    public static ObservableList<Emprestimo> actionUpdateTable() {
        return FXCollections.observableArrayList(EmprestimoDAO.listarRelatorio());
    }
    
    public ObservableList<Emprestimo> setFindReport() {

        ObservableList<Emprestimo> findReport = FXCollections.observableArrayList();

        for (int i = 0; i < loanSearch.size(); i++) {

            if (loanSearch.get(i).getAdm().toLowerCase().contains(reportSearch.getText().toLowerCase())
                    || loanSearch.get(i).getNome_user().toUpperCase().contains(reportSearch.getText().toLowerCase())
                        || loanSearch.get(i).getChave_sala().toUpperCase().contains(reportSearch.getText().toLowerCase())){
                findReport.add(loanSearch.get(i));
            }

        }

        return findReport;
    }
    
}
