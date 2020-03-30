package gameElements.levelAndContents.npc;

import gameElements.levelAndContents.Entity;
import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public abstract class NPC extends Entity {
    private Boolean canAttack = false;
    protected transient Item itemToGive;
    protected int itemToGiveID;
    protected int percentChanceToShowUpAtLocationSwitch;
    private int damage;
    private int currentHealth;

    public Boolean getCanAttack() {
        return canAttack;
    }
    public void setCanAttack(Boolean canAttack) {
        this.canAttack = canAttack;
    }
    public abstract Item getItemToGive();
    public abstract void setItemToGive(Item itemToGive);
    public abstract int getItemToGiveID();
    public abstract void setItemToGiveID(int itemToGiveID);
    public abstract int getPercentChanceToShowUpAtLocationSwitch();
    public abstract void setPercentChanceToShowUpAtLocationSwitch(int percentChanceToShowUpAtLocationSwitch);
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
}