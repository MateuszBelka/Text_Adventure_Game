package gameElements.levelAndContents;

import java.util.ArrayList;

public class Level {
    private int id;
    String description;
    String name;
    Boolean firstTimeEnteringLevel = true;
    Integer puzzles;
    private transient Location startLocation;
    private int startLocationID;
    private transient ArrayList<Location> listOfLocations;

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

    public Integer getPuzzles() {
        return puzzles;
    }

    public void setPuzzles() {
        //TODO
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

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLevel.equals(true)){
            firstTimeEnteringLevel = false;
            return true;
        }
        return firstTimeEnteringLevel;
    }

    public void decreasePuzzles(){
        puzzles--;
    }
}
