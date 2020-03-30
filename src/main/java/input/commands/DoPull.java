package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import output.NonStoryPrinter;

public class DoPull {
    public static void doPull (Item item){
        item.setCanBePulled(false);
        item.setCanBePushed(true);
        NonStoryPrinter.print( item.getDescriptionOfCommand("pull") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doPull (NPC npc){
        npc.setCanBePulled(false);
        npc.setCanBePushed(true);
        NonStoryPrinter.print( npc.getDescriptionOfCommand("npc") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoPull(){} //hiding the implicit public constructor
}
