package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;

public class DoUnlock {
    public static void doUnlockItemWithItem (Item itemToUnlock, Item itemToUnlockWith){
        itemToUnlock.setCanBeUnlockedByItem(false);
        //todo: print:  "Unlocked " + itemToUnlock.getName();
        itemToUnlock.setItemToUnlockWith(null);
        itemToUnlockWith.setItemToUnlock(null);
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToUnlockWith);
    }
}
