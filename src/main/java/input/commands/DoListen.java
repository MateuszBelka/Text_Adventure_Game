package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoListen {

    public static void doListen() {
        //listens within location by printing description
        InteractionPrinter.print(InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getTextForListening());
    }

    public static void doListenTo(Item item){
        //listens to item by printing description
        InteractionPrinter.print( item.getDescriptionOfCommand("listen") );
    }

    public static void doListenTo(NPC npc){
        //listens to npc by printing description
        InteractionPrinter.print( npc.getDescriptionOfCommand("listen") );
    }

    public static void doListenToNPCWithItem(NPC npc, Item item){
        //listens with an item to npc, and prints description
        InteractionPrinter.print("Listening with " + item.getName() + " to " + npc.getName() + ":");
        InteractionPrinter.print( npc.getDescriptionOfCommand("listen") );
    }

    public static void doListenToItemWithItem(Item itemToListenTo, Item itemToListenWith){
        //listens with an item to an item, and prints description
        InteractionPrinter.print("Listening with " + itemToListenWith.getName() + " to " + itemToListenTo.getName() + ":");
        InteractionPrinter.print( itemToListenTo.getDescriptionOfCommand("listen") );
    }

    private DoListen(){} //hiding the implicit public constructor
}
