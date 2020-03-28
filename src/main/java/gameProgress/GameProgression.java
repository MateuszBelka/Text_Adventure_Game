package gameProgress;

import gameElements.battle.BattleSequence;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class GameProgression {
    public static void checkLevelProgression() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        if (player.getCurrentLevel().getPuzzlesSolvedCount() == player.getCurrentLevel().getTotalPuzzleCount()) {
            progressLevel();
        }
    }

    private static void progressLevel() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        if (gameCompleted()) {
            printGameCompleted();
        } else {
            player.setCurrentLevel(player.getCurrentLevel().getNextLevel());
            player.setCurrentLocation(player.getCurrentLevel().getStartLocation());
            NonStoryPrinter.print("Congratulations! You've made it to next step of your journey!");
        }
    }

    public static boolean gameCompleted() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        return player.getCurrentLevel().getNextLevel() == null;
    }

    private static void printGameCompleted() {
        BattleSequence.setCurrentEnemy(null);
        NonStoryPrinter.print("You finished the game! Congratulations!");
        NonStoryPrinter.print("Type <Quit> to close the game or <Menu> to start again!");
    }
}
