package gameElements.battle;

import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

public class BattleSequence {
    /*
     * A battle is happening if there is an enemy
     * When a fight is started this variable will be assigned proper value
     * at the end of a fight it will be reset to null
     */
    private static NPC currentEnemy = null;

    public static NPC getCurrentEnemy() {
        return currentEnemy;
    }
    public static void setCurrentEnemy(NPC currentEnemy) {
        BattleSequence.currentEnemy = currentEnemy;
    }

    // Call when player changes rooms and there is enemy inside
    public static void initCombat(NPC enemy) {
        if (enemy.getCanAttack() && enemy.getCanBeAttacked()) setCurrentEnemy(enemy);
    }

    // Can be used to check if player is in combat at the moment
    public static boolean inCombat() { return currentEnemy != null;}

    // Call after player input is processed but before output is generated
    public static void enemyAttack() {
        /*
         * No need to inform the called about lack of attack
         * as no unique action is taken in such scenario
         */
        if (!inCombat()) return;
        int damage = getCurrentEnemy().getDamage();
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        // Inflict damage to player
        player.setCurrentHealth(Math.max(player.getCurrentHealth() - damage, 0));

        // If player is dead then set current enemy to null
        if (player.getCurrentHealth() <= 0) setCurrentEnemy(null);
    }

    /*
     * Called when player inputs attack command
     * returns 0 on successful attack and non-zero on unsuccessful
     */
    public static void playerAttack() {
        if (!inCombat() || !getCurrentEnemy().getCanBeAttacked()) return;
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        NPC enemy = getCurrentEnemy();

        int damage = player.getDamage();

        // Inflict damage on enemy
        enemy.setCurrentHealth(Math.max(enemy.getCurrentHealth() - damage, 0));

        // If enemy is dead then set current enemy to null
        if (enemy.getCurrentHealth() <= 0) setCurrentEnemy(null);
    }
}
