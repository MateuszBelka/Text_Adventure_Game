package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import output.InteractionPrinter;

public class DoTalkWith {
    public static void  doTalkWith(NPC npc) {
        InteractionPrinter.print(npc.getDescriptionOfCommand("talk"));
    }

    public static void  doTalkWith(Item item) {
        InteractionPrinter.print(item.getDescriptionOfCommand("talk"));
    }

    private DoTalkWith(){} //hiding the implicit public constructor
}
