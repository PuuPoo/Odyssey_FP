package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
//----------------------------------------------------------------------------------------------------------------

public class Controller  {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private final JDBC DATABASE = new JDBC();


    //Controller for the login information
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Label loginMessage;
    @FXML
    private Label doctorName;



    //Controller for the patient table in doctor home page
    @FXML
    private TableView<Appointment> patientTable;
    @FXML
    private TableColumn<Appointment, Integer> patientNo;
    @FXML
    private TableColumn<Appointment, String> patientName;
    @FXML
    private TableColumn<Appointment, Byte> patientAge;
    @FXML
    private TableColumn<Appointment, String> patientSickness;
    @FXML
    private TableColumn<Appointment, String> patientContact;
    @FXML
    private TableColumn<Appointment, Integer> patientSeverity;
    @FXML
    private TableColumn<Appointment, Void> patientAction;

    private ObservableList<Appointment> observablePatientList = FXCollections.observableArrayList();



//----------------------------------------------------------------------------------------------------------------




    //Switches to the home login page scene
    public void switchToHomeLoginPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/homeLogin/HomeLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //----------------------------------------------------------------------------------------------------------------


    //Switches to the doctor login page scene
    public void switchToDoctorLoginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/doctorLoginPage/DoctorLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //----------------------------------------------------------------------------------------------------------------



    //Switches to the patient symptoms page scene
    public void switchToPatientSymptomsPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/patientSymptomsPage/PatientSymptomsPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //----------------------------------------------------------------------------------------------------------------


    //Switches to the doctor home page scene
    public void switchToDoctorHomePage(ActionEvent event, String doctorUsername, String gmail) throws IOException, SQLException, ClassNotFoundException {
        //loader to know the controller for the set label
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/doctorHomePage/DoctorHomePage.fxml"));

        //reads the FXML file
        Parent root = loader.load();

        //a controller space to hold the new controller instance
        Controller nextController = loader.getController();

        //sets the label
        nextController.doctorName.setText(doctorUsername);

        //Checks if the controller is fully loaded
        if (nextController.patientAction != null) {
            nextController.patientTableInitializeLL(gmail); //Depending on which data structure to load into patients table
            //nextController.patientTableInitializeBH(gmail);
        }

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //----------------------------------------------------------------------------------------------------------------



    public void doctorLoginButtonOnAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        //Get data from FXML Textfield
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        //Creates the database and puts the information into the hashmap
        //Gmail and Password connection
        DATABASE.createDoctorLoginConnection();
        HashMap<String, String> loginInformation = DATABASE.getDoctorLogin();
        //Gmail and Username connection
        DATABASE.createDoctorUsernameConnection();
        HashMap<String, String> usernameInformation = DATABASE.getDoctorUsername();


        //Checks if the text field contains the right information
        if(loginInformation.containsKey(username) && loginInformation.get(username).equals(password)){

            //Loading the FXML of doctor information to display its information
            String doctorUsername = getDoctorInformation(username, usernameInformation);

            //switching to the doctor home page
            switchToDoctorHomePage(event, doctorUsername, username);

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



    public String getDoctorInformation(String doctorGmail, HashMap<String, String> usernameInformation) {
        return usernameInformation.getOrDefault(doctorGmail, "NULL ERROR");
    }


    //----------------------------------------------------------------------------------------------------------------





    //Patient Table Information Data Initializer for LinkedList
    public void patientTableInitializeLL(String gmail) throws SQLException, ClassNotFoundException{
        //Creates the connection and the LinkedList Data
        DATABASE.createDoctorPatientConnectionLL();

        //Clears existing value in the UI
        observablePatientList.clear();

        LinkedList patientInformation = DATABASE.getPatientListLL();
        LinkedList.Node current = patientInformation.head;

        while(current != null){
            if (Objects.equals(current.gmail, gmail)) {
                Appointment appointment = new Appointment(current.gmail, current.patientName, current.patientAge, current.patientSickness, current.patientContact, current.patientSeverity);

                observablePatientList.add(appointment);
            }
            current = current.next;
        }




        //Maps the Columns ID in scenebuilder to the Appointment class value
        patientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientAge.setCellValueFactory(new PropertyValueFactory<>("patientAge"));
        patientSickness.setCellValueFactory(new PropertyValueFactory<>("patientSickness"));
        patientContact.setCellValueFactory(new PropertyValueFactory<>("patientContact"));
        patientSeverity.setCellValueFactory(new PropertyValueFactory<>("patientSeverity"));

        //Setting the patient number column
        //Tells the cell factory to utilize a new method to draw on the cell instead of default
        patientNo.setCellFactory(column -> new TableCell<Appointment, Integer>() {
            //Overrides the JavaFX method with a new method below
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                //checks is the cell is empty
                if (empty) {
                    setText(null);
                }
                else {
                    // getIndex() gives the current row index (starting at 0)
                    setText(String.valueOf(getIndex() + 1));
                }
            }
        });

        //Patient Action column
        patientAction.setCellFactory(column -> new TableCell<Appointment, Void>() {
                    //Overrides the JavaFX method with a new method below
                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        //Checks if the cell is empty
                        if(empty){
                            setGraphic(null);
                        }
                        else{
                            //Creates a button for removal
                            Button remove = new Button("Remove");
                            remove.getStyleClass().add("remove-button"); //style class for the button
                            setGraphic(remove);
                            //when the button is pressed
                            remove.setOnAction(event ->{
                                Appointment dataRemove = getTableRow().getItem(); //Gets the data
                                if(dataRemove != null){ //if it's not null it removes the data from the display list
                                    observablePatientList.remove(dataRemove);
                                }
                            });

                        }
                    }
                });


        //Adds the data into the table
        patientTable.setItems(observablePatientList);
    }


