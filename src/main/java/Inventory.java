import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;

public class Inventory{

    private Hashmap<PickupableItem, int> listOfItems;

    Inventory(){
        listOfItems = new HashMap<PickupableItem, int>();
    }

    public HashMap<PickupableItem, int> getList(){
        return listOfItems;
    }

    private boolean contains(Pickupableitem item){
        Iterator it = listOfItems.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry mentry = (Map.Entry)it.next();
            if mentry.getKey().getName().equals(item.getName()) {
                return true;
            }
        }
        return false;
    }

    private void addOne(PickupableItem item){
        Map.Entry mentry = find(item);
        listOfItems.put(mentry.getKey(), mentry.getValue()+1);
    }

    public void addItemToInventory(PickupableItem item){
        if contains(item){
            addOne(item);
        } else{
            listOfItems.put(item, 1);
        }
    }

    public void deleteItemFromInventory(PickupableItem item){
        if !contains(item){
            return;
        } else {
            Map.Entry mentry = find(item);
            if (mentry.getValue() == 1) {
                    listOfITems.remove(mentry.getKey());
            } else {
                listOfItems.put(mentry.getKey(), mentry.getValue() - 1);
            }
        }
    }
    public String getStoryTextByItem(PickupableItem item){
        if contains(item){
            Map.Entry mentry = find(item);
            return mentry.getKey().getTextAboutItem();
        }
        return "";
    }

    private Map.Entry find(PickupableItem item){
        Iterator it = listOfItems.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            if mentry.getKey().getName().equals(item.getName()) {
                return mentry;
            }
        }
    }
}
