package gameElements.levelAndContents;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    ArrayList<Item> listOfItems;
    ArrayList<NPC> listOfNPCs;
    HashMap<String, Location> listOfConnectedLocations;



    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public ArrayList<NPC> getListOfNPCs() {
        return listOfNPCs;
    }
}
