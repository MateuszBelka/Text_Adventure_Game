package initialisation;

import ui.controllers.Adventure;

public class InitOfStoryIndependentClasses {
    private static Adventure adventure;

    public static Adventure getAdventure() {
        return adventure;
    }
    public static void setAdventure(Adventure adventure) { InitOfStoryIndependentClasses.adventure = adventure; }
}
