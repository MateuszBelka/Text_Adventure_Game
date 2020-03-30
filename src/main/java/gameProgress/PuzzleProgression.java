package gameProgress;

import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

public class PuzzleProgression {
    private static int puzzlesSolvedCount = 0;

    public static void resetPuzzlesSolvedCount() {
        puzzlesSolvedCount = 0;
    }
    public static void incrementPuzzlesSolvedCount() {
        puzzlesSolvedCount++;
    }
    public static int getPuzzlesSolvedCount() {
        return puzzlesSolvedCount;
    }


    public static void incrementPuzzleCountAndGiveXPReward(){
        // Puzzle completed
        incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

}
