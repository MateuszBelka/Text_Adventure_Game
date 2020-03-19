import ui.*;
import ui.controllers.Adventure;

public class Main {
    public static void main (String[] args) {
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        UI.run();
    }
}