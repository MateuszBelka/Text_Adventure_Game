package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import output.InteractionPrinter;

public class DoPull {
    public static void doPull (Item item){
        item.setCanBePulled(false);
        InteractionPrinter.print( item.getDescriptionOfCommand("pull") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doPull (NPC npc){
        npc.setCanBePulled(false);
        InteractionPrinter.print( npc.getDescriptionOfCommand("npc") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoPull(){} //hiding the implicit public constructor
}
