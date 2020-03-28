package gameElements.player;

import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class PlayerHungerProgression {

    //called when a player did some action, for example move, action, etc. Exception: consumption
    protected void decreaseCurrentHunger() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.setCurrentHunger(Math.max(player.getCurrentHunger() - player.getHungerDrain(), 0));
    }

    //called when a character consumed something
    protected void eatFoodHungerHealthIncrease() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.setCurrentHunger(Math.min(player.getCurrentHunger() + player.getFoodHungerIncrease(), player.getMaxHunger()));
        player.setCurrentHealth(Math.min(player.getCurrentHealth() + player.getFoodHealthIncrease(), player.getMaxHealth()));
    }

    //the type should be changed depending on implementation, probably boolean or string, not sure yet
    public void checkCurrentHunger() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        if (player.getCurrentHunger() <= 10 && player.getCurrentHunger() > 0) {
            //return additional message that will warn a player character being close to starving
            NonStoryPrinter.print("Be careful! You are getting hungry.");
        }
        else if (player.getCurrentHunger() == 0) {
            player.setCurrentHealth(Math.max(player.getCurrentHealth() - player.getHungerDamage(), 0));
            //return warning message that a character is starving and starts to lose health
            NonStoryPrinter.print("You have lost " + player.getHungerDamage() + " health points due to hunger!");
            NonStoryPrinter.print("You are starving! Eat something.");
        }
    }


}
