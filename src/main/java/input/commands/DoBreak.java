package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.player.PlayerHungerProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import input.validation.ExistenceCheck;
import output.NonStoryPrinter;

public class DoBreak {
    public static void doBreakWithoutItem(Item item) {
        if (!ExistenceCheck.doesItExist(item, "The item you are trying to break doesn't exist.")) return;

        if (item.getCanBreak() && item.getCanBeBrokenWithoutItem()) {
            removeItemByBreakingIt(item);
        } else if (item.getCanBreak() && item.getCanBeBrokenWithItem()) {
            doBreakWithItem(item.getItemToBreakWith(), item);
        } else {
            NonStoryPrinter.print(item.getName() + " cannot be broken.");
        }
    }

    public static void doBreakWithItem(Item itemToBreakWith, Item itemToBeBroken) {
        if (!ExistenceCheck.doesItExist(itemToBreakWith, itemToBeBroken, "Either the item you want to break or the item you need to break with doesn't exist.")) return;

        if (itemToBeBroken.getItemToBreakWith().getId() == itemToBreakWith.getId()) {
            removeItemByBreakingIt(itemToBeBroken);
        }
    }

    private static void removeItemByBreakingIt(Item item) {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        // Reduce player hunger as a result of conducting an action
        PlayerHungerProgression.decreaseCurrentHunger();

        // Remove item from location if its there
        for (Item locationItem : player.getCurrentLocation().getListOfItems()) {
            if (locationItem.getId() == item.getId()) {
                player.getCurrentLocation().getListOfItems().remove(item);
                player.getCurrentLocation().getListOfItemsIDs().remove(item.getId());
                NonStoryPrinter.print(item.getTextForBreaking());
                break;
            }
        }
        // Remove item from inventory if its there
        for (Item inventoryItem : player.getInventory().getListOfItems()) {
            if (inventoryItem.getId() == item.getId()) {
                player.getInventory().getListOfItems().remove(item);
                player.getInventory().getListOfItemsIDs().remove(item.getId());
                NonStoryPrinter.print(item.getTextForBreaking());
                break;
            }
        }
    }
}
