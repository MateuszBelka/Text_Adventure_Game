package output;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class StoryTextGetter {
    private ArrayList<String> listToPrint = new ArrayList<>();

    public ArrayList<String> compileStoryText(){
        listToPrint.clear();

        addLevelTextIfFirstPrint();
        addLocationTextIfFirstPrint();
        //todo: Maybe we want to print only the level and location text, and make user ask item descriptions through examine?
        addItemsTextsIfFirstPrint();
        addNPCsTextsIfFirstPrint();
        addListOfEntitiesInLocation();

        return listToPrint;
    }

    private void addLevelTextIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLevel = playerStats.getCurrentLevel().descriptionPrintedOnce();

        if (firstPrintOfLevel) {
            listToPrint.add(playerStats.getCurrentLevel().getDescription());
        }
    }

    private void addLocationTextIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLocation = playerStats.getCurrentLocation().descriptionPrintedOnce();

        if (firstPrintOfLocation) {
            listToPrint.add(playerStats.getCurrentLocation().getDescription());
        }
    }

    private void addItemsTextsIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        for (int i = 0; i < playerStats.getCurrentLocation().getListOfItems().size(); i++){
            Boolean firstPrintOfItem = playerStats.getCurrentLocation().getListOfItems().get(i).descriptionPrintedOnce();

            if (firstPrintOfItem) {
                listToPrint.add(playerStats.getCurrentLocation().getListOfItems().get(i).getDescription());
            }
        }
    }

    private void addNPCsTextsIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        for (int i = 0; i < playerStats.getCurrentLocation().getListOfNPCs().size(); i++){
            Boolean firstPrintOfNPC = playerStats.getCurrentLocation().getListOfNPCs().get(i).descriptionPrintedOnce();

            if (firstPrintOfNPC) {
                listToPrint.add(playerStats.getCurrentLocation().getListOfNPCs().get(i).getDescription());
            }
        }
    }

    private void addListOfEntitiesInLocation(){
        addListOfItems();
        addListOfNPCs();
    }

    private String addListOfItems(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        StringBuilder compiledListOfItems = new StringBuilder();
        ArrayList<Item> listOfItems = playerStats.getCurrentLocation().getListOfItems();

        for (int i = 0; i < listOfItems.size(); i++){
            String itemToAdd = "[" + listOfItems.get(i) + "] ";
            compiledListOfItems.append(itemToAdd);
        }
        return compiledListOfItems.toString();
    }

    private String addListOfNPCs(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        StringBuilder compiledListOfNPCs = new StringBuilder();
        ArrayList<NPC> listOfNPCs = playerStats.getCurrentLocation().getListOfNPCs();

        for (int i = 0; i < listOfNPCs.size(); i++){
            String itemToAdd = "<" + listOfNPCs.get(i) + "> ";
            compiledListOfNPCs.append(itemToAdd);
        }
        return compiledListOfNPCs.toString();
    }


}
