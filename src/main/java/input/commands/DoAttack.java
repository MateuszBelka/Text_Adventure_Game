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