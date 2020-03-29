package input.commands;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import input.combatValidation.CombatValidation;
import output.NonStoryPrinter;

public class DoAttack {
    public static void doAttack(Item item) {
        // Remove item from game if it can be broken
        DoBreak.doBreakWithoutItem(item);
    }

    public static void doAttack(NPC npc) {
        // Starts a battle if npc can be attacked
        BattleSequence.initCombat(npc);
        if (BattleSequence.inCombat()) {
            CombatValidation.validator("attack");
        }
    }

    public static void doAttack(){
        NonStoryPrinter.print("What or who would you like to attack?");
    }
}