package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerHungerProgression;
import gameProgress.PuzzleProgression;
import output.NonStoryPrinter;

public class DoPush {
    public static void doPush(Item item) {
        item.setCanBePushed(false);
        item.setCanBePulled(true);
        NonStoryPrinter.print( item.getDescriptionOfCommand("push") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doPush(NPC npc){
        npc.setCanBePushed(false);
        npc.setCanBePulled(true);
        NonStoryPrinter.print( npc.getDescriptionOfCommand("push")  );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoPush(){} //hiding the implicit public constructor
}
