import java.util.ArrayList;

public class Game {
    //Variable Declarations
    private ArrayList<Level> listOfLevels = new ArrayList<>();
    private int levelsLeftToSolve;

    //Constructor
    public Game() {
        //listOfLevels = ;
        levelsLeftToSolve = 0;
    }

    //GetSet Methods
    private ArrayList<Level> getListOfLevels() {
        return this.listOfLevels;
    }

    private int getLevelsLeftToSolve() {
        return this.levelsLeftToSolve;
    }

    private void setListOfLevels(ArrayList<Level> updated_ListOfLevels) {
        this.listOfLevels = updated_ListOfLevels;
    }

    private void setLevelsLeftToSolve(int updated_LevelsLeftToSolve) {
        this.levelsLeftToSolve = updated_LevelsLeftToSolve;
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
