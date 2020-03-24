package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.CollectionOfAllClasses;

public class DoDrop {
    public static void doDrop(Item item){
        CollectionOfAllClasses.getInventory().deleteItemFromInventory(item);
        CollectionOfAllClasses.getPlayer().getCurrentLocation().addItemToList(item);
        item.setCanBeDropped(false);
    }
}
