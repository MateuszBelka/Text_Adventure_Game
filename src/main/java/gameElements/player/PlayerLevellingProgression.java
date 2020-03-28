package gameElements.player;

import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

//todo: increaseCurrentXP on puzzle completion
public class PlayerLevellingProgression {

    private static int xpReward = 10;

    public static int getXpReward() {
        return xpReward;
    }
    public static void setXpReward(int xpReward) {
        PlayerLevellingProgression.xpReward = xpReward;
    }

    public static void increaseCurrentXP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        final int newCurrentXP = playerStats.getCurrentXP() + getXpReward();

        NonStoryPrinter.print("You receive " + getXpReward() + " XP!");
        if (playerStats.getMaximumXP() > newCurrentXP) {
            playerStats.setCurrentXP(newCurrentXP);
        }
        else {
            if (playerStats.getMaxPlayerLevel() > playerStats.getPlayerLevel()) {
                playerStats.setCurrentXP(newCurrentXP - playerStats.getMaximumXP());
                incrementPlayerLevel();
                increaseMaximumXP();
            }
        }

        setXpReward((int) Math.round(getXpReward() * 1.1));
    }
    private static void incrementPlayerLevel() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setPlayerLevel(playerStats.getPlayerLevel() + 1);
        NonStoryPrinter.print("You reached level " + playerStats.getPlayerLevel());
    }

    private static void increaseMaximumXP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setMaximumXP((int) Math.round(playerStats.getMaximumXP() * 1.2));
    }
}
