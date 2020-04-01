import saveAndLoad.createDemoOne.CreateDemo;
import saveAndLoad.meowManor.CreateGame;
import ui.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        CreateGame.createGame();
        /* DEV NOTE:
         * Keep in mind that nothing after this line of code will be executed.
         * If you'd like some code to run you will have to do that through
         * UI controllers.
         */
        UI.run();
    }
}
