package saveAndLoad.meowManor;

import java.net.URISyntaxException;

public class CreateGame {
    /*
     * Only run once to create the json file with our demo.
     */
    public static void createGame() throws URISyntaxException {
        InitClasses.initEverything();
        ConfigureClasses.configureEverything();
        SerializeClasses.serializeGame();
    }
}
