package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoUnlock {
    public static void doUnlockItemWithItem (Item itemToUnlock, Item itemToUnlockWith){
        //deletes itemToUnlockWith from inventory. Updates itemToUnlock's items, and booleans.
        // Prints command description.
        itemToUnlock.setCanBeUnlockedByItem(false);
        itemToUnlock.setItemToUnlockWith(null);
        itemToUnlockWith.setItemToUnlock(null);

        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToUnlockWith);

        NonStoryPrinter.print(itemToUnlock.getDescriptionOfCommand("unlock") );
    }

    private DoUnlock(){} //hiding the implicit public constructor
}
