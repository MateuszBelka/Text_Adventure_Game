package gameElements.levelAndContents;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private ArrayList<Item> listOfItems;
    private ArrayList<NPC> listOfNPCs;
    HashMap<String, Location> listOfConnectedLocations;
    private String description;
    private String name;
    private String textForListening;
    private String textForSmelling;

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

    public String getName() {
        return name;
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

    public void setListOfConnectedLocations(HashMap<String, Location> listOfConnectedLocations) {
        this.listOfConnectedLocations = listOfConnectedLocations;
    }

    public void setListOfNPCs(ArrayList<NPC> listOfNPCs) {
        this.listOfNPCs = listOfNPCs;
    }

    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public void setTextForListening(String textForListening) {
        this.textForListening = textForListening;
    }
}
