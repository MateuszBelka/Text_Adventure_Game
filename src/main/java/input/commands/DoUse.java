package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import output.InteractionPrinter;

public class DoUse {
    public static void doUse(Item item) {
        item.setCanBeUsed(false);
        InteractionPrinter.print("You have used " + item.getName() + ".");

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doUse(NPC npc) {
        npc.setCanBeUsed(false);
        InteractionPrinter.print("You have used " + npc.getName() + ".");

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doUseItemOnNPC(Item item, NPC npc) {
        item.setCanBeUsedOnNPC(false);
        InteractionPrinter.print("You have used " + item.getName() + " on " + npc.getName() + ".");

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doUseItemOnItem(Item item1, Item item2) {
        item1.setCanBeUsedOnItem(false);
        InteractionPrinter.print("You have used " + item1.getName() + " on " + item2.getName() + ".");

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoUse(){} //hiding the implicit public constructor
}
