import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        Game game = init.getGames().get(0);
        Player player = game.getPlayer();
        InputValidator inputValidator = init.getInputValidators().get(0);
        StoryTextOutput storyTextOutput = init.getStoryTextOutputs().get(0);
        TextIO textIO = init.getTextIO();
        TextTerminal terminal = init.getTerminal();

        //main game loop
        while (!game.isCompleted() && init.getExitSwitch().equals(false)) {
            /* DEBUG MODE
             * System.out.println("******INFO FOR TESTING:******");
             * System.out.println("current room: " + player.getCurrentRoom());
             * System.out.println("current room directions: " + player.getCurrentRoom().getListOfAvailableDirections());
             * System.out.println("current room pickupable items: " + player.getCurrentRoom().getListOfPickupableItems());
             * System.out.println("current room static items: " + player.getCurrentRoom().getListOfStaticItems());
             * System.out.println("player inventory: " + player.getInventory().getItemsInInventory());
             * System.out.println("******StoryText:******");
             */
            storyTextOutput.printStoryText(player, terminal);
            String input = textIO.newStringInputReader().read("");
            inputValidator.validateInput(input, player, terminal);
        }
    }
}