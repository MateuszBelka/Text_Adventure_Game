package input.commands;

import gameElements.player.Player;

import java.util.HashMap;

public class CommandHandler {
    public static void temporaryInputReceiver(String input, Player player) {
        //Placeholder method
    }

    public void handleCommand(HashMap<String, String> validInputList){
        int listSize = validInputList.size();


        if (listSize > 3) { /* print "try using less words" */}

        if (listSize == 1){
            if (validInputList.containsKey("command")){
                //check if command is one of the enums that can be used on its own
                //if yes, do it
                //if no, print message "try writing " + command + " plus the item"
            }
            if (validInputList.containsKey("item")){
                //if item is in inventory, and item is consumable, send through
                //if in inventory and not consumable, print "cannot eat that"
                //if not in inventory, and item can be picked up, send through
                //if not in inventory, and item can't be picked up, print "please use a [command] + [item] (+ [item])"
            }
            if (validInputList.containsKey("npc")){
                //if can be talked with, send through
                //if not, print "cannot talk right now"
                //
            }
        }

        if (listSize == 2){
            if (validInputList.containsKey("item") && validInputList.containsKey("npc")) {/*print "you cannot do that" */}
            if (validInputList.containsKey("npc") && validInputList.containsValue("npc")) {/*print "you cannot do that" */}
            if (validInputList.containsKey("command") && validInputList.containsValue("command")) {/*print "you cannot do that" */}
            if (validInputList.containsKey("command") && validInputList.containsKey("item")){
                //check if command is valid for that item. if yes, send through
                //if no, print "you cannot do that"
            }
            if (validInputList.containsKey("command") && validInputList.containsKey("npc")){
                //check if command is valid for that item. if yes, send through
                //if no, print "you cannot do that"
            }
        }

        if (listSize == 3){
            if (validInputList.containsKey("item") && validInputList.containsKey("npc")) {/*print "you cannot do that" */}
            if (    validInputList.containsValue("item")    &&
                    validInputList.containsValue("command") &&
                    validInputList.containsValue("npc") ) {
                //check if command is valid for that item. if yes, send through
                //if no, print "you cannot do that"
            }
            else if ( validInputList.containsValue("command") &&
                       ( validInputList.containsValue("item") && validInputList.containsValue("item") ) ) {
                //check if command is valid for that item and its needsItem. if yes, send through
                //if no, print "you cannot do that"
            }
            else {/*print "input invalid"*/}
        }
    }
}
