package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.player.PlayerHungerProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoUnlock {
    public static void doUnlockItemWithItem (Item itemToUnlock, Item itemToUnlockWith){
        //deletes itemToUnlockWith from inventory. Updates itemToUnlock's items, and booleans.
        // Prints command description.
        itemToUnlock.setCanBeUnlockedByItem(false);
        itemToUnlock.setItemToUnlockWith(null);
        itemToUnlockWith.setItemToUnlock(null);

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();

        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToUnlockWith);

        InteractionPrinter.print(itemToUnlock.getDescriptionOfCommand("unlock") );
    }

    private DoUnlock(){} //hiding the implicit public constructor
}
