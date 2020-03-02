import java.util.ArrayList;

/*
 * It should not be necessary to change any variable from private to public.
 * The GetSet Methods provide this functionality.
 * If you need one of them in your class, you can switch the specific method to public.
 */

public class Game {
    //Variable Declarations
    private ArrayList<Level> listOfLevels;
    private int levelsLeftToSolve;

    //Constructor
    public Game(ArrayList<Level> listOfLevels,
                int levelsLeftToSolve) {
        this.listOfLevels = listOfLevels;
        this.levelsLeftToSolve = levelsLeftToSolve;
    }

    //tmp constructor
    public Game(){};

    //Get Methods
    // @M get methods are always public. They are read-only, and their reason of existence is so that we can call
    // them from outside this class.
    public ArrayList<Level> getListOfLevels() {
        return listOfLevels;
    }
    public int getLevelsLeftToSolve() {
        return levelsLeftToSolve;
    }

    //Set Methods
    //@M I've changed these to public. We can check what needs to be private, after initialisation class is finished
    // (otherwise we can't test code)
    public void setListOfLevels(ArrayList<Level> listOfLevels) {
        this.listOfLevels = listOfLevels;
    }
    public void setLevelsLeftToSolve(int levelsLeftToSolve) {
        this.levelsLeftToSolve = levelsLeftToSolve;
    }


    //Main Methods
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