    //----------------------------------------------------------------------------------------------------------------

    //Patient Table Information Data Initializer for Binary Heap
    public void patientTableInitializeBH(String gmail) throws SQLException, ClassNotFoundException{
        //Creates the connection and the LinkedList Data
        DATABASE.createDoctorPatientConnectionBH();

        //Clears existing value in the UI
        observablePatientList.clear();

        BinaryHeap patientInformation = DATABASE.getPatientListBH();

        Appointment data = patientInformation.poll();

        while(data != null){
            if (data.getGmail().equals(gmail)) {
                observablePatientList.add(data);
            }
            data = patientInformation.poll();
        }


        //Maps the Columns ID in scenebuilder to the Appointment class value
        patientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        patientAge.setCellValueFactory(new PropertyValueFactory<>("patientAge"));
        patientSickness.setCellValueFactory(new PropertyValueFactory<>("patientSickness"));
        patientContact.setCellValueFactory(new PropertyValueFactory<>("patientContact"));
        patientSeverity.setCellValueFactory(new PropertyValueFactory<>("patientSeverity"));

        //Setting the patient number column
        //Tells the cell factory to utilize a new method to draw on the cell instead of default
        patientNo.setCellFactory(column -> new TableCell<Appointment, Integer>() {
            //Overrides the JavaFX method with a new method below
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                } else {
                    // getIndex() gives the current row index (starting at 0)
                    setText(String.valueOf(getIndex() + 1));
                }
            }
        });



        //Patient Action column
        patientAction.setCellFactory(column -> new TableCell<Appointment, Void>() {
            //Overrides the JavaFX method with a new method below
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                //Checks if the cell is empty
                if(empty){
                    setGraphic(null);
                }
                else{
                    //Creates a button for removal
                    Button remove = new Button("Remove");
                    remove.getStyleClass().add("remove-button"); //style class for the button
                    setGraphic(remove);
                    //when the button is pressed
                    remove.setOnAction(event ->{
                        Appointment dataRemove = getTableRow().getItem(); //Gets the data
                        if(dataRemove != null){ //if it's not null it removes the data from the display list
                            observablePatientList.remove(dataRemove);
                        }
                    });

                }
            }
        });


        //Adds the data into the table
        patientTable.setItems(observablePatientList);
    }
}

