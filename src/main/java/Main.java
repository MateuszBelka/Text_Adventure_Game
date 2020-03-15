import UI.*;

public class Main {
    public static void main (String[] args) {
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        UI.run();
    }
}