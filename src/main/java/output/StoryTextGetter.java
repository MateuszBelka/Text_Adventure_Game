package output;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class StoryTextGetter {
    private static ArrayList<String> listToPrint = new ArrayList<>();

    public static ArrayList<String> compileStoryText(){
        //compiles the description of level, location, with its items and npcs, as well as a list
        // of entities for user to interact with, to the listToPrint.
        listToPrint.clear();

        addLevelTextIfFirstPrint();
        addLocationItemsAndNpcsTextAndListOfEntitiesIfFirstPrint();

        return listToPrint;
    }

    private static void addLevelTextIfFirstPrint(){
        //A level is entered only once. Thus, its description is printed only once. The user will never know about
        //the different levels, thus, we use the term to give story related information at a specific moment.
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLevel = playerStats.getCurrentLevel().descriptionPrintedOnce();

        if (firstPrintOfLevel) {
            listToPrint.add(playerStats.getCurrentLevel().getDescription());
        }
    }

    private static void addLocationItemsAndNpcsTextAndListOfEntitiesIfFirstPrint(){
        //This long-named method adds a description of location, its items, its npcs, and a list of the names of those
        //items and npcs that the user can interact with. Adds all these to the listToPrint.
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLocation = playerStats.getCurrentLocation().descriptionPrintedOnce();

        if (firstPrintOfLocation) {
            listToPrint.add(playerStats.getCurrentLocation().getDescription());
            addItemsTextsIfFirstPrint();
            addNPCsTextsIfFirstPrint();
            addListOfEntitiesInLocationIfFirstPrint();
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

    private static void addListOfEntitiesInLocationIfFirstPrint() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        if (playerStats.getCurrentLocation().getListOfItems().size() > 0) listToPrint.add(addListOfItems());
        if (playerStats.getCurrentLocation().getListOfFriendlyNPCs().size() > 0) listToPrint.add(addListOfNPCs());

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
