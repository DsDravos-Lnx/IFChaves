
package IfcechavesFX;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Chave;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.AnchorPane;
import model.Administrador;
import model.Usuario;

public class IfcechavesFX extends Application {

    private static Stage stage;
    private static Stage stageMain;
    private static Scene loginScene;
    private static Scene cadastroScene;
    private static Scene mainScene;
    private static Scene cadastroChave;
    private static Scene listarUsuarios;
    private static Scene cadUser;
    private static Scene editChave;
    private static Scene editUser;
    private static Scene listUser;
    private static Scene reserva;
    

    public static Chave chave;
    public static Chave chaveUpt;
    public static Usuario userUpdt;
    public static Administrador admLogado; 
    public static boolean flagReserva = true;
     
      

    @Override
    public void start(Stage stage) throws Exception {

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        loginScene = new Scene(fxmlLogin);
        
        Parent fxmlReserva = FXMLLoader.load(getClass().getResource("/view/reserva_data.fxml"));
        reserva = new Scene(fxmlReserva);
        
        Parent fxmlListUser = FXMLLoader.load(getClass().getResource("/view/usersList.fxml"));
        listUser = new Scene(fxmlListUser);
      
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("/view/cadastro.fxml"));
        cadastroScene = new Scene(fxmlCadastro);

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
        mainScene = new Scene(fxmlMain);

        Parent fxmlCadastroChave = FXMLLoader.load(getClass().getResource("/view/cadastroChaves.fxml"));
        cadastroChave = new Scene(fxmlCadastroChave);

        

        Parent fxmlUser = FXMLLoader.load(getClass().getResource("/view/cadastroUsuarios.fxml"));
        cadUser = new Scene(fxmlUser);
        
        Parent fxmlChave = FXMLLoader.load(getClass().getResource("/view/editChave.fxml"));
        editChave = new Scene(fxmlChave);
        
        Parent fxmlEditarUser = FXMLLoader.load(getClass().getResource("/view/editarUser.fxml"));
        editUser= new Scene(fxmlEditarUser);

        this.stage = stage;

        stage.setTitle("SISTEMA DE GERENCIAMENTO DE CHAVES IFCE-CEDRO");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/imagens/icon.png")));
        stage.setScene(loginScene);

        stage.show();

    }

    public static void updateScreen(String src) {
        FXMLLoader loader = new FXMLLoader();

    }

    public static void changeScreen(String src) {
        switch (src) {
            case "login": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/login.fxml"));
                    loginScene = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(loginScene);
            break;
            case "cadastro": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/cadastro.fxml"));
                    cadastroScene = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(cadastroScene);
            break;
            case "main": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/main.fxml"));
                    mainScene = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(mainScene);

            break;
            case "cadastroChave": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/cadastroChaves.fxml"));
                    cadastroChave = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(cadastroChave);
            break;
           

            case "cadUsuarios": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/cadastroUsuarios.fxml"));
                    cadUser = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(cadUser);
            break;
            
            
            case "editarChave": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/editChave.fxml"));
                    editChave = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(editChave);
            break;
            
            
             case "editarUser": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/editarUser.fxml"));
                    editUser = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(editUser);
            break;
            
            case "listarUser": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/usersList.fxml"));
                    listUser = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(listUser);
            break;
            
            
            case "reservar": {
                try {
                    FXMLLoader loader = new FXMLLoader();
                    AnchorPane a = (AnchorPane) loader.load(IfcechavesFX.class.getResource("/view/reserva_data.fxml"));
                    reserva = new Scene(a);

                } catch (IOException ex) {
                    Logger.getLogger(IfcechavesFX.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            stage.setScene(reserva);
            break;


        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
