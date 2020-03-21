package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class WordValidation {
    public HashMap<String, String> wordValidator(String[] inputList, Player player) {
        HashMap<String, String> validInputList = new HashMap<>();

        for (String word : inputList) {
            commandValidator(word, validInputList);

            itemValidator(word, validInputList, player);

            npcValidator(word, validInputList, player);
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

    private void itemValidator(String word, HashMap<String, String> validInputList, Player player) {
        ArrayList<Item> listOfItemsInPlayersCurrentLocation = player.getCurrentLocation().getListOfItems();

        for (Item item : listOfItemsInPlayersCurrentLocation) {
            String itemName = item.getName();
            if (word.equals(itemName)) {
                validInputList.put(word, "item");
            }
        }
    }

    private void npcValidator(String word, HashMap<String, String> validInputList, Player player) {
        ArrayList<NPC> listOfNPCsInPlayersCurrentLocation = player.getCurrentLocation().getListOfNPCs();

        for (NPC npc : listOfNPCsInPlayersCurrentLocation) {
            String npcName = npc.getName();
            if (word.equals(npcName)) {
                validInputList.put(word, "npc");
            }
        }
    }

}
