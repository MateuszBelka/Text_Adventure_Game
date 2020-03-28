package gameElements.player;

import initialisation.InitOfClassesThroughSaveFile;

public class PlayerLevellingProgression {

    public void increaseCurrentXP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        final int increaseCurrentXPby = playerStats.getMaximumXP() / (playerStats.getPlayerLevel() * 30); //this //todo: ?
        final int newCurrentXP = playerStats.getCurrentXP() + increaseCurrentXPby;

        if (newCurrentXP < playerStats.getMaximumXP()) { //when updated xp < max xp
            playerStats.setCurrentXP(newCurrentXP);
        }
        else {
            playerStats.setCurrentXP(newCurrentXP - playerStats.getMaximumXP()); //when updated xp >= max xp
            incrementPlayerLevel();
            increaseMaximumXP();
        }
    }
    protected void incrementPlayerLevel() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setPlayerLevel(playerStats.getPlayerLevel() + 1);
    }

    protected void increaseMaximumXP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setMaximumXP(playerStats.getPlayerLevel() * playerStats.getMaximumXP());
    }
}
