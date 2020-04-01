package gameElements.player;

import gameElements.levelAndContents.Item;

import java.util.ArrayList;

public class Inventory {

    private static Inventory instance;

    private Inventory(){};

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }


    private transient ArrayList<Item> listOfItems = new ArrayList<>();
    private ArrayList<Integer> listOfItemsIDs = new ArrayList<>();

    //Get Methods
    public ArrayList<Item> getListOfItems() {return listOfItems;}
    public ArrayList<Integer> getListOfItemsIDs() {
        return listOfItemsIDs;
    }

    //Set Methods
    public void setListOfItemsIDs(ArrayList<Integer> listOfItemsIDs) {
        this.listOfItemsIDs = listOfItemsIDs;
    }


    public Item getItemByName (String name){ //retrieving item by name
        if (getListOfItems() != null){
            for (int i = 0; i < getListOfItems().size(); i++){
                if (name.equals(getListOfItems().get(i).getName())){
                    return getListOfItems().get(i);
                }
            }
        }
        return null;
    }

    public void addToInventory(Item item){ getListOfItems().add(item);}

    public void deleteItemFromInventory(Item item){ getListOfItems().remove(item);}

}
