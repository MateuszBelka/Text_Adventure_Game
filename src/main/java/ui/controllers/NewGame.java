package ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import saveAndLoad.createDemoOne.CreateDemo;
import ui.UI;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class NewGame {
    public void createGameButtonClicked(ActionEvent actionEvent) throws IOException {
        CreateDemo.createDemo();
        UI.changeToNewScene("/fxml/adventure.fxml", actionEvent);
    }

    public void selectExistingGameButtonClicked(ActionEvent actionEvent) {
        System.out.println("Feature not ready!");
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        UI.changeToNewScene("/fxml/welcome.fxml", actionEvent);
    }
}