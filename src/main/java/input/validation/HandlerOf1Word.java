package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import initialisation.InitOfClassesThroughSaveFile;
import javafx.event.ActionEvent;
import output.NonStoryPrinter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import static input.commands.DoAttack.doAttack;
import static input.commands.DoBack.doBack;
import static input.commands.DoConsume.doConsume;
import static input.commands.DoGetDirections.doGetDirections;
import static input.commands.DoExit.doExit;
import static input.commands.DoGetInventory.doInventoryLookUp;
import static input.commands.DoGoToMenu.doGoToMenu;
import static input.commands.DoListen.doListen;
import static input.commands.DoLoad.doLoad;
import static input.commands.DoLook.doLook;
import static input.commands.DoMove.doMove;
import static input.commands.DoPickUp.doPickUp;
import static input.commands.DoRead.doRead;
import static input.commands.DoSave.doSave;
import static input.commands.DoSmell.doSmell;
import static input.commands.DoTalkWith.doTalkWith;
import static input.commands.DoHelp.doHelp;
import static input.validation.InputValidation.*;

public class HandlerOf1Word {

    protected static void validateAndHandle1Word(HashMap<String, String> validInputList, ActionEvent actionEvent) throws IOException, URISyntaxException {
        if (validInputList.containsValue("command")) {
            String command = getCommand(validInputList);
            handle1Command(command, actionEvent);
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

    private static void handle1Command(String command, ActionEvent actionEvent) throws IOException, URISyntaxException {
        boolean check = false;
        for (CommandsWith1ValidWord validCommand : CommandsWith1ValidWord.values()) {
            String validCommandString = validCommand.toString();
            if (validCommandString.equals(command)) {
                doCommand(command, actionEvent);
                check = true;
            }
        }
        if (!check) { NonStoryPrinter.print("Cannot use [" + command.toLowerCase() + "] this way. Try [help]. "); }
    }

    private static void doCommand(String command, ActionEvent actionEvent) throws IOException, URISyntaxException {

        switch (command) {
            case "MENU":
                doGoToMenu(actionEvent);
                break;
            case "DIRECTIONS":
                doGetDirections();
                break;
            case "SMELL":
                doSmell();
                break;
            case "LISTEN":
                doListen();
                break;
            case "HELP":
                doHelp();
                break;
            case "EXIT":
            case "QUIT":
                doExit(actionEvent);
                break;
            case "BACKTRACK":
            case "BACK":
                doBack();
                break;
            case "READ":
                handleReadCommand();
                break;
            case "SAVE":
                doSave();
                break;
            case "LOAD":
                doLoad(actionEvent);
                break;
            case "INVENTORY":
                doInventoryLookUp();
                break;
            case "JUMP": NonStoryPrinter.print("Nice jump!");
                break;
            case "LOOK":
                doLook();
                break;
            default: NonStoryPrinter.print("This command cannot be used that way. Enter \"help\" for an overview " +
                    "of how to use commands.");
        }
    }

    private static void handleReadCommand() {
        ArrayList<Item> listOfItemsInCurrentLocation =
                InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems();
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
        else{ NonStoryPrinter.print("Please be more specific. Try writing: read [thing]"); }
    }

    private static void handle1Item(Item item){
        if (item.getCanBePickedUp()){
            doPickUp(item);
        }
        else if (item.getCanBeConsumed()){
            doConsume(item);
        }
        else{
            NonStoryPrinter.print("Please be more specific. Check [help]. ");
        }
    }

    private static void handle1NPC(NPC npc){
        if (npc.getCanBeTalkedWith()){
            doTalkWith(npc);
        }
        else {
            NonStoryPrinter.print("Cannot talk with " + npc.getName() + ".");
        }
    }

    protected static void handle1Direction(String direction){
        direction = direction.toLowerCase();
        HashMap<String, Location> listOfLocationsFromCurrentLocation =
                InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfConnectedLocations();

        if (listOfLocationsFromCurrentLocation.containsKey(direction)){
            Location location = listOfLocationsFromCurrentLocation.get(direction);
            doMove(location);
        }
        else {
            NonStoryPrinter.print("Cannot go this way.");
        }
    }
}
