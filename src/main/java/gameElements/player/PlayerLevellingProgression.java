package gameElements.player;

public class PlayerLevellingProgression {
    private transient PlayerStats playerStats;

    //Get Methods
    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    //Set Methods
    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }

    public void increaseCurrentXP() {
        final int increaseCurrentXPby = playerStats.getMaximumXP() / (playerStats.getPlayerLevel() * 30); //this //todo: ?
        final int newCurrentXP = playerStats.getCurrentXP() + increaseCurrentXPby;

        if (newCurrentXP < playerStats.getMaximumXP()) { //when updated xp < max xp
            playerStats.setCurrentXP(newCurrentXP);
        }
        else {
            playerStats.setCurrentXP(newCurrentXP- playerStats.getMaximumXP()); //when updated xp >= max xp
            playerStats.incrementPlayerLevel();
            playerStats.increaseMaximumXP();
        }
    }
}
