package gameElements.player;

public class PlayerHungerProgression {

    private transient PlayerStats playerStats;

    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    //called when a player did some action, for example move, action, etc. Exception: consumption
    protected void decreaseCurrentHunger() { playerStats.setCurrentHunger(playerStats.currentHunger - 10); }

    //called when a character consumed something
    protected void increaseCurrentHunger() { playerStats.setCurrentHunger(playerStats.currentHunger + 15); }

    //the type should be changed depending on implementation, probably boolean or string, not sure yet
    public void checkCurrentHunger() {
        if (playerStats.getCurrentHunger() <= 10 && playerStats.getCurrentHunger() > 0) {
            //return additional message that will warn a player character being close to starving
        }
        else if (playerStats.getCurrentHunger() == 0) {
            playerStats.setCurrentHealth(playerStats.currentHealth - 20);
            //return warning message that a character is starving and starts to lose health
        }
    }


}
