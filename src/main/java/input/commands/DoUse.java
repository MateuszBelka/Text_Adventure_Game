package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerHungerProgression;
import gameElements.player.PlayerLevellingProgression;
import gameProgress.PuzzleProgression;
import output.NonStoryPrinter;

public class DoUse {
    public static void doUse(Item item) {
        item.setCanBeUsed(false);
        NonStoryPrinter.print("You have used " + item.getName() + ".");

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    public static void doUse(NPC npc) {
        npc.setCanBeUsed(false);
        NonStoryPrinter.print("You have used " + npc.getName() + ".");

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    public static void doUseItemOnNPC(Item item, NPC npc) {
        item.setCanBeUsedOnNPC(false);
        NonStoryPrinter.print("You have used " + item.getName() + " on " + npc.getName() + ".");

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    public static void doUseItemOnItem(Item item1, Item item2) {
        item1.setCanBeUsedOnItem(false);
        NonStoryPrinter.print("You have used " + item1.getName() + " on " + item2.getName() + ".");

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    private DoUse(){} //hiding the implicit public constructor
}
