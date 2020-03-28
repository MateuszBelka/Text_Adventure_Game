package output.combat;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStoryIndependentClasses;
import javafx.scene.control.TextArea;
import ui.controllers.Adventure;

import java.util.ArrayList;

public class CombatPrinter {
    public static void printCombat() {
        Adventure adventure = InitOfStoryIndependentClasses.getAdventure();
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        NPC enemy = BattleSequence.getCurrentEnemy();
        TextArea terminal = adventure.getTerminal();
        ArrayList<String> listToPrint = new ArrayList<>();

        listToPrint.add("You dealt " + player.getDamage() + " points of damage to your enemy.");
        listToPrint.add("Your enemy: " + enemy.getName() + " now has " + enemy.getCurrentHealth() + " health points.\n");
        listToPrint.add("Your enemy: " + enemy.getName() + " has hit you for " + enemy.getDamage() + "points of damage.");
        listToPrint.add("You now have " + player.getCurrentHealth() + " health points.");

        for (String newline : listToPrint) {
            terminal.appendText(newline + "\n");
        }
    }
}
