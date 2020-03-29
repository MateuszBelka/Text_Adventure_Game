package input.commands;

import gameElements.player.PlayerHungerProgression;
import initialisation.InitOfClassesThroughSaveFile;

public class DoBack {
    public static void doBack() {
        // Reduce player hunger as a result of conducting an action
        PlayerHungerProgression.decreaseCurrentHunger();

        // Change player location to previous one
        InitOfClassesThroughSaveFile.getPlayerStats().setCurrentLocationToPreviousLocation();
    }
}