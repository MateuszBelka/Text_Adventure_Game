package engine;

import gameElements.battle.BattleSequence;
import initialisation.InitOfStoryIndependentClasses;
import input.combatValidation.CombatValidation;
import input.validation.Validation;
import javafx.scene.control.TextArea;
import output.NonStoryPrinter;
import output.StoryTextPrinter;
import output.combat.CombatPrinter;
import ui.controllers.Adventure;

public class Engine {

    /*
     * Called when user loads up a game (both new and old save)
     * so that user doesn't see just an empty screen
     * we want them to see something printed on terminal
     */
    public static void initializeGameScene(TextArea terminal) {
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();

        StoryTextPrinter.printStory(terminal);
        adventure.updateUIElements();
    }

    /*
     * Responsible for moving the game forward; main loop of the game
     * Called automatically when user sends new input.
     * As such game is updated only as a response to user input.
     */
    public static void progressGame(String input, TextArea terminal) {
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
            // Update Game through Input Validation
            Validation.validator(input);

            // Output Printing
            StoryTextPrinter.printStory(terminal);
        }

        // Print unique text (non-Story and non-Combat)
        NonStoryPrinter.printToTerminal();

        // Update UI elements with new information
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();
        adventure.updateUIElements();
    }
}
