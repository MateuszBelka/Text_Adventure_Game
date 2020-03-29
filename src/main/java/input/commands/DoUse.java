package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoUse {
    public static void doUse(Item item) {
        item.setCanBeUsed(false);
        NonStoryPrinter.print("You have used " + item.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    public static void doUse(NPC npc) {
        npc.setCanBeUsed(false);
        NonStoryPrinter.print("You have used " + npc.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    public static void doUseItemOnNPC(Item item, NPC npc) {
        item.setCanBeUsedOnNPC(false);
        NonStoryPrinter.print("You have used " + item.getName() + " on " + npc.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    public static void doUseItemOnItem(Item item1, Item item2) {
        item1.setCanBeUsedOnItem(false);
        NonStoryPrinter.print("You have used " + item1.getName() + " on " + item2.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }



}
