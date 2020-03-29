package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.player.Inventory;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;


public class DoGetInventory {
    public static void doInventoryLookUp() {
        Inventory inv = InitOfClassesThroughSaveFile.getPlayerStats().getInventory();

        for(Item item : inv.getListOfItems()) {
            NonStoryPrinter.print(item.getName());
        }
    }
}
