package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoDrop {
    public static void doDrop(Item item){
        //drops item and sets
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(item);
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().addItemToList(item);
        item.setCanBeDropped(false);
        item.setCanBePickedUp(true);
        NonStoryPrinter.print(item.getName() + " dropped.");

        //todo: if can break, break? wouldn't that be cool?
    }

    private DoDrop(){} //hiding the implicit public constructor
}
