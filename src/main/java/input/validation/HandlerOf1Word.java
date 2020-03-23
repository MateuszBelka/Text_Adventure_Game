package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;
import java.util.HashMap;

import static input.commands.Consume.doConsume;
import static input.commands.Exit.doExit;
import static input.commands.Inventory.doInventory;
import static input.commands.Load.doLoad;
import static input.commands.Look.doLook;
import static input.commands.PickUp.doPickUp;
import static input.commands.Read.doRead;
import static input.commands.Save.doSave;
import static input.commands.TalkWith.doTalkWith;
import static input.validation.InputValidation.getKeyInValidInputList;

public class HandlerOf1Word {

    protected static void validateAndHandle1Word(HashMap<String, String> validInputList){
        String word;
        if (validInputList.containsValue("command")) {
            word = getKeyInValidInputList(validInputList, "command").toUpperCase();
            handle1Command(word);
        }
        if (validInputList.containsValue("item")) {
            word = getKeyInValidInputList(validInputList, "item");
            handle1Item(word);
        }
        if (validInputList.containsValue("npc")) {
            word = getKeyInValidInputList(validInputList, "npc");
            handle1NPC(word);
        }
    }

    private static void handle1Command(String word){
        for (CommandsWith1ValidWord validCommand : CommandsWith1ValidWord.values()) {
            if (validCommand.toString().equals(word)) {
                doCommand(word);
            }
            else {/*todo: print message "try writing " + word + " plus the item"*/}
        }
    }

    private static void doCommand(String word){
        switch (word) {
            case "EXIT":
            case "QUIT":
                doExit();
                break;
            case "READ":
                doRead();
                break;
            case "SAVE":
                doSave();
                break;
            case "LOAD":
                doLoad();
                break;
            case "INVENTORY":
                doInventory();
                break;
            case "JUMP": //todo: print message about having jumped in the air.
                break;
            case "LOOK":
                doLook();
                break;
            default: //todo: print: "This command cannot be used that way. Enter "help" for an overview of how to use commands. "
        }
    }

    private static void handle1Item(String word){
        Item item = Item.getItemByName(word);
        if (item.getCanBePickedUp()){
            doPickUp(item);
        }
        if (item.getCanBeConsumed()){
            doConsume(item);
        }
        else{
            //todo: print "Please be more specific. Use [command] + [thing] (+ [thing])"
        }
    }

    private static void handle1NPC(String word){
        NPC npc = NPC.getNPCByName(word);

        if (npc.getCanBeTalkedWith()){
            doTalkWith(npc);
        }
        else {
            //todo: print "Cannot talk with " + word + "."
        }
    }
}
