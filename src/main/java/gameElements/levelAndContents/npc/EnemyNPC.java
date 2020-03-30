package gameElements.levelAndContents.npc;

import gameElements.levelAndContents.Item;

public class EnemyNPC extends NPC {
    // Enemy NPC can't have item to give
    @Override
    public Item getItemToGive() {
        return null;
    }

    // Enemy NPC can't have item to give
    @Override
    public void setItemToGive(Item itemToGive) {
        this.itemToGive = null;
    }

    // Enemy NPC can't have item to give
    @Override
    public int getItemToGiveID() {
        return 0;
    }

    // Enemy NPC can't have item to give
    @Override
    public void setItemToGiveID(int itemToGiveID) {
        this.itemToGiveID = 0;
    }

    @Override
    public int getPercentChanceToShowUpAtLocationSwitch() {
        return percentChanceToShowUpAtLocationSwitch;
    }

    @Override
    public void setPercentChanceToShowUpAtLocationSwitch(int percentChanceToShowUpAtLocationSwitch) {
        this.percentChanceToShowUpAtLocationSwitch = percentChanceToShowUpAtLocationSwitch;
    }
}