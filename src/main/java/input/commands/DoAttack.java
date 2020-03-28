package input.commands;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import input.combatValidation.CombatValidation;

public class DoAttack {
    public static void doAttack(Item item){
    }

    public static void doAttack(NPC npc){
        BattleSequence.initCombat(npc);
        if (BattleSequence.inCombat()) {
            CombatValidation.validator("attack");
        }
    }

    public static void doAttack(){

    }
}

// Stuff for enemy combat
//if (BattleSequence.playerAttack(item) != 0) {
//        /*
//         * Set some work of error msg in output
//         *
//         * either the weapon can't be used to attack
//         * or there is no enemy
//         */
//        }