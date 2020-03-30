package gameProgress;

import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

public class PuzzleProgression {

    public static void resetPuzzlesSolvedCount() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setPuzzlesSolvedCount(0);
    }
    public static void incrementPuzzlesSolvedCount() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setPuzzlesSolvedCount(playerStats.getPuzzlesSolvedCount() + 1);
    }
    public static int getPuzzlesSolvedCount() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        return playerStats.getPuzzlesSolvedCount();
    }


    public static void incrementPuzzleCountAndGiveXPReward(){
        // Puzzle completed
        incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

}
