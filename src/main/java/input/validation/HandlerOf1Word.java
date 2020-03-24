package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;
import java.util.HashMap;

import static input.commands.DoConsume.doConsume;
import static input.commands.DoExit.doExit;
import static input.commands.DoGetInventory.doInventoryLookUp;
import static input.commands.DoListen.doListen;
import static input.commands.DoLoad.doLoad;
import static input.commands.DoLook.doLook;
import static input.commands.DoMove.doMove;
import static input.commands.DoPickUp.doPickUp;
import static input.commands.DoRead.doRead;
import static input.commands.DoSave.doSave;
import static input.commands.DoTalkWith.doTalkWith;
import static input.validation.InputValidation.*;

public class HandlerOf1Word {

    protected static void validateAndHandle1Word(HashMap<String, String> validInputList){
        if (validInputList.containsValue("command")) {
            String command = getCommand(validInputList);
            handle1Command(command);
        }
        if (validInputList.containsValue("item")) {
            Item item = getItem(validInputList);
            handle1Item(item);
        }
        if (validInputList.containsValue("npc")) {
            NPC npc = getNPC(validInputList);
            handle1NPC(npc);
        }
        if (validInputList.containsValue("direction")) {
            String direction = getKeyInValidInputList(validInputList, "direction");
            handle1Direction(direction);
        }
    }

    private static void handle1Command(String command){
        for (CommandsWith1ValidWord validCommand : CommandsWith1ValidWord.values()) {
            if (validCommand.toString().equals(command)) {
                doCommand(command);
            }
            else {/*todo: print message "try writing [" + word + "] + [item]"*/}
        }
    }

    private static void doCommand(String command){
        switch (command) {
            case "EXIT":
            case "QUIT":
                doExit();
                break;
            case "READ":
                handleReadCommand();
                break;
            case "SAVE":
                doSave();
                break;
            case "LISTEN":
                doListen();
                break;
            case "LOAD":
                doLoad();
                break;
            case "INVENTORY":
                doInventoryLookUp();
                break;
            case "JUMP": //todo: print message about having jumped in the air.
                break;
            case "LOOK":
                doLook();
                break;
            default: //todo: print: "This command cannot be used that way. Enter "help" for an overview of how to use commands. "
        }
    }

    private static void handleReadCommand() {
        ArrayList<Item> listOfItemsInCurrentLocation =
                CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfItems();
        int amountOfReadableItems = 0;
        Item itemToRead = null;

        for(Item item : listOfItemsInCurrentLocation){
            if (item.getCanBeRead()){
                amountOfReadableItems++;
                itemToRead = item;
            }
        }

        if (amountOfReadableItems == 1){
            doRead(itemToRead);
        }
        else{
            //todo: print: "Try Read + [thing] "
        }
    }

    private static void handle1Item(Item item){
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

    private static void handle1NPC(NPC npc){
        if (npc.getCanBeTalkedWith()){
            doTalkWith(npc);
        }
        else {
            //todo: print "Cannot talk with " + word + "."
        }
    }

    protected static void handle1Direction(String direction){
        direction = direction.toLowerCase();
        HashMap<String, Location> listOfLocationsFromCurrentLocation =
                CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfConnectedLocations();

        if (listOfLocationsFromCurrentLocation.containsKey(direction)){
            Location location = listOfLocationsFromCurrentLocation.get(direction);
            doMove(location);
        }
        else {
            //todo: print "Cannot go this way."
        }
    }
}
