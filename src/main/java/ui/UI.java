package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
        URL welcomeURL = new File("src/main/java/UI/scenes/welcome.fxml").toURI().toURL();
        Parent welcomeParent = FXMLLoader.load(welcomeURL);
        Scene welcomeScene = new Scene (welcomeParent, 960, 720);

        primaryStage.setTitle("VU Quest");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    public static void changeToNewScene(String newSceneContentsFile, ActionEvent actionEvent) throws IOException {
        URL newSceneURL = new File(newSceneContentsFile).toURI().toURL();
        Parent newSceneParent = FXMLLoader.load(newSceneURL);
        Scene newScene = new Scene (newSceneParent, 960, 720);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
    }
}