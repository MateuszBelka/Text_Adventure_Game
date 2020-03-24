package gameElements.levelAndContents;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    ArrayList<Item> listOfItems;
    ArrayList<NPC> listOfNPCs;
    HashMap<String, Location> listOfConnectedLocations;
    String description;
    String name;
    Boolean firstTimeEnteringLocation = true;

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLocation.equals(true)){
            firstTimeEnteringLocation = false;
            return true;
        }
        return firstTimeEnteringLocation;
    }

    public HashMap<String, Location> getListOfConnectedLocations() {
        return listOfConnectedLocations;
    }

    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public ArrayList<NPC> getListOfNPCs() {
        return listOfNPCs;
    }

    public String getDescription() {
        return description;
    }
}
