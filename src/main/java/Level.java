import java.util.ArrayList;

public class Level {
    //Variable Declaration
    private ArrayList<Room> listOfRooms;
    private int puzzlesLeftToSolve;
    private String storyText;
    private Boolean enterLevel = true;

    //Get Methods
    public ArrayList<Room> getListOfRooms() { return listOfRooms; }
    public int getPuzzlesLeftToSolve() { return puzzlesLeftToSolve; }
    public String getTextAboutLevel() { return storyText; }

    //Set Methods
    public void setListOfRooms(ArrayList<Room> listOfRooms) { this.listOfRooms = listOfRooms; }
    public void updatePuzzlesLeftToSolve() { //puzzles left to solve in the room
        puzzlesLeftToSolve = 0;
        for (Room room : getListOfRooms()) {
            puzzlesLeftToSolve += room.getListOfStaticItems().size();
        }
    }
    public void setStoryText(String storyText) {this.storyText = storyText; }
    public boolean switchEnterLevel(){ //entering a new level
        if (enterLevel.equals(true)){
            enterLevel = false;
            return true;
        }
        return enterLevel;
    }

    //Main Methods
    public void addRoomToList(Room roomToAdd) { listOfRooms.add(roomToAdd); }
    public void decreasePuzzlesLeftToSolve() { puzzlesLeftToSolve -= 1; }
    public boolean isCompleted() { return puzzlesLeftToSolve == 0; }

}