package output;

import initialisation.InitOfStoryIndependentClasses;
import javafx.scene.control.TextArea;
import ui.controllers.Adventure;

import java.util.ArrayList;

/*
 * Responsible for printing additional information after story text
 * as part of game logic you can call addToPrinting in order to have something printed to terminal
 */
public class NonStoryPrinter {
    private static ArrayList<String> listToPrint = new ArrayList<>();

    public static ArrayList<String> getListToPrint() {
        return listToPrint;
    }

    /*
     * Use this method to print strings to terminal
     */
    public static void addToPrinting(String newline) {
        getListToPrint().add(newline);
    }

    public static void printToTerminal() {
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();
        TextArea terminal = adventure.getTerminal();

        for (String lineOfText : getListToPrint()) {
            terminal.appendText(lineOfText + "\n");
        }
    }
}
