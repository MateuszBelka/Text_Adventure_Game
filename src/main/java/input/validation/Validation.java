package input.validation;

import java.util.HashMap;
import initialisation.CollectionOfAllClasses;


public class Validation {
    WordValidation wordValidation;
    InputValidation inputValidation;

    //Set Methods
    public void setWordValidation(WordValidation wordValidation) {
        this.wordValidation = wordValidation;
    }
    public void setInputValidation(InputValidation inputValidation) {
        this.inputValidation = inputValidation;
    }
    //todo: deal with uppercase/lowercase input

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
