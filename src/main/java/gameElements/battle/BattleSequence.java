package gameElements.battle;

import gameElements.levelAndContents.NPC;

public class BattleSequence {
    public static boolean inCombat = false;
    public static NPC currentEnemy = null;

    public static boolean isInCombat() {
        return inCombat;
    }
    public static void setInCombat(boolean inCombat) {
        BattleSequence.inCombat = inCombat;
    }
    public static NPC getCurrentEnemy() {
        return currentEnemy;
    }
    public static void setCurrentEnemy(NPC currentEnemy) {
        BattleSequence.currentEnemy = currentEnemy;
    }

    // Call when player changes rooms and there is enemy inside
    public static void initCombat(NPC enemy) {
        setInCombat(true);
    }

    // Call after player input is processed but before output is generated
    public static void enemiesTurn() {
        if (getCurrentEnemy() == null) {
            return;
        }


    }
}
