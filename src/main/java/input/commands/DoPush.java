package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoPush {
    public static void doPush(Item item) {
        item.setCanBePushed(false);
        item.setCanBePulled(true);
        NonStoryPrinter.print( item.getDescriptionOfCommand("push") );

        incrementPuzzleCountAndGiveXPReward();
    }

    public static void doPush(NPC npc){
        npc.setCanBePushed(false);
        npc.setCanBePulled(true);
        NonStoryPrinter.print( npc.getDescriptionOfCommand("push")  );

        incrementPuzzleCountAndGiveXPReward();
    }

    private static void incrementPuzzleCountAndGiveXPReward(){
        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        PuzzleProgression.incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    private DoPush(){} //hiding the implicit public constructor
}
