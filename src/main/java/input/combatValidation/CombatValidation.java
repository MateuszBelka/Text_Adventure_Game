package input.combatValidation;

import gameElements.battle.BattleSequence;

public class CombatValidation {
    public static void validator(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "1":
            case "attack":
                BattleSequence.playerAttack();
                break;
        }
    }
}
