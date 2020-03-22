package input.validation;

import java.util.HashMap;
import initialisation.CollectionOfAllClasses;

public class Validation {
    WordValidation wordValidation = CollectionOfAllClasses.getWordValidation();
    InputValidation inputValidation = CollectionOfAllClasses.getInputValidation();

    public void validator(String input){
        String[] inputList = inputParser(input);

        HashMap<String, String> validInputList = compileValidList(inputList);

        inputValidation.inputValidator(validInputList);
    }

    private String[] inputParser(String input){
        //Parses input separated by (multiple)spaces.
        String delimiters = "[ ]+";
        return input.split(delimiters);
    }

    public HashMap<String, String> compileValidList(String[] inputList){
        return wordValidation.wordValidator(inputList);
    }


}
