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


    //Getter + Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public ArrayList<Integer> getListOfItemsIDs() {
        return listOfItemsIDs;
    }

    public void setListOfItemsIDs(ArrayList<Integer> listOfItemsIDs) {
        this.listOfItemsIDs = listOfItemsIDs;
    }

    public ArrayList<NPC> getListOfNPCs() {
        return listOfNPCs;
    }

    public void setListOfNPCs(ArrayList<NPC> listOfNPCs) {
        this.listOfNPCs = listOfNPCs;
    }

    public ArrayList<Integer> getListOfNPCsIDs() {
        return listOfNPCsIDs;
    }

    public void setListOfNPCsIDs(ArrayList<Integer> listOfNPCsIDs) {
        this.listOfNPCsIDs = listOfNPCsIDs;
    }

    public HashMap<String, Location> getListOfConnectedLocations() {
        return listOfConnectedLocations;
    }

    public void setListOfConnectedLocations(HashMap<String, Location> listOfConnectedLocations) {
        this.listOfConnectedLocations = listOfConnectedLocations;
    }

    public HashMap<String, Integer> getListOfConnectedLocationsIDs() {
        return listOfConnectedLocationsIDs;
    }

    public void setListOfConnectedLocationsIDs(HashMap<String, Integer> listOfConnectedLocationsIDs) {
        this.listOfConnectedLocationsIDs = listOfConnectedLocationsIDs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextForListening() {
        return textForListening;
    }

    public void setTextForListening(String textForListening) {
        this.textForListening = textForListening;
    }

    public String getTextForSmelling() {
        return textForSmelling;
    }

    public void setTextForSmelling(String textForSmelling) {
        this.textForSmelling = textForSmelling;
    }

    public Boolean getFirstTimeEnteringLocation() {
        return firstTimeEnteringLocation;
    }

    public void setFirstTimeEnteringLocation(Boolean firstTimeEnteringLocation) {
        this.firstTimeEnteringLocation = firstTimeEnteringLocation;
    }

    public void addItemToList(Item item) { listOfItems.add(item); }

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLocation.equals(true)){
            firstTimeEnteringLocation = false;
            return true;
        }
        return firstTimeEnteringLocation;
    }










}
