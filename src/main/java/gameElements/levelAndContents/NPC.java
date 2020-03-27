package gameElements.levelAndContents;

import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class NPC extends Entity {
    private int damage;
    private int currentHealth;

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
        ArrayList<NPC> listOfNpcsOnLocation = InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation().getListOfNPCs();
        NPC searchedNPC = null;

        for (NPC npc : listOfNpcsOnLocation){
            if (npc.getName().equals(name)){
                searchedNPC = npc;
            }
        }
        return searchedNPC;
    }
}
