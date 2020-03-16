package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class NewGame {
    public void createGameButtonClicked(ActionEvent actionEvent) {
        System.out.println("Feature not ready!");
    }

    public void selectExistingGameButtonClicked(ActionEvent actionEvent) {
        System.out.println("Feature not ready!");
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        URL welcomeURL = new File("src/main/java/UI/Scenes/welcome.fxml").toURI().toURL();
        Parent welcomeParent = FXMLLoader.load(welcomeURL);
        Scene welcomeScene = new Scene (welcomeParent, 960, 720);
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(welcomeScene);
    }
}