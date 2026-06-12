import javafx.application.Application;
import views.homeLogin.homeLoginPage;
import controller.JDBC;

import java.sql.SQLException;


public class Main{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Initializing Application...");
        Application.launch(homeLoginPage.class, args);



    }
}