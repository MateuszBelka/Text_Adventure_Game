package util;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import output.NonStoryPrinter;

public class ExistenceCheck {
    public static boolean doesItExist(Item item, String errorMsg) {
        if (item == null) {
            NonStoryPrinter.print(errorMsg);
            return false;
        }
        return true;
    }

    public static boolean doesItExist(Item item0, Item item1, String errorMsg) {
        if (item0 == null || item1 == null) {
            NonStoryPrinter.print(errorMsg);
            return false;
        }
        return true;
    }

    public static boolean doesItExist(NPC npc, String errorMsg) {
        if (npc == null) {
            NonStoryPrinter.print(errorMsg);
            return false;
        }
        return true;
    }

    public static boolean doesItExist(NPC npc0, NPC npc1, String errorMsg) {
        if (npc0 == null || npc1 == null) {
            NonStoryPrinter.print(errorMsg);
            return false;
        }
        return true;
    }
}
