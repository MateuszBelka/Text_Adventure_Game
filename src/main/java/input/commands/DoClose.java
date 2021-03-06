package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoClose {
    public static void doClose(Item item) {
        // Since we are closing item it cannot be closed again; we are switching from open state to closed
        item.setCanBeClosed(false);
        item.setCanBeOpened(true);

        //print command's description
        InteractionPrinter.print(item.getDescriptionOfCommand("close"));

        close();
    }

    public static void doClose(NPC npc) {
        // Since we are closing npc it cannot be closed again; we are switching from open state to closed
        npc.setCanBeClosed(false);
        npc.setCanBeOpened(true);

        close();

        //print command's description
        InteractionPrinter.print(npc.getDescriptionOfCommand("close"));
    }

    public static void doCloseItemWithItem (Item itemToClose, Item itemToCloseWith) {
        // Since we are closing npc it cannot be closed again; we are switching from open state to closed
        itemToClose.setCanBeClosed(false);

        //delete itemToCloseWith from inventory
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToCloseWith);

        //print command's description
        InteractionPrinter.print(itemToClose.getDescriptionOfCommand("close"));

        close();
    }

    private static void close(){
        // Puzzle completed
        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoClose(){} //hiding the implicit public constructor
}
