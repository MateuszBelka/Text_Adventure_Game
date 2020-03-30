package input.commands;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerHungerProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

import java.util.Random;

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
