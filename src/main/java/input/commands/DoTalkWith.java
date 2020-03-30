package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import output.NonStoryPrinter;

public class DoTalkWith {
    public static void  doTalkWith(NPC npc) {
        NonStoryPrinter.print(npc.getDescriptionOfCommand("talk"));
    }

    public static void  doTalkWith(Item item) {
        NonStoryPrinter.print(item.getDescriptionOfCommand("talk"));
    }

    private DoTalkWith(){} //hiding the implicit public constructor
}
