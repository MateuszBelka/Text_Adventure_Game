import java.util.ArrayList;

public class Game {
    //Variable Declarations
    private Player player;
    private ArrayList<Level> listOfLevels;
    private int levelsLeftToSolve;

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
    public void setLevelsLeftToSolve() { //determining how many levels are left to solve in order to complete the game
        int levelsLeftToSolve = 0;
        for (Level level : getListOfLevels()) {
            if (level.getPuzzlesLeftToSolve() != 0) levelsLeftToSolve += 1;
        }
        this.levelsLeftToSolve = levelsLeftToSolve;
    }

    //Main Methods
    public void decreaseLevelsLeftToSolve(int valueToDecreaseBy) { this.levelsLeftToSolve -= valueToDecreaseBy; } //decreasing number of levels
                                                                                                                  // left to solve

    //Game is completed if there are no more levels left to solve.
    public boolean isCompleted() { return getLevelsLeftToSolve() == 0; }
}
