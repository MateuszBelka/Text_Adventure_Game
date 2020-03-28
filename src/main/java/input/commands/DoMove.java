package input.commands;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

import java.util.Random;

public class DoMove {
    public static void doMove (Location location){
        InitOfClassesThroughSaveFile.getPlayerStats().addLocationToMovedLocationsList(location);
        InitOfClassesThroughSaveFile.getPlayerStats().setCurrentLocation(location);

        //Check for combat
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        Random r = new Random();
        for (NPC enemy : player.getCurrentLocation().getListOfEnemyNPCs()) {
            int diceRoll0To100 = r.nextInt(101);
            if (enemy.getPercentChanceToShowUpAtLocationSwitch() >= diceRoll0To100) {
                BattleSequence.setCurrentEnemy(enemy);
                NonStoryPrinter.addToPrinting("A " + enemy.getName() + " saw you move and initiated a fight!");
                NonStoryPrinter.addToPrinting("Press [1] or [Attack] to defeat the foe!");
                break;
            }
        }
    }
}
