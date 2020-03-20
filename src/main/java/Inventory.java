/*
 * We've decided to change our project structure to utilize
 * packages for Assignment 3.
 *
 * The following file is temporary and will be removed
 * when it's functionality is copied by corresponding new file.
 *
 * Due to this work in progress currently only UI part of our code fully works.
 * That includes initial framework for IO.
 */

import java.util.ArrayList;

public class Inventory{
    private final ArrayList<PickupableItem> listOfPickupableItems = new ArrayList<>();

    //Get Methods
    public ArrayList<PickupableItem> getItemsInInventory() {return listOfPickupableItems;}
    public PickupableItem getItemByName (String name){ //retrieving item by name
        if (getItemsInInventory() != null){
            for (int i = 0; i < getItemsInInventory().size(); i++){
                if (name.equals(getItemsInInventory().get(i).getName())){
                    return getItemsInInventory().get(i);
                }
            }
        }
        return null;
    }

    //Set Methods
    public void addToInventory(PickupableItem item){
        getItemsInInventory().add(item);}
    public void deleteItemFromInventory(PickupableItem item){
        getItemsInInventory().remove(item);}
}