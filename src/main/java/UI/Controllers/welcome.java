package UI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class welcome {
    public void newGameButtonClicked(ActionEvent actionEvent) {
        try {
            URL newGameURL = new File("src/main/java/UI/Scenes/newGame.fxml").toURI().toURL();
            Parent newGameParent = FXMLLoader.load(newGameURL);
            Scene newGameScene = new Scene (newGameParent, 960, 720);
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(newGameScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadGameButtonClicked(ActionEvent actionEvent) {
        try {
            URL loadGameURL = new File("src/main/java/UI/Scenes/loadGame.fxml").toURI().toURL();
            Parent loadGameParent = FXMLLoader.load(loadGameURL);
            Scene loadGameScene = new Scene (loadGameParent, 960, 720);
            Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            primaryStage.setScene(loadGameScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void quitButtonClicked(ActionEvent actionEvent) {
        Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        primaryStage.close();
    }
}
