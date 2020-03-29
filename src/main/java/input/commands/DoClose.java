package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import util.ExistenceCheck;

//todo: implement
public class DoClose {
    public static void doClose(Item item) {
        if (!ExistenceCheck.doesItExist(item, "The item you are trying to close doesn't exist.")) return;
    }

    public static void doClose(NPC npc) {
        if (!ExistenceCheck.doesItExist(npc, "The npc you are trying to close doesn't exist.")) return;
    }

    public static void doCloseItemWithItem (Item itemToClose, Item itemToCloseWith) {
        if (!ExistenceCheck.doesItExist(itemToCloseWith, itemToClose, "Either the item you want to close or the item you need to close with doesn't exist.")) return;
    }
}
