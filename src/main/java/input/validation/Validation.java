package input.validation;

import initialisation.InitOfStoryIndependentClasses;

import java.util.HashMap;


public class Validation {
    //todo: deal with uppercase/lowercase input

    public void validator(String input){
        InputValidation inputValidation = InitOfStoryIndependentClasses.getInputValidation();
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
        WordValidation wordValidation = InitOfStoryIndependentClasses.getWordValidation();
        return wordValidation.wordValidator(inputList);
    }


}
