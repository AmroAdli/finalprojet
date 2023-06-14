/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import Model.DBConnection;
import View.ViewManager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class CreatUser implements Initializable {

    @FXML
    private TextField Text_First_Name;
    @FXML
    private TextField Text_Email;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private ToggleGroup roleGroup;
    @FXML
    private TextField Text_Last_Name;
    @FXML
    private TextField Text_Phone;
    @FXML
    private TextField Text_Password;
    @FXML
    private RadioButton male;
    @FXML
    private RadioButton femal;
    @FXML
    private RadioButton admin;
    @FXML
    private RadioButton user;
    @FXML
    private TextField Text_age;

    DBConnection db = DBConnection.getInstanse();

    static int index;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void btn_Save(ActionEvent event) throws SQLException {
        String First_Name = Text_First_Name.getText();
        String last_Name = Text_Last_Name.getText();
        String email = Text_Email.getText();
        String Phone = Text_Phone.getText();
        String Password = Text_Password.getText();
        String age = Text_age.getText();
        String genderGroup = " ";
        if (male.isSelected()) {
            genderGroup = male.getText();
        } else {
            genderGroup = femal.getText();
        }
        String RoleGroup = " ";
        if (admin.isSelected()) {
            RoleGroup = admin.getText();
        } else {
            RoleGroup = user.getText();
        }
        String sql = "INSERT INTO `user` (`id`, `first_Name`, `last_Name`, `password`, `email`, `phone`, `age`, `gender`, `role`)"
                + "  VALUES (" + null + ",'" + First_Name + "','" + last_Name + "'," + Password + ",'" + email + "','"
                + Phone + "'," + age + ",'" + genderGroup + "','"
                + RoleGroup + "')";
        DBConnection.statement.executeUpdate(sql);
        Text_First_Name.setText("");
        Text_Last_Name.setText("");
        Text_Email.setText("");
        Text_Phone.setText("");
        Text_Password.setText("");
        Text_age.setText("");
        ViewManager.UserDashboard.SceneMainUser();
    }

    @FXML
    private void btn_Cansol(ActionEvent event) {
        ViewManager.UserDashboard.SceneMainUser();
    }

}
