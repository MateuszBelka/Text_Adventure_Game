package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerHealthProgression;
import gameElements.player.PlayerHungerProgression;
import output.NonStoryPrinter;
import util.ExistenceCheck;
import util.RemoveGameElement;

public class DoConsume {
    public static void doConsume (Item item) {
        if (!ExistenceCheck.doesItExist(item, "The item you are trying to consume doesn't exist.")) return;
        if (item.getCanBeConsumed()) {
            consumptionEffectsOnPlayer();
            RemoveGameElement.remove(item);
            NonStoryPrinter.print("You have consumed " + item.getName() + ".");
        }
    }

    public static void doConsume (NPC npc) {
        if (!ExistenceCheck.doesItExist(npc, "The npc you are trying to consume doesn't exist.")) return;
        if (npc.getCanBeConsumed()) {
            consumptionEffectsOnPlayer();
            RemoveGameElement.remove(npc);
            NonStoryPrinter.print("You have consumed " + npc.getName() + ".");
        }
    }

    private static void consumptionEffectsOnPlayer() {
        // Increase player hunger as a result of consuming
        PlayerHungerProgression.eatFoodHungerIncrease();
        PlayerHealthProgression.eatFoodHealthIncrease();
    }
}
