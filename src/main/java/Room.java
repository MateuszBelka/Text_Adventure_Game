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
    public Room(ArrayList<String> listOfAvailableDirections,
                Room north,
                Room east,
                Room south,
                Room west,
                ArrayList<StaticItem> listOfStaticItems,
                ArrayList<PickupableItem> listOfPickupableItems,
                Level level,
                String textAboutRoom) {
        this.listOfAvailableDirections = listOfAvailableDirections;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.listOfStaticItems = listOfStaticItems;
        this.listOfPickupableItems = listOfPickupableItems;
        this.level = level;
        this.textAboutRoom = textAboutRoom;
    }

    //Get Methods
    public ArrayList<String> getListOfAvailableDirections() {
        return listOfAvailableDirections;
    }
    private Room getNorth() {
        return north;
    }
    private Room getEast() {
        return east;
    }
    private Room getSouth() {
        return south;
    }
    private Room getWest() {
        return west;
    }
    private ArrayList<StaticItem> getListOfStaticItems() {
        return listOfStaticItems;
    }
    private ArrayList<PickupableItem> getListOfPickupableItems() {
        return listOfPickupableItems;
    }
    private Level getLevel() {
        return level;
    }
    private String getTextAboutRoom() {
        return textAboutRoom;
    }

    //Set Methods
    private void setListOfAvailableDirections(ArrayList<String> listOfAvailableDirections) {
        this.listOfAvailableDirections = listOfAvailableDirections;
    }
    private void setNorth(Room north) {
        this.north = north;
    }
    private void setEast(Room east) {
        this.east = east;
    }
    private void setSouth(Room south) {
        this.south = south;
    }
    private void setWest(Room west) {
        this.west = west;
    }
    private void setListOfStaticItems(ArrayList<StaticItem> listOfStaticItems) {
        this.listOfStaticItems = listOfStaticItems;
    }
    private void setListOfPickupableItems(ArrayList<PickupableItem> listOfPickupableItems) {
        this.listOfPickupableItems = listOfPickupableItems;
    }
    private void setLevel(Level level) {
        this.level = level;
    }
    private void setTextAboutRoom(String textAboutRoom) {
        this.textAboutRoom = textAboutRoom;
    }

    //Main Methods
    public void updateRoomDirections(Room north,
                                     Room east,
                                     Room south,
                                     Room west) {
        setNorth(north);
        setEast(east);
        setSouth(south);
        setWest(west);
    }

    public Room getRoomInDirection(String direction) {
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

    public void deletePickupableItemFromList(PickupableItem item) {
        getListOfPickupableItems().remove(item);
    }

    public void addPickupableItemToList(PickupableItem item) {
        getListOfPickupableItems().add(item);
    }

    public void addStaticItemToList(StaticItem item) {
        getListOfStaticItems().add(item);
    }
}

