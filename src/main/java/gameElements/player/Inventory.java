package gameElements.player;

import gameElements.levelAndContents.Item;

import java.util.ArrayList;

public class Inventory {

    private static ArrayList<Item> listOfPickupableItems = new ArrayList<>();

    //Get Methods
    public ArrayList<Item> getItemsInInventory() {return listOfPickupableItems;}
    public Item getItemByName (String name){ //retrieving item by name
        if (getItemsInInventory() != null){
            for (int i = 0; i < getItemsInInventory().size(); i++){
                if (name.equals(getItemsInInventory().get(i).getName())){
                    return getItemsInInventory().get(i);
                }
            }
        }
        return null;
    }

    public void addToInventory(Item item){ getItemsInInventory().add(item);}

    public void deleteItemFromInventory(Item item){ getItemsInInventory().remove(item);}

    public boolean canBePickedUp(Item item) { return listOfPickupableItems.contains(item); }

    public void inventoryCommand() { System.out.println(getItemsInInventory()); }

}
