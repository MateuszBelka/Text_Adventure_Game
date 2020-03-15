import UI.*;

public class Main {
    public static void main (String[] args) {
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        Game game = init.getGames().get(0);
        Player player = game.getPlayer();
        InputValidator inputValidator = init.getInputValidators().get(0);
        StoryTextOutput storyTextOutput = init.getStoryTextOutputs().get(0);

        UI.run();
    }
}