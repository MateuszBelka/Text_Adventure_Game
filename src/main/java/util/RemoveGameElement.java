package util;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

public class RemoveGameElement {
    public static void remove(Item item) {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        // Remove item from location if its there
        for (Item locationItem : player.getCurrentLocation().getListOfItems()) {
            if (locationItem.getId() == item.getId()) {
                player.getCurrentLocation().getListOfItems().remove(item);
                player.getCurrentLocation().getListOfItemsIDs().remove(item.getId());
                return;
            }
        }
        // Remove item from inventory if its there
        for (Item inventoryItem : player.getInventory().getListOfItems()) {
            if (inventoryItem.getId() == item.getId()) {
                player.getInventory().getListOfItems().remove(item);
                player.getInventory().getListOfItemsIDs().remove(item.getId());
                return;
            }
        }
    }

    public static void remove(NPC npc) {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        // Remove npc from location if its there
        for (NPC locationNPC : player.getCurrentLocation().getListOfFriendlyNPCs()) {
            if (locationNPC.getId() == npc.getId()) {
                player.getCurrentLocation().getListOfFriendlyNPCs().remove(npc);
                player.getCurrentLocation().getListOfFriendlyNPCsIDs().remove(npc.getId());
                return;
            }
        }
    }
}
