/*
 * We've decided to change our project structure to utilize
 * packages for Assignment 3.
 *
 * The following file is temporary and will be removed
 * when it's functionality is copied by corresponding new file.
 *
 * Due to this work in progress currently only UI part of our code fully works.
 * That includes initial framework for IO.
 */

import java.util.ArrayList;

public class Level {
    //Variable Declaration
    private ArrayList<Room> listOfRooms = new ArrayList<>();
    private int puzzlesLeftToSolve;
    private String storyText;
    private Boolean enterLevel = true;

    //Get Methods
    //returns the list of the rooms on the level
    public ArrayList<Room> getListOfRooms() { return listOfRooms; }
    //returns an integer of puzzles left to solve on the level
    public int getPuzzlesLeftToSolve() { return puzzlesLeftToSolve; }
    //returns a description about the level
    public String getTextAboutLevel() { return storyText; }

    //Set Methods
    //setting the list of rooms on the level
    public void setListOfRooms(ArrayList<Room> listOfRooms) { this.listOfRooms = listOfRooms; }
    //sets number of puzzles left to solve depending on the number of static items per room
    public void updatePuzzlesLeftToSolve() {
        puzzlesLeftToSolve = 0;
        for (Room room : getListOfRooms()) {
            puzzlesLeftToSolve += room.getListOfStaticItems().size();
        }
    }
    //setting the story description of a level
    public void setStoryText(String storyText) {this.storyText = storyText; }
    //setting a boolean variable enterLevel to true when a new level is entered
    public boolean switchEnterLevel(){
        if (enterLevel.equals(true)){
            enterLevel = false;
            return true;
        }
        return enterLevel;
    }

    //Main Methods
    //The method used for game-creator mode when a creator has an option to add a room to his level
    public void addRoomToList(Room roomToAdd) { listOfRooms.add(roomToAdd); }
    //decrementing the number of puzzles left to solve
    public void decreasePuzzlesLeftToSolve() { puzzlesLeftToSolve -= 1; }
    //returns true when all puzzles are solved
    public boolean isCompleted() { return puzzlesLeftToSolve == 0; }
}