package output;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStoryIndependentClasses;
import input.combatValidation.CombatValidation;
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


        if (CombatValidation.attacked) {
            listToPrint.add("You dealt " + player.getDamage() + " points of damage to your enemy.");
            if (BattleSequence.inCombat()) {
                listToPrint.add("Your enemy: " + enemy.getName() + " now has " + enemy.getCurrentHealth() + " health points.");
            }
        }
        // If player is still in combat after damaging enemy then it means the enemy is alive and also hit player
        if (BattleSequence.inCombat()) {
            listToPrint.add("Your enemy: " + enemy.getName() + " has hit you for " + enemy.getDamage() + " points of damage.");
        } else {
            if (player.getCurrentHealth() > 0) {
                listToPrint.add("You won!");
            } else {
                listToPrint.add("You have been killed! Better luck next time!");
                listToPrint.add("Type <Quit> to close the game or <Menu> to start again!");
            }
        }

        for (String newline : listToPrint) {
            terminal.appendText(newline + "\n");
        }
    }
}
