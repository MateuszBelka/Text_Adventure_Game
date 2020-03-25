package gameElements.levelAndContents;

import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class Item extends Entity {
    public static Item getItemByName(String name){
        Item searchedItem = null;
        ArrayList<Item> listOfItemsInCurrentLoc = InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfItems();
        for (Item item : listOfItemsInCurrentLoc){
            if (item.getName().equals(name)){
                searchedItem = item;
            }
        }
        ArrayList<Item> listOfItemsInInventory = InitOfClassesThroughSaveFile.getInventory().getItemsInInventory();
        for (Item item : listOfItemsInInventory){
            if (item.getName().equals(name)){
                searchedItem = item;
            }
        }
        return searchedItem;
    }
}
