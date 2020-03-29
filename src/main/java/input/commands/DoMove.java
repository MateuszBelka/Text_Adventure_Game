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
        // Commences battle if new location contains an enemy npc.
        InitOfClassesThroughSaveFile.getPlayerStats().addLocationToMovedLocationsList(location);
        InitOfClassesThroughSaveFile.getPlayerStats().setCurrentLocation(location);
        PlayerHungerProgression.decreaseCurrentHunger();

        BattleSequence.shouldPlayerEnterCombat();
    }
}
