package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoSmell {
    public static void doSmell(){
        NonStoryPrinter.print(InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getTextForSmelling());
    }

    public static void doSmell(Item item) {
        NonStoryPrinter.print(item.getTextForSmelling());
    }

    public static void doSmell(NPC npc) {
        NonStoryPrinter.print(npc.getTextForSmelling());
    }
}
