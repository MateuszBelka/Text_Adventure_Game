package input.validation;

import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import output.NonStoryPrinter;
import ui.UI;

import java.io.IOException;
import java.util.HashMap;


public class Validation {
    //todo: deal with uppercase/lowercase input

    /*
     * ActionEvent is necessary to quit UI or switch scenes
     */
    public static void validator(String input, ActionEvent actionEvent) throws IOException {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        if (player.getCurrentHealth() < 0) {
            deathScenario(input, actionEvent);
        } else {
            String[] inputList = inputParser(input);

            HashMap<String, String> validInputList = compileValidList(inputList);

            InputValidation.inputValidator(validInputList);
        }
    }

    private static String[] inputParser(String input){
        //Parses input separated by (multiple)spaces.
        String delimiters = "[ ]+";
        return input.split(delimiters);
    }

    public static HashMap<String, String> compileValidList(String[] inputList){
        return WordValidation.wordValidator(inputList);
    }

    private static void deathScenario(String input, ActionEvent actionEvent) throws IOException {
        switch(input) {
            case "Quit":
                Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                primaryStage.close();
                break;
            case "Menu":
                //todo: clear all vars if possible
                UI.changeToNewScene("/fxml/welcome.fxml", actionEvent);
                break;
            default:
                NonStoryPrinter.print("Wrong command!");
                NonStoryPrinter.print("Type <Quit> to close the game or <Menu> to start again!");
        }
    }

}
