package input.combatValidation;

import gameElements.battle.BattleSequence;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import input.validation.Validation;
import javafx.event.ActionEvent;
import output.NonStoryPrinter;

import java.io.IOException;

public class CombatValidation {
    public static void validator(String input) {
        input = input.toLowerCase();
            switch (input) {
                case "1":
                case "attack":
                    BattleSequence.playerAttack();
                    break;
                default:
                    NonStoryPrinter.print("This command is unavailable during combat. Defeat the enemy to continue!");
            }
    }
}
