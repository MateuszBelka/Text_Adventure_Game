import java.util.ArrayList;

public class Game {
    //Variable Declarations
    private ArrayList<Level> listOfLevels;
    private int levelsLeftToSolve;

    //Constructor
    public Game(ArrayList<Level> listOfLevels, int levelsLeftToSolve) {
        this.listOfLevels = listOfLevels;
        this.levelsLeftToSolve = levelsLeftToSolve;
    }

    //Get Methods
    private ArrayList<Level> getListOfLevels() {
        return listOfLevels;
    }
    private int getLevelsLeftToSolve() {
        return levelsLeftToSolve;
    }

    //Set Methods
    private void setListOfLevels(ArrayList<Level> listOfLevels) {
        this.listOfLevels = listOfLevels;
    }
    private void setLevelsLeftToSolve(int levelsLeftToSolve) {
        this.levelsLeftToSolve = levelsLeftToSolve;
    }


    //Crucial Methods
    public void addLevelToList(Level level) {
        getListOfLevels().add(level);
    }

    public void decreaseLevelsLeftToSolve(int valueToDecreaseBy) {
        this.levelsLeftToSolve -= valueToDecreaseBy;
    }

    //Game of completed is there are no more levels left to solve.
    public boolean isCompleted() {
        return getLevelsLeftToSolve() == 0;
    }
}
