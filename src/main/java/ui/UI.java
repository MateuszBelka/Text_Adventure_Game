package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//Requires JDK 11+ to run

public class UI extends Application {

    private static FXMLLoader loader;

    public static FXMLLoader getLoader() {
        return loader;
    }

    public static void run() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        URL welcomeURL = new File("src/main/resources/fxml/welcome.fxml").toURI().toURL();
        loader = new FXMLLoader();
        loader.setLocation(welcomeURL);
        Scene welcomeScene = new Scene (loader.load(), 960, 720);

        primaryStage.setTitle("VU Quest");
        primaryStage.setScene(welcomeScene);
        primaryStage.show();
    }

    public static void changeToNewScene(String newSceneContentsFile, ActionEvent actionEvent) throws IOException {
        URL newSceneURL = new File(newSceneContentsFile).toURI().toURL();
        loader = new FXMLLoader();
        loader.setLocation(newSceneURL);
        Scene newScene = new Scene (loader.load(), 960, 720);

        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(newScene);
    }
}