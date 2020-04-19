package gameElements.player;

import gameElements.battle.BattleSequence;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class PlayerHealthProgression {

    //called when a character consumed something
    public static void eatFoodHealthIncrease() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.setCurrentHealth(Math.min(player.getCurrentHealth() + player.getFoodHealthIncrease(), player.getMaxHealth()));
    }

    public static boolean isDead() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        return (player.getCurrentHealth() < 0);
    }

    public static void printDeath() {
        BattleSequence.setCurrentEnemy(null);
        InteractionPrinter.print("You are dead!");
        InteractionPrinter.print("Type <Quit> to close the game or <Menu> to start again!");
    }

}
