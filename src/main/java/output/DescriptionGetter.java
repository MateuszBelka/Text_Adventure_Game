package output;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class DescriptionGetter {
    private static ArrayList<String> listToPrint = new ArrayList<>();

    public static ArrayList<String> compileStoryText(){
        //compiles the description of level and/or location,
        // with a list of entities for user to interact with, to the listToPrint.
        listToPrint.clear();

        addLevelTextIfFirstPrint();
        addLocationTextAndListOfEntitiesIfFirstPrint();

        return listToPrint;
    }

    private static void addLevelTextIfFirstPrint(){
        //A level is entered only once. Thus, its description is printed only once. The user will never know about
        //the different levels, thus, we use the term to give story related information at a specific moment.
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLevel = playerStats.getCurrentLevel().descriptionPrintedOnce();

        if (firstPrintOfLevel) {
            listToPrint.add("[" + playerStats.getCurrentLevel().getName() + "]");
            listToPrint.add(playerStats.getCurrentLevel().getDescription());
        }
    }

    private static void addLocationTextAndListOfEntitiesIfFirstPrint(){
        //This method adds a description of location, and a list of the names of those
        //items and npcs that the user can interact with, to the listToPrint.
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Boolean firstPrintOfLocation = playerStats.getCurrentLocation().descriptionPrintedOnce();

        if (firstPrintOfLocation) {
            listToPrint.add("[" + playerStats.getCurrentLocation().getName() + "]");
            listToPrint.add(playerStats.getCurrentLocation().getDescription());
            addListOfEntitiesInLocationIfFirstPrint();
        }
    }
    private static void addListOfEntitiesInLocationIfFirstPrint(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        //Adds list of items and npcs in the location, to interact with, into the listToPrint.
        if (playerStats.getCurrentLocation().getListOfItems().size() > 0) {
            for (Item item : playerStats.getCurrentLocation().getListOfItems()) {
                listToPrint.add("[" + item.getName() + "]");
                listToPrint.add(item.getDescription());
            }
        }
        if (playerStats.getCurrentLocation().getListOfFriendlyNPCs().size() > 0) {
            for (NPC npc : playerStats.getCurrentLocation().getListOfFriendlyNPCs()) {
                listToPrint.add("[" + npc.getName() + "]");
                listToPrint.add(npc.getDescription());
            }
        }
    }
}
