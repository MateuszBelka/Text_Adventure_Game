package input.validation;

import initialisation.InitOfStoryIndependentClasses;

import java.util.HashMap;


public class Validation {
    //todo: deal with uppercase/lowercase input

    public static void validator(String input){
        String[] inputList = inputParser(input);

        HashMap<String, String> validInputList = compileValidList(inputList);

        InputValidation.inputValidator(validInputList);
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
