package input.validation;

import java.util.HashMap;

public class HandlerOf3Words {
    protected static Boolean validate3Words(HashMap<String, String> validInputList){
        if (    validInputList.containsValue("item")    &&
                validInputList.containsValue("command") &&
                validInputList.containsValue("npc") ) {
            //todo:check if command is valid for that item. if yes, return true. If no, print "you cannot do that"
        }
        else if ( validInputList.containsValue("command") &&
                ( validInputList.containsValue("item") && validInputList.containsValue("item") ) ) {
            //todo: check if command is valid for that item and its needsItem. if yes, return true. If no, print "you cannot do that"
        }
        else {/*todo: print "input invalid", return false.*/}

        return true; //can be deleted.
    }

    protected static void handle3ValidWords(HashMap<String, String> validInputList){
        //todo: write this method.
    }
}
