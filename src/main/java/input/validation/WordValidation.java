package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;
import java.util.HashMap;

public class WordValidation {

    public static HashMap<String, String> wordValidator(String[] inputList) {
        HashMap<String, String> validInputList = new HashMap<>();

        for (String word : inputList) {
            commandValidator(word, validInputList);

            directionValidator(word, validInputList);

            itemValidator(word, validInputList);

            npcValidator(word, validInputList);
        }
        return validInputList;
    }

    private static void commandValidator(String word, HashMap<String, String> validInputList){
        Commands[] listOfCommands = Commands.values();
        word = word.toUpperCase();

        for (Commands command : listOfCommands) {
            if (word.equals(command.toString())) {
                validInputList.put(word, "command");
            }
        }
    }

    private static void directionValidator(String word, HashMap<String, String> validInputList){
        Directions[] listOfDirections = Directions.values();
        word = word.toUpperCase();

        for (Directions direction : listOfDirections) {
            if (word.equals(direction.toString())) {
                validInputList.put(word, "direction");
            }
        }
    }

    private static void itemValidator(String word, HashMap<String, String> validInputList) {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        ArrayList<Item> listOfItemsInPlayersCurrentLocation = playerStats.getCurrentLocation().getListOfItems();
        ArrayList<Item> listOfInventoryItems = InitOfClassesThroughSaveFile.getInventory().getItemsInInventory();
        addItemToValidInputListIfFoundInPassedList(word, validInputList, listOfItemsInPlayersCurrentLocation);
        addItemToValidInputListIfFoundInPassedList(word, validInputList, listOfInventoryItems);
    }

    private static void addItemToValidInputListIfFoundInPassedList (String word,
                                                             HashMap<String, String> validInputList,
                                                             ArrayList<Item> list){
        for (Item item : list) {
            String itemName = item.getName();
            if (word.equals(itemName)) {
                validInputList.put(word, "item");
            }
        }
    }

    private static void npcValidator(String word, HashMap<String, String> validInputList) {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        ArrayList<NPC> listOfNPCsInPlayersCurrentLocation = playerStats.getCurrentLocation().getListOfNPCs();

        for (NPC npc : listOfNPCsInPlayersCurrentLocation) {
            String npcName = npc.getName();
            if (word.equals(npcName)) {
                validInputList.put(word, "npc");
            }
        }
    }
}
