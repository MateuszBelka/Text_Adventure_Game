package input.commands;

import gameElements.battle.BattleSequence;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;

public class DoAttack {
    public static void doAttack(Item item){
        if (BattleSequence.playerAttack(item) != 0) {
            /*
             * Set some work of error msg in output
             *
             * either the weapon can't be used to attack
             * or there is no enemy
             */
        }
    }

    public static void doAttack(NPC npc){
        //Dunno what we are supposed to do here
    }
}
