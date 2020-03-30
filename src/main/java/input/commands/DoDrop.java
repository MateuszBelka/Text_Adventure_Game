package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoDrop {
    public static void doDrop(Item item){
        //drops item and sets
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(item);

        item.setCanBeDropped(false);
        NonStoryPrinter.print(item.getName() + " dropped.");

        if (item.getCanBreak()) {
            item.setCanBreak(false);
            item.setCanBePickedUp(false);
            NonStoryPrinter.print(item.getDescriptionOfCommand("break"));
        } else {
            InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().addItemToList(item);
            item.setCanBePickedUp(true);
        }
    }

    private DoDrop(){} //hiding the implicit public constructor
}
