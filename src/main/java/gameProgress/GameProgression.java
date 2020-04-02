package gameProgress;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Level;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import output.InteractionPrinter;
import ui.UI;

import java.io.IOException;

public class GameProgression {
    public static void checkLevelProgression() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        if (PuzzleProgression.getPuzzlesSolvedCount() == player.getCurrentLevel().getTotalPuzzleCount()) {
            progressLevel();
        }
    }

    private static void progressLevel() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        if (isGameCompleted()) {
            printGameCompleted();
        } else {
            player.setCurrentLevel(player.getCurrentLevel().getNextLevel());
            player.setCurrentLocation(player.getCurrentLevel().getStartLocation());
            PuzzleProgression.resetPuzzlesSolvedCount();
            InteractionPrinter.print("Congratulations! You've made it to next step of your journey!");
            BattleSequence.shouldPlayerEnterCombat();
        }
    }

    public static boolean isGameCompleted() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        Level currentLevel = player.getCurrentLevel();
        return (currentLevel.getNextLevel() == null &&
                PuzzleProgression.getPuzzlesSolvedCount() == currentLevel.getTotalPuzzleCount());
    }

    private static void printGameCompleted() {
        BattleSequence.setCurrentEnemy(null);
        InteractionPrinter.print("You finished the game! Congratulations!");
        InteractionPrinter.print("Type <Quit> to close the game or <Menu> to start again!");
    }

    public static void inputValidationAfterGameOver(String input, ActionEvent actionEvent) throws IOException {
        switch(input) {
            case "Quit":
                Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                primaryStage.close();
                break;
            case "Menu":
                UI.changeToNewScene("/fxml/welcome.fxml", actionEvent);
                break;
            default:
                InteractionPrinter.print("Unexpected input!");
                InteractionPrinter.print("Type <Quit> to close the game or <Menu> to start again!");
        }
    }
}
