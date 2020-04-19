package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.PlayerHealthProgression;
import gameElements.player.PlayerHungerProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

public class DoConsume {
    public static void doConsume (Item item) {
        //delete item from inventory, updates effects on player, prints description for command
        InitOfClassesThroughSaveFile.getInventory().deleteItemFromInventory(item);
        consumptionEffectsOnPlayer();
        InteractionPrinter.print(item.getDescriptionOfCommand("consume"));
    }

    public static void doConsume (NPC npc) {
        //deletes npc from location, updates effects on player, prints description for command
        InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().deleteFriendlyNPCInList(npc);
        consumptionEffectsOnPlayer();
        InteractionPrinter.print(npc.getDescriptionOfCommand("consume"));
    }

    private static void consumptionEffectsOnPlayer() {
        // Increase player hunger level (=decreases hunger), as a result of consuming
        PlayerHungerProgression.eatFoodHungerIncrease();
        PlayerHealthProgression.eatFoodHealthIncrease();
    }

    private DoConsume(){} //hiding the implicit public constructor
}
