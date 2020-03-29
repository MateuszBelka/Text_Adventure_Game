package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;

public class DoGiveItemToNPC {
    public static void doGiveItemToNPC(Item item, NPC npc){
        System.out.println("gave " + npc.getName() + " " + item.getName() );
        //todo
    }
}
