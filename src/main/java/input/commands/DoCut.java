package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import util.ExistenceCheck;

public class DoCut {
    public static void doCutWith(Item itemToBeCut, Item itemToCutWith) {
        if (!ExistenceCheck.doesItExist(itemToBeCut, itemToCutWith, "The item you are trying to consume doesn't exist.")) return;

    }

    public static void doCutWith(NPC npcToBeCut, Item itemToCutWith) {
        if (!ExistenceCheck.doesItExist(npcToBeCut, npcToBeCut, "The item you are trying to consume doesn't exist.")) return;

    }

    public static void doCutItemWithItem(Item itemToCut, Item itemToCutWith) {
        if (!ExistenceCheck.doesItExist(itemToCut, itemToCutWith, "The item you are trying to consume doesn't exist.")) return;

    }


}
