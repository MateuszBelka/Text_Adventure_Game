package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.UI;

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
        UI.changeToNewScene("src/main/java/UI/scenes/welcome.fxml", actionEvent);
    }
}