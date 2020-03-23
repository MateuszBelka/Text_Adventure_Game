package input.validation;

import gameElements.player.Player;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

import static input.validation.HandlerOf1Word.validateAndHandle1Word;
import static input.validation.HandlerOf2Words.validateAndHandle2Words;
import static input.validation.HandlerOf2Words.validateAndHandle2Words;
import static input.validation.HandlerOf3Words.handle3ValidWords;
import static input.validation.HandlerOf3Words.validate3Words;

public class InputValidation {

    public static void temporaryInputReceiver(String input, Player player) {
        //Placeholder method
    }

    public void inputValidator(HashMap<String, String> validInputList){
        int listSize = validInputList.size();

        switch (listSize){
            case 1:
                validateAndHandle1Word(validInputList);
                break;
            case 2:
                validateAndHandle2Words(validInputList);
                break;
            case 3:
                if (validate3Words(validInputList)){ handle3ValidWords(validInputList); }
                break;
            default:
                {/* todo: print "try using less words" */}
        }
    }

    protected static String getKeyInValidInputList(HashMap<String, String> validInputList, String value){
        HashSet<String> keys = new HashSet<>();
        for (Map.Entry<String, String> entry : validInputList.entrySet()){
            if (Objects.equals(value, entry.getValue())){
                keys.add(entry.getKey());
                return deleteFirstAndLastChar(keys.toString());
            }
        }
        return "";
    }

    private static String deleteFirstAndLastChar(String value){
        StringBuilder stringBuilder = new StringBuilder(value);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
