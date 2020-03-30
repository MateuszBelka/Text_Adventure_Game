package input.commands;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Location;
import gameElements.player.PlayerHungerProgression;
import initialisation.InitOfClassesThroughSaveFile;

public class DoMove {
    public static void doMove (Location location){
        //changes current location of player to moved location.
        InitOfClassesThroughSaveFile.getPlayerStats().addLocationToMovedLocationsList(location);
        InitOfClassesThroughSaveFile.getPlayerStats().setCurrentLocation(location);

        // Hunger Drain due to action
        PlayerHungerProgression.decreaseCurrentHunger();

        // Commences battle if new location contains an enemy npc.
        BattleSequence.shouldPlayerEnterCombat();
    }

    private DoMove(){} //hiding the implicit public constructor
}
