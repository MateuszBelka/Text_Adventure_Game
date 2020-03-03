import java.util.ArrayList;

public class Level {

    private ArrayList<Room> listOfRooms;
    private int puzzlesLeftToSolve;
    private String storyText;
    //Constructor
    public Level(){}
    public Level(ArrayList<Room> listOfRooms,
          int amountOfPuzzlesLeftToSolve,
          String storyText) {
        this.listOfRooms = listOfRooms;
        this.puzzlesLeftToSolve = amountOfPuzzlesLeftToSolve;
        this.storyText = storyText;
    }

    public void addRoomToList(Room roomToAdd) {
        listOfRooms.add(roomToAdd);
    }
    public void decreasePuzzlesLeftToSolve() {
        puzzlesLeftToSolve -= 1;
    }
    public boolean isCompleted() {
        return puzzlesLeftToSolve == 0;
    }
    public String getTextAboutLevel() {
        return storyText;
    }
}