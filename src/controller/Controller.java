package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;


public class Controller  {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private final JDBC DATABASE = new JDBC();



    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label loginMessage;

    public void switchToHomeLoginPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/homeLogin/HomeLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToDoctorLoginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/doctorLoginPage/DoctorLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPatientSymptomsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/patientSymptomsPage/PatientSymptomsPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToDoctorHomePage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/doctorHomePage/DoctorHomePage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void doctorLoginButtonOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        //Get data from FXML Textfield
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        //Creates the database and puts the information into the hashmap
        DATABASE.createDoctorLoginConnection();
        HashMap<String, String> loginInformation = DATABASE.getDoctorLogin();

        //Checks if the text field contains the right information
        if(loginInformation.containsKey(username) && loginInformation.get(username).equals(password)){
            switchToDoctorHomePage(event);
        }
        //Checks if the text field contains no information
        else if (usernameTextField.getText().isBlank() && passwordTextField.getText().isBlank()) {
            loginMessage.setText("Missing information!");
        }
        //Checks if the text field contains incorrect information
        else{
            loginMessage.setText("Incorrect username or password!");
        }
    }
}
