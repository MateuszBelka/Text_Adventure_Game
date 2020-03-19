import ui.*;

public class Main {
    public static void main (String[] args) {
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        /* DEV NOTE:
         * Keep in mind that nothing after this line of code will be executed.
         * If you'd like some code to run you will have to do that through
         * UI controllers.
         */
        UI.run();
    }
}