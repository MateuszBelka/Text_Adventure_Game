package input.validation;

import java.util.HashMap;

public class HandlerOf3Words {
    protected static Boolean validate3Words(HashMap<String, String> validInputList){
        if (    validInputList.containsValue("item")    &&
                validInputList.containsValue("command") &&
                validInputList.containsValue("npc") ) {
            return validateCommandItemNpcCombination(validInputList);
        }
        else if ( validInputList.containsValue("command") && //todo: find a way here... can't write it like this.
                ( validInputList.containsValue("item") && validInputList.containsValue("item") ) ) {
            return validateCommandItemNpcCombination(validInputList);
            //todo: check if command is valid for that item and its needsItem. if yes, return true. If no, print "you cannot do that", return false.
        }
        else {
            /*todo: print "input invalid".*/
            return false;
        }
    }

    private static Boolean validateCommandItemNpcCombination(HashMap<String, String> validInputList){
        //todo:check if command is valid for that item. if yes, return true. If no, print "you cannot do that", return false.
        return false;
    }

    private static Boolean validateCommandItemItemCombination(HashMap<String, String> validInputList){
            //todo:check if command is valid for that item. if yes, return true. If no, print "you cannot do that", return false.
        return false;
        }

    protected static void handle3ValidWords(HashMap<String, String> validInputList){
        //todo: write this method.
    }
}