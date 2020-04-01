package saveAndLoad.meowManor;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
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
        return PlayerStats.getInstance();
    }

    public static Inventory initInventory() {
        return Inventory.getInstance();
    }

    public static ArrayList<Level> initLevels() {
        ArrayList<Level> listOfLevels = new ArrayList<>();
        Level level1 = new Level();
        Level level2 = new Level();

        listOfLevels.add(level1);
        listOfLevels.add(level2);
        return listOfLevels;
    }

    public static ArrayList<Location> initLocations() {
        ArrayList<Location> listOfLocations = new ArrayList<>();
        //level1
        Location Foyer = new Location();
        Location Garden = new Location();
        Location theStudy = new Location();

        //level2
        Location livingRoom = new Location();
        Location meowsterBedroom = new Location();

        listOfLocations.add(Foyer);
        listOfLocations.add(Garden);
        listOfLocations.add(theStudy);
        listOfLocations.add(livingRoom);
        listOfLocations.add(meowsterBedroom);
        return listOfLocations;
    }

    public static ArrayList<Item> initItems() {
        ArrayList<Item> listOfItems = new ArrayList<>();
        //static
        Item canOfAnchovies = new Item();
        Item fishTank = new Item();
        Item bagOfCatTreats = new Item();
        Item cart = new Item();
        Item signOnDoor = new Item();

        //pickupable
        Item rock = new Item();
        Item fishShapedKey = new Item();
        Item clippers = new Item();
        Item canOfTuna = new Item();
        Item laserPointer = new Item();

        //Starting inv items
        Item redBull = new Item();
        Item kitKat = new Item();

        listOfItems.add(canOfAnchovies);
        listOfItems.add(fishTank);
        listOfItems.add(bagOfCatTreats);
        listOfItems.add(cart);
        listOfItems.add(signOnDoor);
        listOfItems.add(rock);
        listOfItems.add(fishShapedKey);
        listOfItems.add(clippers);
        listOfItems.add(canOfTuna);
        listOfItems.add(laserPointer);
        listOfItems.add(redBull);
        listOfItems.add(kitKat);
        return listOfItems;
    }

    public static ArrayList<NPC> initFriendlyNPC() {
        ArrayList<NPC> listOfNPCs = new ArrayList<>();
        NPC milk = NPCFactory.getNPC("friendlyNPC");
        NPC christofur = NPCFactory.getNPC("friendlyNPC");
        NPC bartholomeow = NPCFactory.getNPC("friendlyNPC");
        NPC patches = NPCFactory.getNPC("friendlyNPC");


        listOfNPCs.add(milk);
        listOfNPCs.add(christofur);
        listOfNPCs.add(bartholomeow);
        listOfNPCs.add(patches);
        return listOfNPCs;
    }

    public static ArrayList<NPC> initEnemyNPC() {
        ArrayList<NPC> listOfNPCs = new ArrayList<>();
        NPC lucky = NPCFactory.getNPC("enemyNPC");
        NPC patches = NPCFactory.getNPC("enemyNPC");
        NPC wildCat = NPCFactory.getNPC("enemyNPC");

        listOfNPCs.add(lucky);
        listOfNPCs.add(patches);
        listOfNPCs.add(wildCat);
        return listOfNPCs;
    }
}
