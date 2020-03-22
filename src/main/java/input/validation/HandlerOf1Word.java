package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;
import java.util.HashMap;

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
        //if item is in inventory, and item is consumable, send through
        //if in inventory and not consumable, print "cannot eat that"
        //if not in inventory, and item can be picked up, send through
        //if not in inventory, and item can't be picked up, print "please use a [command] + [item] (+ [item])"
        ArrayList<Item> items = CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfItems();
        Item itemToHandle = new Item();
        for (Item item: items){
            if (item.getName().equals(word)){
                itemToHandle = item;
            }
        }

        if (itemToHandle.getCanBePickedUp()){
            doPickUp(itemToHandle);
        }
        else {
            //todo:print: "Cannot pick up " + itemToHandle + "."
        }
    }

    private static void handle1NPC(String word){
        //if can be talked with, send through
        //if not, print "cannot talk right now"
        //
        ArrayList<NPC> npcs = CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfNPCs();
        NPC npcToHandle = new NPC();
        for (NPC npc: npcs){
            if (npc.getName().equals(word)){
                npcToHandle = npc;
            }
        }

        if (npcToHandle.getCanBeTalkedWith()){
            doTalkWith(npcToHandle);
        }
        else{
            //todo: print "Cannot talk with " + npcToHandle + "."
        }
    }
}
