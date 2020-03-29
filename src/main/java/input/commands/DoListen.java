package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoListen {

    public static void doListen() {
        NonStoryPrinter.print(InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getTextForListening());
    }

    public static void doListenTo(Item item){
        NonStoryPrinter.print(item.getTextForListening());
    }

    public static void doListenTo(NPC npc){
        NonStoryPrinter.print(npc.getTextForListening());
    }

    public static void doListenToNPCWithItem(NPC npc, Item item){
        NonStoryPrinter.print("Thanks to your " + item.getName() + " you can hear " + npc.getName() + ". " + npc.getTextForListening());
    }

    public static void doListenToItemWithItem(Item itemToListenTo, Item itemToListenWith){
        NonStoryPrinter.print("Thanks to your " + itemToListenWith.getName() + " you can hear " + itemToListenTo.getName() + ". " + itemToListenTo.getTextForListening());
    }
}
