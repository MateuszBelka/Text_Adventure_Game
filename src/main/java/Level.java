import java.util.ArrayList;
import java.util.List;

public class Level {

    private static List<Room> listOfRooms = new ArrayList<>();
    private static int puzzlesLeftToSolve;

    /*
    public static void constructor(int amountOfPuzzlesToSolve) {
        while (amountOfPuzzlesToSolve > 0) {            //while amount of puzzles to solve > 0 -> continue on level
                                                        //otherwise isCompleted()
            amountOfPuzzlesToSolve = puzzlesLeftToSolve;
                                                        //Text about level - will Be about info when player enters.
                                                        // Mario levels: basic level
                                                        //Underground - 2nd level. Story text.
                                                        //Story text : bonus story creator
        }
    }
    */

    public static void addRoomToList() {
                                            //how do we do that? - within the parameter, you get room and
                                            //it has to be added to list of rooms
                                            //List.add(room)

    }
    public static void decreasePuzzlesLeftToSolve() {
                                            //if number of puzzles left to solve at the end of the puzzle is
                                            // smaller than amount of puzzle to solve before solved puzzle
        puzzlesLeftToSolve -= 1;
    }
    public static boolean isCompleted() {
        return puzzlesLeftToSolve == 0;
    }
    public static String getTextAboutLevel() {
        return "blablabla";
    }

    //Can be deleted later public : static String print() {
        //return String.format(getTextAboutLevel());
    //}
}