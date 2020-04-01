package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import output.InteractionPrinter;

public class DoOpen {
    public static void doOpen (Item item){
        // Since we are opening item it cannot be opened again; we are switching from closed state to open
        item.setCanBeOpened(false);
        item.setCanBeClosed(true);
        InteractionPrinter.print( item.getDescriptionOfCommand("open") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doOpen (NPC npc){
        // Since we are opening npc it cannot be opened again; we are switching from closed state to open
        npc.setCanBeOpened(false);
        npc.setCanBeClosed(true);
        InteractionPrinter.print( npc.getDescriptionOfCommand("open") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doOpenItemWithItem (Item itemToOpen, Item itemToOpenWith){
        // Since we are opening item it cannot be opening again; we are switching from closed state to open
        itemToOpen.setCanBeOpened(false);
        itemToOpen.setCanBeClosed(true);
        InteractionPrinter.print("You have opened " + itemToOpen.getName() + " using " + itemToOpenWith.getName() + ":");
        InteractionPrinter.print( itemToOpen.getDescriptionOfCommand("open") );

        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoOpen(){} //hiding the implicit public constructor
}
