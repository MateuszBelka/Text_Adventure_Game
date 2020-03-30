package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerHungerProgression;
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

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    public static void doPush(NPC npc){
        npc.setCanBePushed(false);
        npc.setCanBePulled(true);
        NonStoryPrinter.print( npc.getDescriptionOfCommand("push")  );

        PuzzleProgression.incrementPuzzleCountAndGiveXPReward();

        // Reduces player hunger as a result of conducting an action.
        PlayerHungerProgression.decreaseCurrentHunger();
    }

    private DoPush(){} //hiding the implicit public constructor
}
