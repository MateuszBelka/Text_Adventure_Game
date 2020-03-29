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
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        // Remove item from game if it can be broken
        if (item.getCanBreak()) {
            // Remove item from location if its there
            for (Item locationItem : player.getCurrentLocation().getListOfItems()) {
                if (locationItem.getId() == item.getId()) {
                    player.getCurrentLocation().getListOfItems().remove(item);
                    player.getCurrentLocation().getListOfItemsIDs().remove(item.getId());
                }
            }
            // Remove item from inventory if its there
            for (Item inventoryItem : player.getInventory().getListOfItems()) {
                if (inventoryItem.getId() == item.getId()) {
                    player.getInventory().getListOfItems().remove(item);
                    player.getInventory().getListOfItemsIDs().remove(item.getId());
                }
            }
        }
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