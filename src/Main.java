import controller.JDBC;
import javafx.application.Application;
import views.homeLogin.homeLoginPage;

import java.sql.SQLException;

public class Main{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        JDBC jdbc = new JDBC();
        jdbc.createDoctorLoginConnection();
        System.out.print(jdbc.getDoctorLogin());

        System.out.println("Initializing Application...");
        Application.launch(homeLoginPage.class, args);



    }
}