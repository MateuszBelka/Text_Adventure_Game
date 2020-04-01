package ui.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import saveAndLoad.Load;
import saveAndLoad.createDemoOne.CreateDemo;
import saveAndLoad.meowManor.CreateGame;
import ui.UI;

import java.io.IOException;
import java.net.URISyntaxException;

public class NewGame {
    public void createGameButtonClicked(ActionEvent actionEvent) throws IOException, URISyntaxException {
        CreateGame.createGame();
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