package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.player.PlayerHungerProgression;
import gameElements.player.PlayerStats;
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
        //Prints description for breaking.
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToBreakWith);
        removeItemByBreakingIt(itemToBeBroken);
        printText(itemToBeBroken);
    }

    private static void removeItemByBreakingIt(Item item) {
        //increments solved puzzle count
        PuzzleProgression.incrementPuzzlesSolvedCount();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();

        // Removes item from location.
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().deleteItemInList(item);
    }

    private static void printText(Item item){
        // Prints text for when item is broken.
        String description = item.getDescriptionOfCommand("break");
        NonStoryPrinter.print(description);
    }

    private DoBreak(){} //hiding the implicit public constructor
}
