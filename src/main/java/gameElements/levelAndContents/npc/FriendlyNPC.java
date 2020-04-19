package gameElements.levelAndContents.npc;

import gameElements.levelAndContents.Item;

public class FriendlyNPC extends NPC {
    @Override
    public Item getItemToGive() {
        return itemToGive;
    }

    @Override
    public void setItemToGive(Item itemToGive) {
        this.itemToGive = itemToGive;
    }

    @Override
    public int getItemToGiveID() {
        return itemToGiveID;
    }

    @Override
    public void setItemToGiveID(int itemToGiveID) {
        this.itemToGiveID = itemToGiveID;
    }

    // Friendly NPC can't appear in room as part of initiating combat
    @Override
    public int getPercentChanceToShowUpAtLocationSwitch() {
        return 0;
    }

    // Friendly NPC can't appear in room as part of initiating combat
    @Override
    public void setPercentChanceToShowUpAtLocationSwitch(int percentChanceToShowUpAtLocationSwitch) {
        this.percentChanceToShowUpAtLocationSwitch = 0;
    }
}
