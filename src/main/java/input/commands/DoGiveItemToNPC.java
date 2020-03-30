package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerHungerProgression;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoGiveItemToNPC {
    public static void doGiveItemToNPC(Item item, NPC npc) {
        // deletes item from inventory. Prints command description. Updates puzzles amount. Gives xp reward.
        InitOfClassesThroughSaveFile.getPlayerStats().getInventory().deleteItemFromInventory(item);
        NonStoryPrinter.print(npc.getDescriptionOfCommand("give"));

        // Puzzle completed
        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    private DoGiveItemToNPC(){} //hiding the implicit public constructor
}
