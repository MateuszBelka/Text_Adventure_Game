import java.util.ArrayList;
import java.util.List;

public class Level {

    private static List<Room> listOfRooms = new ArrayList<>();
    private static int puzzlesLeftToSolve;
    private int amountOfPuzzlesLeftToSolve;
    private String nameOfTheFloor = "basic"; //not sure if this is the way to go for basic implementation.
    private String storyText;
    //Constructor
    public void constructor(int amountOfPuzzlesLeftToSolve,
                            String storyText) {
        storyText = String.format("You are on the %s level.", nameOfTheFloor);
        this.amountOfPuzzlesLeftToSolve = puzzlesLeftToSolve;
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
    //tmp
    public String print() {
        return getTextAboutLevel();
    }

}