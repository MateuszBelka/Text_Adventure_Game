import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;

public class Main {
    public static void main (String[] args) {
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        Game game = init.getGames().get(0);
        Player player = game.getPlayer();
        InputValidator inputValidator = init.getInputValidators().get(0);
        StoryTextOutput storyTextOutput = init.getStoryTextOutputs().get(0);
        TextIO textIO = init.getTextIO();
        TextTerminal<SwingTextTerminal> terminal = init.getTerminal();

        //main game loop
        terminal.printf("(GAME DEMO)   (tip: you can type 'exit' at any time)\n");
        while (!game.isCompleted() && init.getExitSwitch().equals(false)) {
            storyTextOutput.setAndPrintAndClearStoryText(player, terminal);
            String input = textIO.newStringInputReader().read("");
            if (input.equals("exit")) { init.setExitSwitch(true); }
            inputValidator.validateInput(input, player, terminal);
            if (player.getCurrentLevel().isCompleted()){ player.progressPlayer(init, terminal); }
        }
        terminal.abort();
    }
}