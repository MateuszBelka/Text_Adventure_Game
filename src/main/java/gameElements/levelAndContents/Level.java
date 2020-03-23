package gameElements.levelAndContents;

import java.util.ArrayList;

public class Level {
    String description;
    String name;
    Boolean firstTimeEnteringLevel = true;
    Integer puzzles;
    Location startLocation;
    ArrayList<Location> listOfLocations;

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLevel.equals(true)){
            firstTimeEnteringLevel = false;
            return true;
        }
        return firstTimeEnteringLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setPuzzles(Integer puzzles) {
        this.puzzles = puzzles;
    }

    public Integer getPuzzles() {
        return puzzles;
    }

    public void decreasePuzzles(){
        puzzles--;
    }

    public String getName() {
        return name;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public ArrayList<Location> getListOfLocations() {
        return listOfLocations;
    }

    public void setListOfLocations(ArrayList<Location> listOfLocations) {
        this.listOfLocations = listOfLocations;
    }
}
