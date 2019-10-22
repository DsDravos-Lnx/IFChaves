package controller;

import dao.ChaveDAO;
import dao.EmprestimoDAO;
import dao.UsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Chave;
import model.Data;
import model.Emprestimo;
import model.Usuario;

public class MainController implements Initializable {

    private int key;
    private int id;
   
    private ObservableList<Chave> chaveSeach = FXCollections.observableArrayList();
    private ObservableList<Usuario> userSearch = FXCollections.observableArrayList();

    @FXML  private TableView<Chave> tableView;
    @FXML  private TableColumn<Chave, Integer> tableNumero;
    @FXML  private TableColumn<Chave, String> tableBloco;
    @FXML  private TableColumn<Chave, String> tableSala;
    @FXML  private TableColumn<Chave, String> tableStatus;
    @FXML  private TextField textPesquisa; 
    @FXML  private Button actionButtonReservar;
    @FXML  private Button actionButtonEmprestar;
    @FXML  private Button newUser;
    @FXML  private Button idBtnDev;
    @FXML  private Button idBtnVoltarAtua;
    @FXML  private Button idBtnSair;
    @FXML  private Button idEditarChave;
    //Tabela para listar os emprestimos
    @FXML  private TableView<Emprestimo> tableEmprestimo;
    @FXML  private TableColumn<Emprestimo, Integer> idEmp;
    @FXML  private TableColumn<Emprestimo, String> idCamEmpChave;
    @FXML  private TableColumn<Emprestimo, String> idCamEmpUser;
    @FXML  private TableColumn<Emprestimo, String> idCamEmpData;
    @FXML  private TableColumn<Emprestimo, String> idCamEmpHora;
    @FXML  private TableColumn<Emprestimo, String> idCamEmpStatus;
    @FXML  private TableColumn<Emprestimo, String> idCamAdm;
    //Set User Table
    @FXML private TableView<Usuario> tableUser;
    @FXML private TableColumn<Usuario, Integer> idUser;
    @FXML private TableColumn<Usuario, String> idUserNome;
    @FXML private TableColumn<Usuario, String> idUserMat;
    @FXML private TableColumn<Usuario, String> idUserEmail;
    @FXML private TextField textFindUser;
    

    
   
    @FXML void deleterUser(ActionEvent event){
        int numberUser = tableUser.getSelectionModel().getSelectedItem().getId();
        UsuarioDAO.delete(numberUser);
        initTableUser();
    };
    @FXML void updateUser(ActionEvent event){ 
        
            int iddUser = tableUser.getSelectionModel().getSelectedItem().getId(); 
            IfcechavesFX.IfcechavesFX.userUpdt = UsuarioDAO.returnUser(iddUser);
            IfcechavesFX.IfcechavesFX.changeScreen("editarUser");
    };

    @FXML
    void buttonActionLoan(ActionEvent event){
        IfcechavesFX.IfcechavesFX.changeScreen("loanScreen");
    }
    
    @FXML
    void actionButtonPesquisa(ActionEvent event) {

//        ChaveDAO key = new ChaveDAO();
//        int checkin = key.FindKey(textPesquisa.getText());
//        Chave chave = new Chave();
//        chave = ChaveDAO.ReturnKey(checkin);
//        System.out.println(chave.getSala());

    }

