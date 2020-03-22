package gameElements.levelAndContents;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private int id;
    private transient ArrayList<Item> listOfItems;
    private ArrayList<Integer> listOfItemsIDs;
    private transient ArrayList<NPC> listOfNPCs;
    private ArrayList<Integer> listOfNPCsIDs;
    private transient HashMap<String, Location> listOfConnectedLocations;
    private HashMap<String, Integer> listOfConnectedLocationsIDs;
    String description;
    String name;
    Boolean firstTimeEnteringLocation = true;

    //Get Methods
    public int getId() {
        return id;
    }
    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }
    public ArrayList<Integer> getListOfItemsIDs() {
        return listOfItemsIDs;
    }
    public ArrayList<NPC> getListOfNPCs() {
        return listOfNPCs;
    }
    public ArrayList<Integer> getListOfNPCsIDs() {
        return listOfNPCsIDs;
    }
    public HashMap<String, Location> getListOfConnectedLocations() {
        return listOfConnectedLocations;
    }
    public HashMap<String, Integer> getListOfConnectedLocationsIDs() {
        return listOfConnectedLocationsIDs;
    }
    public String getDescription() {
        return description;
    }

    //Set Methods
    public void setId(int id) {
        this.id = id;
    }
    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }
    public void setListOfNPCs(ArrayList<NPC> listOfNPCs) {
        this.listOfNPCs = listOfNPCs;
    }
    public void setListOfConnectedLocations(HashMap<String, Location> listOfConnectedLocations) {
        this.listOfConnectedLocations = listOfConnectedLocations;
    }

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLocation.equals(true)){
            firstTimeEnteringLocation = false;
            return true;
        }
        return firstTimeEnteringLocation;
    }










}
