package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class UI extends Application {

    public static void run() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL url = new File("src/main/java/UI/Scenes/welcome.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("VU Quest");
        primaryStage.setScene(new Scene(root, 960, 720));
        primaryStage.show();
    }
}
