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

    public static void addXPReward() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        final int newCurrentXP = playerStats.getCurrentXP() + getXpReward();

        NonStoryPrinter.print("You receive " + getXpReward() + " XP!");
        if (playerStats.getMaximumXP() > newCurrentXP) {
            playerStats.setCurrentXP(newCurrentXP);
        } else {
            // Don't increase players level is they hit max lvl
            if (playerStats.getMaxPlayerLevel() > playerStats.getPlayerLevel()) {
                // Add leftover xp to new level
                playerStats.setCurrentXP(newCurrentXP - playerStats.getMaximumXP());

                // Increment Player level
                incrementPlayerLevel();

                // Scale stats for level up
                levelUPScaling();
            }
        }
    }

    private static void incrementPlayerLevel() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setPlayerLevel(playerStats.getPlayerLevel() + 1);
        NonStoryPrinter.print("You reached level " + playerStats.getPlayerLevel());
    }

    private static void levelUPScaling() {
        increaseMaximumXP();
        increaseXPReward();
        increaseMaximumHP();
        increaseDamage();
    }

    private static void increaseMaximumHP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setMaxHealth((int) Math.round(playerStats.getMaxHealth() * 1.2));
    }

    private static void increaseDamage() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setDamage((int) Math.round(playerStats.getDamage() * 1.2));
    }

    private static void increaseXPReward() {
        setXpReward((int) Math.round(getXpReward() * 1.1));
    }

    private static void increaseMaximumXP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setMaximumXP((int) Math.round(playerStats.getMaximumXP() * 1.2));
    }
}
