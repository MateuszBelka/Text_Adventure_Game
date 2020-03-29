package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoPickUp {
    public static void doPickUp(Item item){
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems().remove(item);
        InitOfClassesThroughSaveFile.getInventory().addToInventory(item);
        item.setCanBePickedUp(false);
        item.setCanBeDropped(true);
        NonStoryPrinter.print(item.getName() + " picked up.");
    }
}
