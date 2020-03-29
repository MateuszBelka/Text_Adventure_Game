package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import output.NonStoryPrinter;

public class DoTalkWith {
    public static void  doTalkWith(NPC npc) {
        NonStoryPrinter.print(npc.getTextForTalking());
    }

    public static void  doTalkWith(Item item) {
        NonStoryPrinter.print(item.getTextForTalking());
    }

}
