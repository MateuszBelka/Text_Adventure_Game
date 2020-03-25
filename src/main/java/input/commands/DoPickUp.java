package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.CollectionOfAllClasses;

public class DoPickUp {
    public static void doPickUp(Item item){
        CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfItems().remove(item);
        CollectionOfAllClasses.getInventory().addToInventory(item);
        item.setCanBePickedUp(false);
        item.setCanBeDropped(true);
    }
}
