import java.util.ArrayList;

public class Inventory{
    private ArrayList<PickupableItem> listOfPickupableItems = new ArrayList<>();

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