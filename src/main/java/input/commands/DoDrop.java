package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoDrop {
    public static void doDrop(Item item){
        //drops item and sets
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(item);

        item.setCanBeDropped(false);
        InteractionPrinter.print(item.getName() + " dropped.");

        if (item.getCanBreak() || item.getCanBeBrokenWithoutItem()) {
            item.setCanBreak(false);
            item.setCanBeBrokenWithoutItem(false);
            item.setCanBePickedUp(false);
            InteractionPrinter.print(item.getDescriptionOfCommand("break"));
        } else {
            InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().addItemToList(item);
            item.setCanBePickedUp(true);
        }

        if (!item.getItemsToDropOnBreak().isEmpty()) {
            for (Item newlyAddedItem : item.getItemsToDropOnBreak()) {
                InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems().add(newlyAddedItem);
                InteractionPrinter.print(newlyAddedItem.getName() + " was found within " + item.getName() + ".");
                if (newlyAddedItem.getCanBePickedUp()) {
                    InteractionPrinter.print(newlyAddedItem.getName() + " can now be picked up!");
                }
            }
        }
    }

    private DoDrop(){} //hiding the implicit public constructor
}
