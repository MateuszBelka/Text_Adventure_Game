package input.validation;

import java.util.HashMap;
import gameElements.player.Player;
import initialisation.CollectionOfAllClasses;
import input.commands.CommandHandler;

public class InputValidation {

    public void inputValidator(String input) {
        Player player = CollectionOfAllClasses.getPlayer();

        String[] inputList = inputParser(input);

        WordValidation wordValidation = CollectionOfAllClasses.getWordValidation();
        HashMap<String, String> validInputList = wordValidation.wordValidator(inputList, player);

        CommandHandler commandHandler = CollectionOfAllClasses.getCommandHandler();
        commandHandler.handleCommand(validInputList);
    }

    private String[] inputParser(String input){
        //Parses input separated by (multiple)spaces.
        String delimiters = "[ ]+";
        return input.split(delimiters);
    }
}
