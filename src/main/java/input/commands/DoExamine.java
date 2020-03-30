package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import output.NonStoryPrinter;

public class DoExamine {
    public static void doExamine (Item item){
        NonStoryPrinter.print(item.getDescription());
    }

    public static void doExamine (NPC npc){
        NonStoryPrinter.print(npc.getDescription());
    }

    private DoExamine(){} //hiding the implicit public constructor
}
