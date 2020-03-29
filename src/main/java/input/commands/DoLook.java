package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

import java.util.ArrayList;

public class DoLook {
    public static void doLook(){
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Location currentLocation = playerStats.getCurrentLocation();
        ArrayList<Item> itemsOfCurrentLocation = currentLocation.getListOfItems();
        ArrayList<NPC> npcsOfCurrentLocation = currentLocation.getListOfFriendlyNPCs();
        ArrayList<String> listToPrint = new ArrayList<>();

        listToPrint.add(currentLocation.getDescription());
        for (Item item : itemsOfCurrentLocation) {
            listToPrint.add(item.getDescription());
        }
        for (NPC npc : npcsOfCurrentLocation) {
            listToPrint.add(npc.getDescription());
        }

        for (String text : listToPrint){
            NonStoryPrinter.print(text + "\n");
        }
    }
}
