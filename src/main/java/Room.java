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

    //tmp constructor
    public Room(){};

    //Get Methods
    // @M get methods are always public. They are read-only, and their reason of existence is so that we can call
    // them from outside this class.
    public ArrayList<String> getListOfAvailableDirections() {
        return listOfAvailableDirections;
    }
    public Room getNorth() {
        return north;
    }
    public Room getEast() {
        return east;
    }
    public Room getSouth() {
        return south;
    }
    public Room getWest() {
        return west;
    }
    public ArrayList<StaticItem> getListOfStaticItems() {
        return listOfStaticItems;
    }
    public ArrayList<PickupableItem> getListOfPickupableItems() {
        return listOfPickupableItems;
    }
    public Level getLevel() {
        return level;
    }
    public String getTextAboutRoom() {
        return textAboutRoom;
    }

    //Set Methods
    //@M I've changed these to public. We can check what needs to be private, after initialisation class is finished
    // (otherwise we can't test code)
    public void setListOfAvailableDirections(ArrayList<String> listOfAvailableDirections) {
        this.listOfAvailableDirections = listOfAvailableDirections;
    }
    public void setNorth(Room north) {
        this.north = north;
    }
    public void setEast(Room east) {
        this.east = east;
    }
    public void setSouth(Room south) {
        this.south = south;
    }
    public void setWest(Room west) {
        this.west = west;
    }
    public void setListOfStaticItems(ArrayList<StaticItem> listOfStaticItems) {
        this.listOfStaticItems = listOfStaticItems;
    }
    public void setListOfPickupableItems(ArrayList<PickupableItem> listOfPickupableItems) {
        this.listOfPickupableItems = listOfPickupableItems;
    }
    public void setLevel(Level level) {
        this.level = level;
    }
    public void setTextAboutRoom(String textAboutRoom) {
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

