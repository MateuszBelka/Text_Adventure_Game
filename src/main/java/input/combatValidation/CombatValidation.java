package input.combatValidation;

import gameElements.battle.BattleSequence;
import output.NonStoryPrinter;

public class CombatValidation {
    public static void validator(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "1":
            case "attack":
                BattleSequence.playerAttack();
                break;
            default:
                NonStoryPrinter.addToPrinting("This command is unavailable during combat. Defeat the enemy to continue!");
        }
    }
}
