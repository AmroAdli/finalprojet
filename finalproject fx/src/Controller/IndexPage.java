/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.User;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class IndexPage implements Initializable {
           private Stage userScene;
           


    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override               
    public void initialize(URL url, ResourceBundle rb) {}
    

    @FXML
    private void btn_Admin(ActionEvent event) throws IOException {
        try {
            ViewManager.openAdminDashboard();
            ViewManager.closeIndexPage();
        } catch (IOException ex) {
            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(""));
            Parent root = loader.load();
            Scene updateuserscene = new Scene(root);

            userScene=new Stage();
            userScene.setScene(updateuserscene);
            userScene.show();
        }
    }

    @FXML
    private void btn_User(ActionEvent event) {
        try {
            ViewManager.openUserDashboard();
            ViewManager.closeIndexPage();
        } catch (IOException ex) {
            Logger.getLogger(IndexPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

