package ui.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import saveAndLoad.Load;
import saveAndLoad.createDemoOne.CreateDemo;
import ui.UI;

import java.io.IOException;

public class NewGame {
    public void createGameButtonClicked(ActionEvent actionEvent) throws IOException {
        CreateDemo.createDemo();
        UI.changeToNewScene("/fxml/adventure.fxml", actionEvent);
    }

    public void selectExistingGameButtonClicked(ActionEvent actionEvent) throws IOException {
        String buttonText = ((Button)actionEvent.getSource()).getText().toLowerCase();

        Load.loadGame("/json/" + buttonText + ".json");
        UI.changeToNewScene("/fxml/adventure.fxml", actionEvent);
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        UI.changeToNewScene("/fxml/welcome.fxml", actionEvent);
    }
}