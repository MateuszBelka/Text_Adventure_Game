import java.util.ArrayList;

public class Room {

    private ArrayList<String> listOfAvailableDir = new ArrayList<>();
    private ArrayList<StaticItem> listOfStaticItems = new ArrayList<>();
    private ArrayList<PickupableItem> listOfPickupableItems = new ArrayList<>();

    public ArrayList<String> getListOfAvailableDir(){return listOfAvailableDir;}
    public void setListOfAvailableDir(String availableDir){listOfAvailableDir.add(availableDir);}

    public ArrayList<StaticItem> getListOfStaticItems() {return listOfStaticItems;}
    public void setListOfStaticItems(StaticItem newStaticItem){listOfStaticItems.add(newStaticItem);}

    public ArrayList<PickupableItem> getListOfPickupableItems() {return listOfPickupableItems;}
    public void setListOfPickupableItems(PickupableItem newPickupableItem){listOfPickupableItems.add(newPickupableItem);}

    public void print() {System.out.println("room");} // tmp kept for room2
}

