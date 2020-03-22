package input.validation;

import java.util.HashMap;

public class HandlerOf2Words {
    protected static Boolean validate2Words(HashMap<String, String> validInputList){
        if (validInputList.containsKey("item") && validInputList.containsKey("npc")) {/*todo: check if item can be given. if yes, return true." */}
        if (validInputList.containsKey("npc") && validInputList.containsValue("npc")) {/*todo: print "you cannot do that" */}
        if (validInputList.containsKey("command") && validInputList.containsValue("command")) {/*todo: print "you cannot do that" */}
        if (validInputList.containsKey("command") && validInputList.containsKey("item")){
            //todo: check if command is valid for that item. if yes, return true. If no, print "you cannot do that"
        }
        if (validInputList.containsKey("command") && validInputList.containsKey("npc")){
            //todo: check if command is valid for that item. if yes, return true. If no, print "you cannot do that"
        }
        return true; // can be deleted.
    }

    protected static void handle2ValidWords(HashMap<String, String> validInputList){
        //todo: write this method.
    }


}
