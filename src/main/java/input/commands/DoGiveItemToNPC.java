package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoGiveItemToNPC {
    public static void doGiveItemToNPC(Item item, NPC npc) {
        // deletes item from inventory. Prints command description. Updates puzzles amount. Gives xp reward.
        InitOfClassesThroughSaveFile.getPlayerStats().getInventory().deleteItemFromInventory(item);
        NonStoryPrinter.print(npc.getDescriptionOfCommand("give"));

        // Puzzle completed
        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoGiveItemToNPC(){} //hiding the implicit public constructor
}
