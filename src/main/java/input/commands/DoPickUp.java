package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoPickUp {
    public static void doPickUp(Item item){
        //deletes item from currentlocation list, adds to inventory list, updates stats, and prints command description.
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems().remove(item);
        InitOfClassesThroughSaveFile.getInventory().addToInventory(item);
        item.setCanBePickedUp(false);
        item.setCanBeDropped(true);
        NonStoryPrinter.print( item.getDescriptionOfCommand("pickup") );
    }
}
