import javafx.application.Application;
import views.homeLogin.homeLoginPage;
import controller.JDBC;

import java.sql.SQLException;


public class Main{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Initializing Application...");
        JDBC jdbc = new JDBC();
        jdbc.createDoctorPatientConnectionBH();
        jdbc.createDoctorPatientConnectionLL();
        Application.launch(homeLoginPage.class, args);



    }
}