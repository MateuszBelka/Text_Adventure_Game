package gameElements.player;

import output.NonStoryPrinter;

public class PlayerHungerProgression {

    private transient PlayerStats playerStats;

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    //called when a player did some action, for example move, action, etc. Exception: consumption
    protected void decreaseCurrentHunger() { playerStats.setCurrentHunger(Math.max(playerStats.getCurrentHunger() - playerStats.getHungerDrain(), 0)); }

    //called when a character consumed something
    protected void eatFoodHungerHealthIncrease() {
        playerStats.setCurrentHunger(Math.min(playerStats.getCurrentHunger() + playerStats.getFoodHungerIncrease(), playerStats.getMaxHunger()));
        playerStats.setCurrentHealth(Math.min(playerStats.getCurrentHealth() + playerStats.getFoodHealthIncrease(), playerStats.getMaxHealth()));
    }

    //the type should be changed depending on implementation, probably boolean or string, not sure yet
    public void checkCurrentHunger() {
        if (playerStats.getCurrentHunger() <= 10 && playerStats.getCurrentHunger() > 0) {
            //return additional message that will warn a player character being close to starving
            NonStoryPrinter.print("Be careful! You are getting hungry.");
        }
        else if (playerStats.getCurrentHunger() == 0) {
            playerStats.setCurrentHealth(Math.max(playerStats.getCurrentHealth() - playerStats.getHungerDamage(), 0));
            //return warning message that a character is starving and starts to lose health
            NonStoryPrinter.print("You have lost " + playerStats.getHungerDamage() + " health points due to hunger!");
            NonStoryPrinter.print("You are starving! Eat something.");
        }
    }


}
