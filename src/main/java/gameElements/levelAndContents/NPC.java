package gameElements.levelAndContents;

import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class NPC extends Entity {
    Boolean canAttack = false;
    Item itemToGive;

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
}
