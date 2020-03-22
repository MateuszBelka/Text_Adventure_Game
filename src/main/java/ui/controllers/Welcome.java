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

import ui.*;

public class Welcome {
    public void newGameButtonClicked(ActionEvent actionEvent) throws IOException {
        UI.changeToNewScene("/fxml/newGame.fxml", actionEvent);
    }

    public void loadGameButtonClicked(ActionEvent actionEvent) throws IOException {
        UI.changeToNewScene("/fxml/loadGame.fxml", actionEvent);
    }

    public void quitButtonClicked(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.close();
    }
}