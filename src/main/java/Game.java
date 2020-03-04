import java.util.ArrayList;

/*
 * It should not be necessary to change any variable from private to public.
 * The GetSet Methods provide this functionality.
 * If you need one of them in your class, you can switch the specific method to public.
 */

public class Game {
    //Variable Declarations
    private Player player;
    private ArrayList<Level> listOfLevels;
    private int levelsLeftToSolve;

    //Constructors
    public Game(){}
    public Game(Player player,
                ArrayList<Level> listOfLevels,
                int levelsLeftToSolve) {
        this.player = player;
        this.listOfLevels = listOfLevels;
        this.levelsLeftToSolve = levelsLeftToSolve;
    }

    //Get Methods
    public Player getPlayer() {
        return player;
    }
    public ArrayList<Level> getListOfLevels() {
        return listOfLevels;
    }
    public int getLevelsLeftToSolve() {
        return levelsLeftToSolve;
    }

    //Set Methods
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setListOfLevels(ArrayList<Level> listOfLevels) {
        this.listOfLevels = listOfLevels;
    }
    public void setLevelsLeftToSolve() {
        int levelsLeftToSolve = 0;
        for (Level level : getListOfLevels()) {
            if (level.getPuzzlesLeftToSolve() != 0) levelsLeftToSolve += 1;
        }
        this.levelsLeftToSolve = levelsLeftToSolve;
    }

    //Main Methods
    public void addLevelToList(Level level) {
        getListOfLevels().add(level);
    }
    public void decreaseLevelsLeftToSolve(int valueToDecreaseBy) {
        this.levelsLeftToSolve -= valueToDecreaseBy;
    }

    //Game is completed if there are no more levels left to solve.
    public boolean isCompleted() {
        return getLevelsLeftToSolve() == 0;
    }
}
