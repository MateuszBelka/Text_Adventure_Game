package engine;

import gameElements.battle.BattleSequence;
import initialisation.InitOfStoryIndependentClasses;
import input.validation.Validation;
import javafx.scene.control.TextArea;
import output.StoryTextPrinter;

public class Engine {

    /* Responsible for moving the game forward; main loop of the game
     * Called automatically when user sends new input.
     * As such game is updated only as a response to user input.
     */
    public static void progressGame(String input, TextArea terminal) {
        //Update Game through Input Validation
        Validation validation = InitOfStoryIndependentClasses.getValidation();
        validation.validator(input);

        //Player gets hit by enemy -- ONLY does something when it combat
        BattleSequence.enemyAttack();

        //Output Printing
        StoryTextPrinter.printStory(terminal);
    }
}
