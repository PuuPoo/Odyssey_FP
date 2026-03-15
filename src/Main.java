import javafx.application.Application;
import views.homeLogin.homeLoginPage;

public class Main{
    public static void main(String[] args){
        System.out.println("Initializing Application...");
        Application.launch(homeLoginPage.class, args);
    }
}