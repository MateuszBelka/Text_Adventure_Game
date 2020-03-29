package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoGiveItemToNPC {
    public static void doGiveItemToNPC(Item item, NPC npc) {
        InitOfClassesThroughSaveFile.getPlayerStats().getInventory().deleteItemFromInventory(item);
        NonStoryPrinter.print("You gave " + item.getName() + " to " + npc.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }
}
