package output;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class StoryTextGetter {
    private static ArrayList<String> listToPrint = new ArrayList<>();

    public static ArrayList<String> compileStoryText(){
        listToPrint.clear();

        addLevelTextIfFirstPrint();
        addLocationTextIfFirstPrint();
        //todo: Maybe we want to print only the level and location text, and make user ask item descriptions through examine?
        addItemsTextsIfFirstPrint();
        addNPCsTextsIfFirstPrint();
        addListOfEntitiesInLocation();

        return listToPrint;
    }

    private static void addLevelTextIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLevel = playerStats.getCurrentLevel().descriptionPrintedOnce();

        if (firstPrintOfLevel) {
            listToPrint.add(playerStats.getCurrentLevel().getDescription());
        }
    }

    private static void addLocationTextIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLocation = playerStats.getCurrentLocation().descriptionPrintedOnce();

        if (firstPrintOfLocation) {
            listToPrint.add(playerStats.getCurrentLocation().getDescription());
        }
    }

    private static void addItemsTextsIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        for (int i = 0; i < playerStats.getCurrentLocation().getListOfItems().size(); i++){
            Boolean firstPrintOfItem = playerStats.getCurrentLocation().getListOfItems().get(i).descriptionPrintedOnce();

            if (firstPrintOfItem) {
                listToPrint.add(playerStats.getCurrentLocation().getListOfItems().get(i).getDescription());
            }
        }
    }

    private static void addNPCsTextsIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        for (int i = 0; i < playerStats.getCurrentLocation().getListOfFriendlyNPCs().size(); i++){
            Boolean firstPrintOfNPC = playerStats.getCurrentLocation().getListOfFriendlyNPCs().get(i).descriptionPrintedOnce();

            if (firstPrintOfNPC) {
                listToPrint.add(playerStats.getCurrentLocation().getListOfFriendlyNPCs().get(i).getDescription());
            }
        }
    }

    private static void addListOfEntitiesInLocation(){
        listToPrint.add(addListOfItems());
        listToPrint.add(addListOfNPCs());
    }

    private static String addListOfItems(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        StringBuilder compiledListOfItems = new StringBuilder();
        ArrayList<Item> listOfItems = playerStats.getCurrentLocation().getListOfItems();

        for (int i = 0; i < listOfItems.size(); i++){
            String itemToAdd = "[" + listOfItems.get(i).getName() + "] ";
            compiledListOfItems.append(itemToAdd);
        }
        return compiledListOfItems.toString();
    }

    private static String addListOfNPCs(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        StringBuilder compiledListOfNPCs = new StringBuilder();
        ArrayList<NPC> listOfNPCs = playerStats.getCurrentLocation().getListOfFriendlyNPCs();

        for (int i = 0; i < listOfNPCs.size(); i++){
            String itemToAdd = "<" + listOfNPCs.get(i).getName() + "> ";
            compiledListOfNPCs.append(itemToAdd);
        }
        return compiledListOfNPCs.toString();
    }
}
