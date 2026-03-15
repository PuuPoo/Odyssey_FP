import javafx.application.Application;
import views.homeLoginPage;

public class Main{
    public static void main(String[] args){
        System.out.println("Initializing Application...");
        Application.launch(homeLoginPage.class, args);
    }
}