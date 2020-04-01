package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoPickUp {
    public static void doPickUp(Item item){
        //deletes item from currentlocation list, adds to inventory list, updates stats, and prints command description.
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems().remove(item);
        InitOfClassesThroughSaveFile.getInventory().addToInventory(item);
        item.setCanBePickedUp(false);
        item.setCanBeDropped(true);
        InteractionPrinter.print( item.getDescriptionOfCommand("pickup") );
    }

    private DoPickUp(){} //hiding the implicit public constructor
}
