package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;

public class DoDrop {
    public static void doDrop(Item item){
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(item);
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().addItemToList(item);
        item.setCanBeDropped(false);
    }
}
