package engine;

import gameElements.battle.BattleSequence;
import gameElements.player.PlayerHealthProgression;
import gameElements.player.PlayerHungerProgression;
import gameElements.player.PlayerStats;
import gameProgress.GameProgression;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStoryIndependentClasses;
import input.combatValidation.CombatValidation;
import input.commands.DoGoToMenu;
import input.commands.DoSave;
import input.validation.Validation;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import output.InteractionPrinter;
import output.DescriptionPrinter;
import output.UserInputPrinter;
import output.CombatPrinter;
import ui.controllers.Adventure;

import java.io.IOException;
import java.net.URISyntaxException;

public class Engine {
    private static int inputsUntilAutoSave = 5;

    public static int getInputsUntilAutoSave() {
        return inputsUntilAutoSave;
    }
    public static void setInputsUntilAutoSave(int inputsUntilAutoSave) {
        Engine.inputsUntilAutoSave = inputsUntilAutoSave;
    }

    /*
     * Called when user loads up a game (both new and old save)
     * so that user doesn't see just an empty screen
     * we want them to see something printed on terminal
     */
    public static void initializeGameScene(TextArea terminal) {
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();

        DescriptionPrinter.printStory(terminal);
        InteractionPrinter.printToTerminal();
        adventure.updateUIElements();
    }

    /*
     * Responsible for moving the game forward; main loop of the game
     * Called automatically when user sends new input.
     * As such game is updated only as a response to user input.
     *
     * ActionEvent is necessary to quit UI or switch scenes
     */
    public static void progressGame(String input, TextArea terminal, ActionEvent actionEvent) throws IOException, URISyntaxException {
        // Forward user input to terminal
        UserInputPrinter.printUserInput(input);


        //debug
        InteractionPrinter.print(Integer.toString(InitOfClassesThroughSaveFile.getPlayerStats().getPuzzlesSolvedCount()));

        if (!PlayerHealthProgression.isDead()) {
            /*
             * We analyse and process information differently when player is in combat
             * As in different inputs are allowed and we print different information
             */
            if (BattleSequence.inCombat()) {
                // Update Game through Input Validation
                CombatValidation.validator(input);

                // Player gets hit by enemy -- ONLY does something when it combat
                BattleSequence.enemyAttack();

                // Output Printing
                CombatPrinter.printCombat();
            } else {
                // Check if game should be auto-saved
                autoSaveCheck();

                boolean isGameCompletedBeforeUserInput = GameProgression.isGameCompleted();

                // Update Game through Input Validation
                Validation.validator(input.toUpperCase(), actionEvent);

                // Check if player has finished the current level
                if (!isGameCompletedBeforeUserInput) GameProgression.checkLevelProgression();

                // Output Printing
                DescriptionPrinter.printStory(terminal);
            }

            // Check hunger level and decrease health if necessary
            PlayerHungerProgression.checkCurrentHunger();
        } else {
            // Death Scenario
            switch (input) {
                case "menu":
                    DoGoToMenu.doGoToMenu(actionEvent);
                case "quit":
                    Stage primaryStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    primaryStage.close();
            }
            PlayerHealthProgression.printDeath();
        }

        // Print unique text (non-Story and non-Combat)
        InteractionPrinter.printToTerminal();


        // Update UI elements with new information
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();
        adventure.updateUIElements();
    }

    private static void autoSaveCheck() throws URISyntaxException {
        // Auto Save every 5th input
        if (getInputsUntilAutoSave() == 0) {
            DoSave.doAutoSave();
            setInputsUntilAutoSave(5);
        } else {
            setInputsUntilAutoSave(getInputsUntilAutoSave() - 1);
        }
    }
}
