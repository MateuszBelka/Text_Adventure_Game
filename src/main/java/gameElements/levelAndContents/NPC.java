package gameElements.levelAndContents;

import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;

public class NPC extends Entity {
    public static NPC getNPCByName (String name){
        ArrayList<NPC> listOfNpcsOnLocation = CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfNPCs();
        NPC searchedNPC = null;

        for (NPC npc : listOfNpcsOnLocation){
            if (npc.getName().equals(name)){
                searchedNPC = npc;
            }
        }
        return searchedNPC;
    }
}
