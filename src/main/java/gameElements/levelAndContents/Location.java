package gameElements.levelAndContents;

import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    private int id;
    private transient ArrayList<Item> listOfItems = new ArrayList<>();
    private ArrayList<Integer> listOfItemsIDs;
    private transient ArrayList<NPC> listOfFriendlyNPCs = new ArrayList<>();
    private ArrayList<Integer> listOfFriendlyNPCsIDs;
    private transient ArrayList<NPC> listOfEnemyNPCs = new ArrayList<>();
    private ArrayList<Integer> listOfEnemyNPCsIDs;
    private transient HashMap<String, Location> listOfConnectedLocations;
    private HashMap<String, Integer> listOfConnectedLocationsIDs;
    private String description;
    private String name;
    private String textForListening;
    private String textForSmelling;

    private Boolean firstTimeEnteringLocation = true;


    //Getter + Setter
    public void deleteItemInList(Item item){
        listOfItems.remove(item);
    }

    public void deleteFriendlyNPCInList(NPC npc){
        listOfFriendlyNPCs.remove(npc);
    }

    public void deleteEnemyNPCInList(NPC npc){
        listOfEnemyNPCs.remove(npc);
    }

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

    public ArrayList<NPC> getListOfFriendlyNPCs() {
        return listOfFriendlyNPCs;
    }

    public void setListOfFriendlyNPCs(ArrayList<NPC> listOfNPCs) {
        this.listOfFriendlyNPCs = listOfNPCs;
    }

    public ArrayList<Integer> getListOfFriendlyNPCsIDs() {
        return listOfFriendlyNPCsIDs;
    }

    public void setListOfFriendlyNPCsIDs(ArrayList<Integer> listOfFriendlyNPCsIDs) {
        this.listOfFriendlyNPCsIDs = listOfFriendlyNPCsIDs;
    }

    public ArrayList<NPC> getListOfEnemyNPCs() {
        return listOfEnemyNPCs;
    }

    public void setListOfEnemyNPCs(ArrayList<NPC> listOfEnemyNPCs) {
        this.listOfEnemyNPCs = listOfEnemyNPCs;
    }

    public ArrayList<Integer> getListOfEnemyNPCsIDs() {
        return listOfEnemyNPCsIDs;
    }

    public void setListOfEnemyNPCsIDs(ArrayList<Integer> listOfEnemyNPCsIDs) {
        this.listOfEnemyNPCsIDs = listOfEnemyNPCsIDs;
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
