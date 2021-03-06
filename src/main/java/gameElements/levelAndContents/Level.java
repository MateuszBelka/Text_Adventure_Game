package gameElements.levelAndContents;

import java.util.ArrayList;

public class Level {
    private int id;
    private String description;
    private String name;
    private Boolean firstTimeEnteringLevel = true;
    private transient Location startLocation;
    private int startLocationID;
    private transient ArrayList<Location> listOfLocations;
    private ArrayList<Integer> listOfLocationsIDs;
    private int totalPuzzleCount = 0;
    private transient Level nextLevel;
    private int nextLevelID;

    // Getter + Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public Boolean getFirstTimeEnteringLevel() {
        return firstTimeEnteringLevel;
    }
    public void setFirstTimeEnteringLevel(Boolean firstTimeEnteringLevel) {
        this.firstTimeEnteringLevel = firstTimeEnteringLevel;
    }
    public Location getStartLocation() {
        return startLocation;
    }
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }
    public int getStartLocationID() {
        return startLocationID;
    }
    public void setStartLocationID(int startLocationID) {
        this.startLocationID = startLocationID;
    }
    public ArrayList<Location> getListOfLocations() {
        return listOfLocations;
    }
    public void setListOfLocations(ArrayList<Location> listOfLocations) {
        this.listOfLocations = listOfLocations;
    }
    public ArrayList<Integer> getListOfLocationsIDs() {
        return listOfLocationsIDs;
    }
    public void setListOfLocationsIDs(ArrayList<Integer> listOfLocationsIDs) {
        this.listOfLocationsIDs = listOfLocationsIDs;
    }

    public int getTotalPuzzleCount() {
        return totalPuzzleCount;
    }
    public void setTotalPuzzleCount(int totalPuzzleCount) {
        this.totalPuzzleCount = totalPuzzleCount;
    }
    public Level getNextLevel() {
        return nextLevel;
    }
    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }
    public int getNextLevelID() {
        return nextLevelID;
    }
    public void setNextLevelID(int nextLevelID) {
        this.nextLevelID = nextLevelID;
    }

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLevel.equals(true)){
            firstTimeEnteringLevel = false;
            return true;
        }
        return firstTimeEnteringLevel;
    }
}
