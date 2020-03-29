package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoPull {
    public static void doPull (Item item){
        item.setCanBePulled(false);
        item.setCanBePushed(true);
        NonStoryPrinter.print( item.getDescriptionOfCommand("pull") );

        puzzleCompletedAndXPReward();
    }

    public static void doPull (NPC npc){
        npc.setCanBePulled(false);
        npc.setCanBePushed(true);
        NonStoryPrinter.print( npc.getDescriptionOfCommand("npc") );

        puzzleCompletedAndXPReward();
    }

    private static void puzzleCompletedAndXPReward(){
        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }
}
