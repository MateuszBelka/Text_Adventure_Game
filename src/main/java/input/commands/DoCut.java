package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoCut {

    public static void doCutWith(NPC npcToBeCut, Item itemToCutWith) {
        //deletes itemToCutWith, changes itemToBeCut to cannot be cut,
        //changes item's description to command description, prints description.
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToCutWith);
        npcToBeCut.setCanBeCut(false);
        npcToBeCut.setDescription( npcToBeCut.getDescriptionOfCommand("cut") );
        NonStoryPrinter.print(npcToBeCut.getDescription());
    }

    public static void doCutItemWithItem(Item itemToBeCut, Item itemToCutWith) {
        //deletes itemToCutWith, changes itemToBeCut to cannot be cut,
        //changes item's description to command description, prints description.
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(itemToCutWith);
        itemToBeCut.setCanBeCut(false);
        itemToBeCut.setDescription( itemToBeCut.getDescriptionOfCommand("cut") );
        NonStoryPrinter.print(itemToBeCut.getDescription());
    }

    private DoCut(){} //hiding the implicit public constructor
}
