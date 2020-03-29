package gameProgress;

import gameElements.battle.BattleSequence;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import output.NonStoryPrinter;
import ui.UI;

import java.io.IOException;

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

    public static void gameEndedScenario(String input, ActionEvent actionEvent) throws IOException {
        switch(input) {
            case "Quit":
                Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                primaryStage.close();
                break;
            case "Menu":
                //todo: clear all vars if possible
                UI.changeToNewScene("/fxml/welcome.fxml", actionEvent);
                break;
            default:
                NonStoryPrinter.print("Unexpected input!");
                NonStoryPrinter.print("Type <Quit> to close the game or <Menu> to start again!");
        }
    }
}
