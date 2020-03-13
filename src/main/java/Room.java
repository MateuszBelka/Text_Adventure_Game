import java.util.ArrayList;

public class Room {
    //Variable Declaration
    private ArrayList<String> listOfAvailableDirections;
    //consider using enumerator or some sort of mapping 1(direction) to 1(room)
    private Room north;
    private Room east;
    private Room south;
    private Room west;
    private ArrayList<StaticItem> listOfStaticItems;
    private ArrayList<PickupableItem> listOfPickupableItems;
    private Level level;
    private String textAboutRoom;

    //Constructor
    public Room(){
        this.listOfPickupableItems = new ArrayList<>();
        this.listOfStaticItems = new ArrayList<>();
    }

    //Get Methods
    public ArrayList<String> getListOfAvailableDirections() {
        return listOfAvailableDirections;
    }
    public Room getNorth() { return north; }
    public Room getEast() { return east; }
    public Room getSouth() { return south; }
    public Room getWest() { return west; }
    public ArrayList<StaticItem> getListOfStaticItems() {
        return listOfStaticItems;
    }
    public ArrayList<PickupableItem> getListOfPickupableItems() {
        return listOfPickupableItems;
    }
    public Level getLevel() {
        return level;
    }
    public String getTextAboutRoom() { return textAboutRoom; }

    //Set Methods
    public void setListOfAvailableDirections(ArrayList<String> listOfAvailableDirections) {
        this.listOfAvailableDirections = listOfAvailableDirections;
    }
    public void setNorth(Room north) { this.north = north; }
    public void setEast(Room east) { this.east = east; }
    public void setSouth(Room south) { this.south = south; }
    public void setWest(Room west) { this.west = west; }
    public void setListOfStaticItems(ArrayList<StaticItem> listOfStaticItems) {
        this.listOfStaticItems = listOfStaticItems;
    }
    public void setListOfPickupableItems(ArrayList<PickupableItem> listOfPickupableItems) {
        this.listOfPickupableItems = listOfPickupableItems;
    }
    public void setLevel(Level level) { this.level = level; }
    public void setTextAboutRoom(String textAboutRoom) { this.textAboutRoom = textAboutRoom; }

    //Main Methods
    public void updateRoomDirections(Room north, //update of possible directions from the current room
                                     Room east,
                                     Room south,
                                     Room west) {
        setNorth(north);
        setEast(east);
        setSouth(south);
        setWest(west);
    }

    public void updateListOfAvailableDirectionsUsingRooms() { //update list of possible directions depending on the current room
        listOfAvailableDirections = new ArrayList<>();

        if (getNorth() != null) listOfAvailableDirections.add("north");
        if (getEast() != null) listOfAvailableDirections.add("east");
        if (getSouth() != null) listOfAvailableDirections.add("south");
        if (getWest() != null) listOfAvailableDirections.add("west");
    }

    public Room getRoomInDirection(String direction) { //get the name and properties of the room per direction
        switch(direction) {
            case "north":
                return getNorth();
            case "east":
                return getEast();
            case "south":
                return getSouth();
            case "west":
                return getWest();
            default:
                return null;
        }
    }

    public PickupableItem getPickupableItemByName(String name) { //return name of pickupable item
        for (int i = 0; i < getListOfPickupableItems().size(); i++){
            if (getListOfPickupableItems().get(i).getName().equals(name)){
                return getListOfPickupableItems().get(i);
            }
        }
        return null;
    }

    public StaticItem getStaticItemByName(String name) { //return name of the static item
        for (int i = 0; i < getListOfStaticItems().size(); i++){
            if (getListOfStaticItems().get(i).getName().equals(name)){
                return getListOfStaticItems().get(i);
            }
        }
        return null;
    }

    public void deletePickupableItemFromList(PickupableItem item) {
        getListOfPickupableItems().remove(item);
    }
    public void deleteStaticItemFromList(StaticItem item) {
        getListOfStaticItems().remove(item);
    }
    public void addPickupableItemToList(PickupableItem item) {
        getListOfPickupableItems().add(item);
    }
    public void addStaticItemToList(StaticItem item) {
        getListOfStaticItems().add(item);
    }
}

