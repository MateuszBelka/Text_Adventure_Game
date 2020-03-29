package gameElements.levelAndContents;

import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class NPC extends Entity {
    Boolean canAttack = false;
    Item itemToGive;
    private int percentChanceToShowUpAtLocationSwitch;
    private int damage;
    private int currentHealth;

    public Item getItemToGive() {
        return itemToGive;
    }

    public Boolean getCanAttack() {
        return canAttack;
    }

    public void setItemToGive(Item itemToGive) {
        this.itemToGive = itemToGive;
    }

    public void setCanAttack(Boolean canAttack) {
        this.canAttack = canAttack;
    }

    public static NPC getNPCByName (String name){
        ArrayList<NPC> listOfNpcsOnLocation = InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfFriendlyNPCs();
        NPC searchedNPC = null;

        for (NPC npc : listOfNpcsOnLocation){
            if (npc.getName().toUpperCase().equals(name)){
                searchedNPC = npc;
            }
        }
        return searchedNPC;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public int getPercentChanceToShowUpAtLocationSwitch() {
        return percentChanceToShowUpAtLocationSwitch;
    }
    public void setPercentChanceToShowUpAtLocationSwitch(int percentChanceToShowUpAtLocationSwitch) {
        this.percentChanceToShowUpAtLocationSwitch = percentChanceToShowUpAtLocationSwitch;
    }
}
