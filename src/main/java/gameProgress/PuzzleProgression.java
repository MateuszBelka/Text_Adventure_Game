package gameProgress;

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
}
