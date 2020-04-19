package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoSmell {
    public static void doSmell(){
        InteractionPrinter.print(InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getTextForSmelling());
    }

    public static void doSmell(Item item) {
        InteractionPrinter.print(item.getDescriptionOfCommand("smell"));
    }

    public static void doSmell(NPC npc) {
        InteractionPrinter.print(npc.getDescriptionOfCommand("smell"));
    }

    private DoSmell(){} //hiding the implicit public constructor
}
