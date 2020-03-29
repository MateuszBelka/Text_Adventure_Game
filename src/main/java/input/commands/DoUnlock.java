package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoUnlock {
    public static void doUnlockItemWithItem (Item itemToUnlock, Item itemToUnlockWith){
        itemToUnlock.setCanBeUnlockedByItem(false);
        NonStoryPrinter.print("Unlocked " + itemToUnlock.getName() + ".");
        itemToUnlock.setItemToUnlockWith(null);
        itemToUnlockWith.setItemToUnlock(null);
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToUnlockWith);
    }
}
