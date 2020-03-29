package output;

import initialisation.InitOfStoryIndependentClasses;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import ui.controllers.Adventure;

public class UserInputPrinter {
    public static void printUserInput(String input) {
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();
        TextArea terminal = adventure.getTerminal();

        terminal.appendText("[>] " + input + "\n");
    }
}
