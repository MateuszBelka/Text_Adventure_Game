package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

import java.util.ArrayList;

public class DoLook {
    public static void doLook(){
        //prints description of location and a list of items and npcs in the location.
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Location currentLocation = playerStats.getCurrentLocation();
        ArrayList<Item> itemsOfCurrentLocation = currentLocation.getListOfItems();
        ArrayList<NPC> npcsOfCurrentLocation = currentLocation.getListOfFriendlyNPCs();


        String listToPrint = "";
        for (Item item : itemsOfCurrentLocation) {
            listToPrint = listToPrint + "[" + item.getName() + "] ";
        }
        for (NPC npc : npcsOfCurrentLocation) {
            listToPrint = listToPrint + "<" + npc.getName() + "> ";
        }

        NonStoryPrinter.print(currentLocation.getDescription());
        NonStoryPrinter.print(listToPrint);
    }

    private DoLook(){} //hiding the implicit public constructor
}
