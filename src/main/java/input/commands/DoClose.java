package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import util.ExistenceCheck;

public class DoClose {
    public static void doClose(Item item) {
        if (!ExistenceCheck.doesItExist(item, "The item you are trying to close doesn't exist.")) return;
        if (item.getCanBeClosed()) {
            // Since we are closing item it cannot be closed again; we are switching from open state to closed
            item.setCanBeClosed(false);

            // Puzzle completed
            PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
            player.getCurrentLevel().incrementPuzzlesSolvedCount();

            // Get XP reward from puzzle
            PlayerLevellingProgression.addXPReward();
        }
    }

    public static void doClose(NPC npc) {
        if (!ExistenceCheck.doesItExist(npc, "The npc you are trying to close doesn't exist.")) return;
        if (npc.getCanBeClosed()) {
            // Since we are closing npc it cannot be closed again; we are switching from open state to closed
            npc.setCanBeClosed(false);

            // Puzzle completed
            PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
            player.getCurrentLevel().incrementPuzzlesSolvedCount();

            // Get XP reward from puzzle
            PlayerLevellingProgression.addXPReward();
        }
    }

    public static void doCloseItemWithItem (Item itemToClose, Item itemToCloseWith) {
        if (!ExistenceCheck.doesItExist(itemToCloseWith, itemToClose, "Either the item you want to close or the item you need to close with doesn't exist.")) return;
        //todo: Need Clarification on itemToCloseWith and itemToBeClosed vars in Entity
        if (itemToClose.getCanBeClosed() && itemToClose.getItemToCloseWith().getId() == itemToCloseWith.getId()) {
            // Since we are closing npc it cannot be closed again; we are switching from open state to closed
            itemToClose.setCanBeClosed(false);

            // Puzzle completed
            PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
            player.getCurrentLevel().incrementPuzzlesSolvedCount();

            // Get XP reward from puzzle
            PlayerLevellingProgression.addXPReward();
        }
    }
}
