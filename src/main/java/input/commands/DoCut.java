package input.commands;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerLevellingProgression;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import util.ExistenceCheck;

public class DoCut {
    public static void doCutWith(Item itemToBeCut, Item itemToCutWith) {
        // Since we are cutting item it cannot be cut again; we are switching from not cut state to cut
        itemToBeCut.setCanBeCut(false);

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }

    public static void doCutWith(NPC npcToBeCut, Item itemToCutWith) {
        // Since we are cutting npc it cannot be cut again; we are switching from not cut state to cut
        npcToBeCut.setCanBeCut(false);

        // Puzzle completed
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        player.getCurrentLevel().incrementPuzzlesSolvedCount();

        // Get XP reward from puzzle
        PlayerLevellingProgression.addXPReward();
    }
}
