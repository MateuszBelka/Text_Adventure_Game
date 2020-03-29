package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoOpen {
    public static void doOpen (Item item){
        // Since we are opening item it cannot be opened again; we are switching from closed state to open
        item.setCanBeOpened(false);
        item.setCanBeClosed(true);
        NonStoryPrinter.print("You have opened " + item.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    public static void doOpen (NPC npc){
        // Since we are opening npc it cannot be opened again; we are switching from closed state to open
        npc.setCanBeOpened(false);
        npc.setCanBeClosed(true);
        NonStoryPrinter.print("You have opened " + npc.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    public static void doOpenItemWithItem (Item itemToOpen, Item itemToOpenWith){
        // Since we are opening item it cannot be opening again; we are switching from closed state to open
        itemToOpen.setCanBeOpened(false);
        itemToOpen.setCanBeClosed(true);
        NonStoryPrinter.print("You have opened " + itemToOpen.getName() + " using your " + itemToOpenWith.getName() + ".");

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }
}
