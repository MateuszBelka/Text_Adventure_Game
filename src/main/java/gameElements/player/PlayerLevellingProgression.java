package gameElements.player;

import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class PlayerLevellingProgression {

    public static void addXPReward() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        final int newCurrentXP = playerStats.getCurrentXP() + playerStats.getXpReward();

        InteractionPrinter.print("You receive " + playerStats.getXpReward() + " XP!");
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
        InteractionPrinter.print("You reached level " + playerStats.getPlayerLevel());
    }

    private static void levelUPScaling() {
        increaseMaximumXP();
        increaseXPReward();
        increaseMaximumHP();
        increaseDamage();
    }

    private static void increaseMaximumHP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        int oldMaxHP = playerStats.getMaxHealth();
        playerStats.setMaxHealth((int) Math.round(playerStats.getMaxHealth() * 1.2));
        int hpDiff = playerStats.getMaxHealth() - oldMaxHP;
        playerStats.setCurrentHealth(playerStats.getCurrentHealth() + hpDiff);
    }

    private static void increaseDamage() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setDamage((int) Math.round(playerStats.getDamage() * 1.2));
    }

    private static void increaseXPReward() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setXpReward((int) Math.round(playerStats.getXpReward() * 1.1));
    }

    private static void increaseMaximumXP() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        playerStats.setMaximumXP((int) Math.round(playerStats.getMaximumXP() * 1.2));
    }
}
