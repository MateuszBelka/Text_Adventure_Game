package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerHungerProgression;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import gameProgress.PuzzleProgression;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

public class DoPull {
    public static void doPull (Item item){
        item.setCanBePulled(false);
        item.setCanBePushed(true);
        NonStoryPrinter.print( item.getDescriptionOfCommand("pull") );

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    public static void doPull (NPC npc){
        npc.setCanBePulled(false);
        npc.setCanBePushed(true);
        NonStoryPrinter.print( npc.getDescriptionOfCommand("npc") );

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    private DoPull(){} //hiding the implicit public constructor
}
