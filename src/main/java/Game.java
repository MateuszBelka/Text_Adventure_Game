import java.util.ArrayList;

public class Game {
    //Variable Declarations
    private Player player;
    private ArrayList<Level> listOfLevels;
    private int levelsLeftToSolve;

    //Get Methods
    public Player getPlayer() { return player; }
    public ArrayList<Level> getListOfLevels() { return listOfLevels; }
    public int getLevelsLeftToSolve() { return levelsLeftToSolve; }

    //Set Methods
    public void setPlayer(Player player) { this.player = player; }
    public void setListOfLevels(ArrayList<Level> listOfLevels) { this.listOfLevels = listOfLevels; }
    public void setLevelsLeftToSolve() { //determining how many levels are left to solve in order to complete the game
        levelsLeftToSolve = 0;
        for (Level level : getListOfLevels()) {
            if (level.getPuzzlesLeftToSolve() != 0) levelsLeftToSolve += 1;
        }
    }

    /*
     * Decrements the value of Game's attribute levelsLeftToSolve by 1 until it reaches 0.
     */
    public void decrementLevelsLeftToSolve() { if (levelsLeftToSolve > 0) levelsLeftToSolve -= 1; }

    /*
     * Returns whether the game is complete. A game is complete when there are no more levels that have unsolved puzzles.
     */
    public boolean isCompleted() { return getLevelsLeftToSolve() == 0; }
}
