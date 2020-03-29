package input.validation;

import gameElements.player.PlayerHealthProgression;
import gameProgress.GameProgression;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.HashMap;


public class Validation {
    //todo: deal with uppercase/lowercase input

    /*
     * ActionEvent is necessary to quit UI or switch scenes
     */
    public static void validator(String input, ActionEvent actionEvent) throws IOException {
        if (PlayerHealthProgression.isDead() || GameProgression.isGameCompleted()) {
            GameProgression.inputValidationAfterGameOver(input, actionEvent);
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

}