    @FXML
    void actionReservar(ActionEvent event) {
          if (tableView.getSelectionModel().isEmpty()) {
            
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("IFCE-CHaves");
            dialogoInfo.setHeaderText("Nenhuma chave selecionada");
            Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/imagens/icon.png"));

            dialogoInfo.showAndWait();

        } else {

            int id = tableView.getSelectionModel().getSelectedItem().getId();
            String sala = tableView.getSelectionModel().getSelectedItem().getSala();
            String status = tableView.getSelectionModel().getSelectedItem().getStatus();

            if ("Emprestada".equals(status)) {

                Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
                dialogoInfo.setTitle("IFCE-CHaves");
                dialogoInfo.setHeaderText("Essa chave já está emprestada");
                Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("/imagens/icon.png"));

                dialogoInfo.showAndWait();
                
            } else {

                IfcechavesFX.IfcechavesFX.chave = new Chave();
                IfcechavesFX.IfcechavesFX.chave.setId(id);
                IfcechavesFX.IfcechavesFX.chave.setSala(sala);
                IfcechavesFX.IfcechavesFX.chave.setStatus(status);
                //key = IfcechavesFX.IfcechavesFX.chave.getId();
                IfcechavesFX.IfcechavesFX.changeScreen("listarUser");
            }
        }

        
    }

    @FXML
    void actionButtonAdicionar(ActionEvent event) {
        IfcechavesFX.IfcechavesFX.changeScreen("cadastroChave");
    }

    @FXML
    void cadastrarUser(ActionEvent event) {
        IfcechavesFX.IfcechavesFX.changeScreen("cadUsuarios");
    }

    @FXML
    void actionButtonEmprestar(ActionEvent event) {
       
        if (tableView.getSelectionModel().isEmpty()) {
            
            Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
            dialogoInfo.setTitle("IFCE-CHaves");
            dialogoInfo.setHeaderText("Nenhuma chave selecionada");
            Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image("/imagens/icon.png"));

            dialogoInfo.showAndWait();

        } else {

            int id = tableView.getSelectionModel().getSelectedItem().getId();
            String bloco = tableView.getSelectionModel().getSelectedItem().getBloco();
            String sala = tableView.getSelectionModel().getSelectedItem().getSala();
            String status = tableView.getSelectionModel().getSelectedItem().getStatus();

            if ("Emprestada".equals(status)) {

                Alert dialogoInfo = new Alert(Alert.AlertType.WARNING);
                dialogoInfo.setTitle("IFCE-CHaves");
                dialogoInfo.setHeaderText("Essa chave já está emprestada");
                Stage stage = (Stage) dialogoInfo.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("/imagens/icon.png"));

                dialogoInfo.showAndWait();
                
            } else {

                IfcechavesFX.IfcechavesFX.chave = new Chave();
                IfcechavesFX.IfcechavesFX.chave.setId(id);
                IfcechavesFX.IfcechavesFX.chave.setBloco(bloco);
                IfcechavesFX.IfcechavesFX.chave.setSala(sala);
                IfcechavesFX.IfcechavesFX.chave.setStatus(status);
                key = IfcechavesFX.IfcechavesFX.chave.getId();
                IfcechavesFX.IfcechavesFX.changeScreen("listarUser");
            }
        }

    }

    @FXML
    void actionButtonExcluir(ActionEvent event) {

    }

    @FXML
    void btnDevolucao(ActionEvent event) {
        
        String dataEmprestimo = Data.getData();
        String[] s = dataEmprestimo.split(" ");
        String data = s[0];
        String hora = s[s.length - 1];
        
        id = tableEmprestimo.getSelectionModel().getSelectedItem().getId();
        Emprestimo emp;
        emp = EmprestimoDAO.findEmprestimos(id);
        emp.setStatus("Devolvido");
        emp.setData_devolu(data);
        emp.setHora_devolu(hora);
        EmprestimoDAO.updateEmprestimo(emp);
         iniciarTableEmprestimos();
        

    }

    @FXML
    void btnVoltarAtua(ActionEvent event) {

        IfcechavesFX.IfcechavesFX.admLogado = null;
        IfcechavesFX.IfcechavesFX.chave = null;
        IfcechavesFX.IfcechavesFX.changeScreen("main");

    }

    @FXML
    void actionButtonSair(ActionEvent event) {
        IfcechavesFX.IfcechavesFX.admLogado = null;
        IfcechavesFX.IfcechavesFX.changeScreen("login");
    }

    //função que chama as funções para iniciar as tabelas de chaves e emprestimos
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
        initTable();
        iniciarTableEmprestimos();
        initTableUser();
        
       String emp = EmprestimoDAO.dateEmprestimo();
       
        //pesquisando a partir do texto digitado.
        textPesquisa.setOnKeyReleased((KeyEvent) -> {

            tableView.setItems(buscarChave());
        });
        
        textFindUser.setOnKeyReleased((KeyEvent) -> {

            tableUser.setItems(setFindUser());
        });
    }

    //atualizar a tabela de chaves
    public ObservableList<Chave> actionAtualizar() {
        ChaveDAO dao = new ChaveDAO();
        chaveSeach = FXCollections.observableArrayList(dao.ListarChaves());
        return chaveSeach;
    }
    
    //update user table
    public ObservableList<Usuario> actionUpdateUser() {
        userSearch = FXCollections.observableArrayList(UsuarioDAO.ListarUsers());
        return userSearch;
    }
    
    //função para pesquisar chave;
    public ObservableList<Chave> buscarChave() {

        ObservableList<Chave> chaveDaBusca = FXCollections.observableArrayList();

        for (int i = 0; i < chaveSeach.size(); i++) {

            if (chaveSeach.get(i).getSala().toLowerCase().contains(textPesquisa.getText().toLowerCase())
                    || chaveSeach.get(i).getBloco().toUpperCase().contains(textPesquisa.getText().toLowerCase())) {
                chaveDaBusca.add(chaveSeach.get(i));
            }

        }

        return chaveDaBusca;
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
    
    //iniciar a tabela de chaves
    public void initTable() {
        tableNumero.setCellValueFactory(new PropertyValueFactory("id"));
        tableBloco.setCellValueFactory(new PropertyValueFactory("bloco"));
        tableSala.setCellValueFactory(new PropertyValueFactory("sala"));
        tableStatus.setCellValueFactory(new PropertyValueFactory("status"));

        tableView.setItems(actionAtualizar());

    }
    //Inicia a tabela User
    public void initTableUser() {
        idUser.setCellValueFactory(new PropertyValueFactory("id"));
        idUserNome.setCellValueFactory(new PropertyValueFactory("nome"));
        idUserMat.setCellValueFactory(new PropertyValueFactory("matricula"));
        idUserEmail.setCellValueFactory(new PropertyValueFactory("email"));

        tableUser.setItems(actionUpdateUser());

    }
    
    //inicia a tabela de emprestimos
    public void iniciarTableEmprestimos() {

        idEmp.setCellValueFactory(new PropertyValueFactory("id"));
        idCamEmpChave.setCellValueFactory(new PropertyValueFactory("chave_sala"));
        idCamEmpUser.setCellValueFactory(new PropertyValueFactory("nome_user"));
        idCamEmpData.setCellValueFactory(new PropertyValueFactory("data"));
        idCamEmpHora.setCellValueFactory(new PropertyValueFactory("hora"));
        idCamEmpStatus.setCellValueFactory(new PropertyValueFactory("status"));
        idCamAdm.setCellValueFactory(new PropertyValueFactory("adm"));

        tableEmprestimo.setItems(actionAtualizarEmprestimo());
    }

    //atualiza a tabela de emprestimos
    public static ObservableList<Emprestimo> actionAtualizarEmprestimo() {

        return FXCollections.observableArrayList(EmprestimoDAO.listarEmprestimos());
    }

    @FXML
    void btnEditarChaveAction(ActionEvent event) {

        int idd = tableView.getSelectionModel().getSelectedItem().getId();
        IfcechavesFX.IfcechavesFX.chaveUpt = ChaveDAO.ReturnKey(idd);
        //System.out.println(IfcechavesFX.IfcechavesFX.chaveUpt.getBloco());
        IfcechavesFX.IfcechavesFX.changeScreen("editarChave");

    }
    
}   

    