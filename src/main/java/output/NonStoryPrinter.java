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

    private static ArrayList<String> getListToPrint() {
        return listToPrint;
    }
    private static void setListToPrint(ArrayList<String> listToPrint) {
        NonStoryPrinter.listToPrint = listToPrint;
    }

    /*
     * Use this method to print strings to terminal
     */
    public static void print(String newline) {
        getListToPrint().add(newline);
    }

    public static void printToTerminal() {
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();
        TextArea terminal = adventure.getTerminal();

        // Format and Print all gathered text to terminal
        if (!getListToPrint().isEmpty()) {
            terminal.appendText("\n");
            for (String lineOfText : getListToPrint()) {
                terminal.appendText(lineOfText + "\n");
            }
        }
        terminal.appendText("\n\n");

        // Clear text to print for next game loop
        setListToPrint(new ArrayList<>());
    }
}
