package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoCut {

    public static void doCutWith(NPC npcToBeCut, Item itemToCutWith) {
        //deletes itemToCutWith, changes itemToBeCut to cannot be cut,
        //changes item's description to command description, prints description.
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToCutWith);
        npcToBeCut.setCanBeCut(false);
        npcToBeCut.setDescription( npcToBeCut.getDescriptionOfCommand("cut") );
        InteractionPrinter.print(npcToBeCut.getDescription());

        // Puzzle count up and xp
        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    public static void doCutItemWithItem(Item itemToBeCut, Item itemToCutWith) {
        //deletes itemToCutWith, changes itemToBeCut to cannot be cut,
        //changes item's description to command description, prints description.
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToCutWith);
        itemToBeCut.setCanBeCut(false);
        itemToBeCut.setDescription( itemToBeCut.getDescriptionOfCommand("cut") );
        InteractionPrinter.print(itemToBeCut.getDescription());

        // Puzzle count up and xp
        PuzzleProgression.incrementPuzzleCountGiveXPDrainHunger();
    }

    private DoCut(){} //hiding the implicit public constructor
}
