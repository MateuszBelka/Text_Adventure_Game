package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameProgress.PuzzleProgression;
import output.NonStoryPrinter;

public class DoUse {
    public static void doUse(Item item) {
        item.setCanBeUsed(false);
        NonStoryPrinter.print("You have used " + item.getName() + ".");

        incrementPuzzleCountAndGiveXPReward();
    }

    public static void doUse(NPC npc) {
        npc.setCanBeUsed(false);
        NonStoryPrinter.print("You have used " + npc.getName() + ".");

        incrementPuzzleCountAndGiveXPReward();
    }

    public static void doUseItemOnNPC(Item item, NPC npc) {
        item.setCanBeUsedOnNPC(false);
        NonStoryPrinter.print("You have used " + item.getName() + " on " + npc.getName() + ".");

        incrementPuzzleCountAndGiveXPReward();
    }

    public static void doUseItemOnItem(Item item1, Item item2) {
        item1.setCanBeUsedOnItem(false);
        NonStoryPrinter.print("You have used " + item1.getName() + " on " + item2.getName() + ".");

        incrementPuzzleCountAndGiveXPReward();
    }

    private static void incrementPuzzleCountAndGiveXPReward(){
        // Puzzle completed
        PuzzleProgression.incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    private DoUse(){} //hiding the implicit public constructor
}
