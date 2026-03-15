package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class homeLoginPage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Note the capital 'P' in BorderPane
        Parent root = FXMLLoader.load(getClass().getResource("/views/HomeLoginPage.fxml"));

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
