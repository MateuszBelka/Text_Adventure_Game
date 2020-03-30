package input.validation;

import gameElements.player.PlayerHealthProgression;
import gameElements.player.PlayerStats;
import gameProgress.GameProgression;
import initialisation.InitOfClassesThroughSaveFile;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;


public class Validation {
    //todo: deal with uppercase/lowercase input

    public static void validator(String input, ActionEvent actionEvent) throws IOException, URISyntaxException {
        //Checks if player is dead of if game is completed. If not:
        // parses input (we can refer to them as "words"),
        // validates through wordvalidaor if the words contain a valid command, item, npc, or direction,
        // and then sends the validated input to inputvalidator (where it will be validated for logic).
        if (PlayerHealthProgression.isDead() || GameProgression.isGameCompleted()) {
            GameProgression.inputValidationAfterGameOver(input, actionEvent);
        }
        else {
            String[] inputList = inputParser(input);

            HashMap<String, String> validInputList = compileValidList(inputList);

            InputValidation.inputValidator(validInputList, actionEvent);
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
