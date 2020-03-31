package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.player.PlayerHungerProgression;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoBreak {
    public static void doBreakWithoutItem(Item item) {
        //Removes item to break from current location. Prints description for this command.
        removeItemByBreakingIt(item);
        printText(item);
    }

    public static void doBreakWithItem(Item itemToBreakWith, Item itemToBeBroken) {
        //Deletes itemToBreakWith from inventory, deletes itemToBeBroken from current location.
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToBreakWith);
        removeItemByBreakingIt(itemToBeBroken);

        //Prints description for breaking.
        printText(itemToBeBroken);
    }

    private static void removeItemByBreakingIt(Item item) {
        //increments solved puzzle count
        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();

        // Removes item from location.
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().deleteItemInList(item);

        if (!item.getItemsToDropOnBreak().isEmpty()) {
            for (Item newlyAddedItem : item.getItemsToDropOnBreak()) {
                InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems().add(newlyAddedItem);
                NonStoryPrinter.print(newlyAddedItem.getName() + " was found within " + item.getName() + ".");
                if (newlyAddedItem.getCanBePickedUp()) {
                    NonStoryPrinter.print(newlyAddedItem.getName() + " can now be picked up!");
                }
            }
        }
    }

    private static void printText(Item item){
        // Prints text for when item is broken.
        String description = item.getDescriptionOfCommand("break");
        NonStoryPrinter.print(description);
    }

    private DoBreak(){} //hiding the implicit public constructor
}
