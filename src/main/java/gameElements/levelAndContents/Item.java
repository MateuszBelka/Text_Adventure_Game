package gameElements.levelAndContents;

import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;

public class Item extends Entity {
    public static Item getItemByName(String name){
        Item searchedItem = null;
        ArrayList<Item> listOfItemsInCurrentLoc = CollectionOfAllClasses.getPlayer().getCurrentLocation().listOfItems;
        for (Item item : listOfItemsInCurrentLoc){
            if (item.getName().equals(name)){
                searchedItem = item;
            }
        }
        ArrayList<Item> listOfItemsInInventory = CollectionOfAllClasses.getInventory().getItemsInInventory();
        for (Item item : listOfItemsInInventory){
            if (item.getName().equals(name)){
                searchedItem = item;
            }
        }
        return searchedItem;
    }
}
