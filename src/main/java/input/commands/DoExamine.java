package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import output.InteractionPrinter;

public class DoExamine {
    public static void doExamine (Item item){
        InteractionPrinter.print(item.getDescription());
    }

    public static void doExamine (NPC npc){
        InteractionPrinter.print(npc.getDescription());
    }

    private DoExamine(){} //hiding the implicit public constructor
}
