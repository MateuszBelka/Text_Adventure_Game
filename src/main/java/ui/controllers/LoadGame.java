package ui.controllers;

import input.commands.DoSave;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import saveAndLoad.Load;
import ui.UI;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LoadGame {
    public void autoSaveButtonClicked(ActionEvent actionEvent) throws IOException, URISyntaxException {
        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        String projectPath = path.substring(path.length() - 23);
        // Different absolute path for IDE and for JAR
        if (projectPath.equals("build\\classes\\java\\main")) { // IDE
            path = path.substring(0, path.length() - 23);
        } else { // JAR
            path = path.substring(0, path.length() - 38);
        }
        path += "build\\resources\\saves\\autosave.json";

        Load.loadGameFromSave(path);
        UI.changeToNewScene("/fxml/adventure.fxml", actionEvent);
    }

    public void selectExistingSaveButtonClicked(ActionEvent actionEvent) throws IOException, URISyntaxException {
        String buttonText = ((Button)actionEvent.getSource()).getText().toLowerCase();

        String path = new File(DoSave.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();

        String projectPath = path.substring(path.length() - 23);
        // Different absolute path for IDE and for JAR
        if (projectPath.equals("build\\classes\\java\\main")) { // IDE
            path = path.substring(0, path.length() - 23);
        } else { // JAR
            path = path.substring(0, path.length() - 38);
        }
        path += "build\\resources\\saves\\save0.json";

        Load.loadGameFromSave(path);
        UI.changeToNewScene("/fxml/adventure.fxml", actionEvent);
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        UI.changeToNewScene("/fxml/welcome.fxml", actionEvent);
    }
}