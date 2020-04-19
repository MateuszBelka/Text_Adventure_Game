package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import output.InteractionPrinter;

public class DoPush {
    public static void doPush(Item item) {
        item.setCanBePushed(false);
        InteractionPrinter.print( item.getDescriptionOfCommand("push") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doPush(NPC npc){
        npc.setCanBePushed(false);
        InteractionPrinter.print( npc.getDescriptionOfCommand("push")  );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoPush(){} //hiding the implicit public constructor
}
