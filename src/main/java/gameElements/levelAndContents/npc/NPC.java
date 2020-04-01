package gameElements.levelAndContents.npc;

import gameElements.levelAndContents.Entity;
import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public abstract class NPC extends Entity {
    protected Boolean canAttack = false;
    protected transient Item itemToGive;
    protected int itemToGiveID;
    protected int percentChanceToShowUpAtLocationSwitch;
    protected int damage;
    protected int currentHealth;
    protected transient NPC NPCSpawnedAfterBattle;
    protected int NPCSpawnedAfterBattleID;

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
    public NPC getNPCSpawnedAfterBattle() {
        return NPCSpawnedAfterBattle;
    }
    public void setNPCSpawnedAfterBattle(NPC NPCSpawnedAfterBattle) {
        this.NPCSpawnedAfterBattle = NPCSpawnedAfterBattle;
    }
    public int getNPCSpawnedAfterBattleID() {
        return NPCSpawnedAfterBattleID;
    }
    public void setNPCSpawnedAfterBattleID(int NPCSpawnedAfterBattleID) {
        this.NPCSpawnedAfterBattleID = NPCSpawnedAfterBattleID;
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