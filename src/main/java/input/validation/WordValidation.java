package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.Player;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class WordValidation {
    Player player;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public HashMap<String, String> wordValidator(String[] inputList) {
        HashMap<String, String> validInputList = new HashMap<>();

        for (String word : inputList) {
            commandValidator(word, validInputList);

            itemValidator(word, validInputList);

            npcValidator(word, validInputList);
        }
        return validInputList;
    }

    private void commandValidator(String word, HashMap<String, String> validInputList){
        Commands[] listOfCommands = Commands.values();

        for (Commands command : listOfCommands) {
            if (word.equals(command.toString())) {
                validInputList.put(word, "command");
            }
        }
    }

    private void itemValidator(String word, HashMap<String, String> validInputList) {
        ArrayList<Item> listOfItemsInPlayersCurrentLocation = player.getCurrentLocation().getListOfItems();
        ArrayList<Item> listOfInventoryItems = CollectionOfAllClasses.getInventory().getItemsInInventory();
        addItemToValidInputListIfFoundInPassedList(word, validInputList, listOfItemsInPlayersCurrentLocation);
        addItemToValidInputListIfFoundInPassedList(word, validInputList, listOfInventoryItems);
    }

    private void addItemToValidInputListIfFoundInPassedList (String word,
                                                             HashMap<String, String> validInputList,
                                                             ArrayList<Item> list){
        for (Item item : list) {
            String itemName = item.getName();
            if (word.equals(itemName)) {
                validInputList.put(word, "item");
            }
        }
    }

    private void npcValidator(String word, HashMap<String, String> validInputList) {
        ArrayList<NPC> listOfNPCsInPlayersCurrentLocation = player.getCurrentLocation().getListOfNPCs();

        for (NPC npc : listOfNPCsInPlayersCurrentLocation) {
            String npcName = npc.getName();
            if (word.equals(npcName)) {
                validInputList.put(word, "npc");
            }
        }
    }

}
