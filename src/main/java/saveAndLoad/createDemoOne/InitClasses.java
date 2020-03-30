package saveAndLoad.createDemoOne;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.npc.EnemyNPC;
import gameElements.levelAndContents.npc.NPC;
import gameElements.levelAndContents.npc.NPCFactory;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;

public class InitClasses {
    public static void initEverything() {
        InitOfClassesThroughSaveFile.setPlayerStats(initPlayer());
        InitOfClassesThroughSaveFile.setInventory(initInventory());
        InitOfClassesThroughSaveFile.setLevels(initLevels());
        InitOfClassesThroughSaveFile.setLocations(initLocations());
        InitOfClassesThroughSaveFile.setItems(initItems());
        InitOfClassesThroughSaveFile.setFriendlyNPCs(initFriendlyNPC());
        InitOfClassesThroughSaveFile.setEnemyNPCs(initEnemyNPC());
    }

    public static PlayerStats initPlayer() {
        return new PlayerStats();
    }

    public static Inventory initInventory() {
        return new Inventory();
    }

    public static ArrayList<Level> initLevels() {
        ArrayList<Level> listOfLevels = new ArrayList<>();
        Level level0 = new Level();

        listOfLevels.add(level0);
        return listOfLevels;
    }

    public static ArrayList<Location> initLocations() {
        ArrayList<Location> listOfLocations = new ArrayList<>();
        Location location0 = new Location();
        Location location1 = new Location();

        listOfLocations.add(location0);
        listOfLocations.add(location1);
        return listOfLocations;
    }

    public static ArrayList<Item> initItems() {
        ArrayList<Item> listOfItems = new ArrayList<>();
        Item item0 = new Item();
        Item item1 = new Item();

        listOfItems.add(item0);
        listOfItems.add(item1);
        return listOfItems;
    }

    public static ArrayList<NPC> initFriendlyNPC() {
        ArrayList<NPC> listOfNPCs = new ArrayList<>();
        NPC npc = NPCFactory.getNPC("friendlyNPC");

        listOfNPCs.add(npc);
        return listOfNPCs;
    }

    public static ArrayList<NPC> initEnemyNPC() {
        ArrayList<NPC> listOfNPCs = new ArrayList<>();
        NPC npc = NPCFactory.getNPC("enemyNPC");

        listOfNPCs.add(npc);
        return listOfNPCs;
    }
}
