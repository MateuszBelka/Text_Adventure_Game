package input.commands;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import input.combatValidation.CombatValidation;
import output.NonStoryPrinter;

import static input.commands.DoBreak.doBreakWithoutItem;

public class DoAttack {
    public static void doAttack(Item item) {
        // Print command description. Remove item from game if it can be broken
        NonStoryPrinter.print( item.getDescriptionOfCommand("attack") );

        if (item.getCanBeBrokenWithoutItem()){
            doBreakWithoutItem(item);
        }
    }

    public static void doAttack(NPC npc) {
        // Starts a battle if npc can be attacked
        BattleSequence.initCombat(npc);
        if (BattleSequence.inCombat()) {
            CombatValidation.validator("attack");
        }
    }

    private DoAttack(){} //hiding the implicit public constructor
}