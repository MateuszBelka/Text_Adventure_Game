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
    private String description;
    private String name;
    private String textForListening;
    private String textForSmelling;

    Boolean firstTimeEnteringLocation = true;

    //Get Methods
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
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

    public void addItemToList(Item item) { listOfItems.add(item); }

    public String getTextForListening() { return textForListening; }

    public String getTextForSmelling() {
        return textForSmelling;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTextForSmelling(String textForSmelling) {
        this.textForSmelling = textForSmelling;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTextForListening(String textForListening) {
        this.textForListening = textForListening;
    }

    //Set Methods
    public void setId(int id) {
        this.id = id;
    }
    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }
    public void setListOfItemsIDs(ArrayList<Integer> listOfItemsIDs) {
        this.listOfItemsIDs = listOfItemsIDs;
    }
    public void setListOfNPCs(ArrayList<NPC> listOfNPCs) {
        this.listOfNPCs = listOfNPCs;
    }
    public void setListOfNPCsIDs(ArrayList<Integer> listOfNPCsIDs) {
        this.listOfNPCsIDs = listOfNPCsIDs;
    }
    public void setListOfConnectedLocations(HashMap<String, Location> listOfConnectedLocations) {
        this.listOfConnectedLocations = listOfConnectedLocations;
    }
    public void setListOfConnectedLocationsIDs(HashMap<String, Integer> listOfConnectedLocationsIDs) {
        this.listOfConnectedLocationsIDs = listOfConnectedLocationsIDs;
    }

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLocation.equals(true)){
            firstTimeEnteringLocation = false;
            return true;
        }
        return firstTimeEnteringLocation;
    }










}
