package input.combatValidation;

import gameElements.battle.BattleSequence;
import output.InteractionPrinter;

public class CombatValidation {
    public static boolean attacked;

    public static void validator(String input) {
        input = input.toLowerCase();
            switch (input) {
                case "1":
                case "attack":
                    attacked = true;
                    BattleSequence.playerAttack();
                    break;
                default:
                    attacked = false;
                    InteractionPrinter.print("This command is unavailable during combat. Defeat the enemy to continue!");
            }
    }
}
