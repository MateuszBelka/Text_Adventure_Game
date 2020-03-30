package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoClose {
    public static void doClose(Item item) {
        // Since we are closing item it cannot be closed again; we are switching from open state to closed
        item.setCanBeClosed(false);
        item.setCanBeOpened(true);

        //print command's description
        NonStoryPrinter.print(item.getDescriptionOfCommand("close"));

        close();
    }

    public static void doClose(NPC npc) {
        // Since we are closing npc it cannot be closed again; we are switching from open state to closed
        npc.setCanBeClosed(false);
        npc.setCanBeOpened(true);

        close();

        //print command's description
        NonStoryPrinter.print(npc.getDescriptionOfCommand("close"));
    }

    public static void doCloseItemWithItem (Item itemToClose, Item itemToCloseWith) {
        // Since we are closing npc it cannot be closed again; we are switching from open state to closed
        itemToClose.setCanBeClosed(false);

        //delete itemToCloseWith from inventory
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToCloseWith);

        //print command's description
        NonStoryPrinter.print(itemToClose.getDescriptionOfCommand("close"));

        close();
    }

    private static void close(){
        // Puzzle completed
        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();
    }

    private DoClose(){} //hiding the implicit public constructor
}
