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
        NonStoryPrinter.print(item.getDescriptionOfCommand("smell"));
    }

    public static void doSmell(NPC npc) {
        NonStoryPrinter.print(npc.getDescriptionOfCommand("smell"));
    }

    private DoSmell(){} //hiding the implicit public constructor
}
