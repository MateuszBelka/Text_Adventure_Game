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
    public void setListOfAvailableDirections(ArrayList<String> listOfAvailableDirections) { this.listOfAvailableDirections = listOfAvailableDirections; }
    public void setNorth(Room north) { this.north = north; }
    public void setEast(Room east) { this.east = east; }
    public void setSouth(Room south) { this.south = south; }
    public void setWest(Room west) { this.west = west; }
    public void setListOfStaticItems(ArrayList<StaticItem> listOfStaticItems) { this.listOfStaticItems = listOfStaticItems; }
    public void setListOfPickupableItems(ArrayList<PickupableItem> listOfPickupableItems) { this.listOfPickupableItems = listOfPickupableItems; }
    public void setLevel(Level level) { this.level = level; }
    public void setTextAboutRoom(String textAboutRoom) { this.textAboutRoom = textAboutRoom; }

    /*
     * Changes the room objects associated with the directions in which a player can move from the current room.
     * The method updates all four possible directions, so it shouldn't be used to update a single room object in any direction.
     * For that refer to direction specific methods.
     */
    public void updateRoomDirections(Room north, //update of possible directions from the current room
                                     Room east,
                                     Room south,
                                     Room west) {
        setNorth(north);
        setEast(east);
        setSouth(south);
        setWest(west);
    }

    /*
     * Update the list of all possible directions a player could move from the current room,
     * given that the room has information about adjecent rooms.
     */
    public void updateListOfAvailableDirectionsUsingRooms() {
        // Reinitialize array storing the list of direction a player can move from current room.
        listOfAvailableDirections = new ArrayList<>();

        if (getNorth() != null) listOfAvailableDirections.add("north");
        if (getEast() != null) listOfAvailableDirections.add("east");
        if (getSouth() != null) listOfAvailableDirections.add("south");
        if (getWest() != null) listOfAvailableDirections.add("west");
    }

    /*
     * Returns the room object associated with the requested direction.
     */
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

    /*
     * Returns the PickupableItem object (given by name) which currently occupies current room.
     * If there is no PickupableItem by that name in the room, it returns nothing.
     */
    public PickupableItem getPickupableItemByName(String name) { //return name of pickupable item
        for (int i = 0; i < getListOfPickupableItems().size(); i++){
            if (getListOfPickupableItems().get(i).getName().equals(name)){
                return getListOfPickupableItems().get(i);
            }
        }
        return null;
    }

    /*
     * Returns the StaticItem object (given by name) which currently occupies current room.
     * If there is no StaticItem by that name in the room, it returns nothing.
     */
    public StaticItem getStaticItemByName(String name) { //return name of the static item
        for (int i = 0; i < getListOfStaticItems().size(); i++){
            if (getListOfStaticItems().get(i).getName().equals(name)){
                return getListOfStaticItems().get(i);
            }
        }
        return null;
    }

    /*
     * Removes given PickupableItem from the list of PickupableItems which are in the current room.
     */
    public void deletePickupableItemFromList(PickupableItem item) { getListOfPickupableItems().remove(item); }

    /*
     * Removes given StaticItem from the list of StaticItems which are in the current room.
     */
    public void deleteStaticItemFromList(StaticItem item) { getListOfStaticItems().remove(item); }

    /*
     * Adds given PickupableItem from the list of PickupableItems which are in the current room.
     */
    public void addPickupableItemToList(PickupableItem item) { getListOfPickupableItems().add(item); }

    /*
     * Adds given StaticItems from the list of StaticItems which are in the current room.
     */
    public void addStaticItemToList(StaticItem item) { getListOfStaticItems().add(item); }
}

