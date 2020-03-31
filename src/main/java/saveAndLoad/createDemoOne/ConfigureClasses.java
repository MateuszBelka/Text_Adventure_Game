package saveAndLoad.createDemoOne;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfigureClasses {
    public static void configureEverything() {
        //File Dependent
        configureItems();
        configureLevels();
        configureLocations();
        configureFriendlyNPCs();
        configureEnemyNPCs();
        configureInventory();
        configurePlayer();
    }


    public static void configureItems() {
        Item item0 = InitOfClassesThroughSaveFile.getItems().get(0);
        Item item1 = InitOfClassesThroughSaveFile.getItems().get(1);
        Item item2 = InitOfClassesThroughSaveFile.getItems().get(2);

        item0.setName("item0");
        item0.setDescription("temporary description for item0");
        item0.setDescriptionAfterPuzzleComplete("temporary description for puzzle complete for item0");
        item0.setCanBePickedUp(true);
        item0.setCanBreak(true);
        item0.setCanBeBrokenWithoutItem(true);
        item0.getItemsToDropOnBreak().add(item2);

        item1.setName("item1");
        item1.setDescription("temporary description for item1");
        item1.setDescriptionAfterPuzzleComplete("temporary description for puzzle complete for item1");
        item1.setCanBePickedUp(true);

        item2.setName("item2");
        item2.setCanBePickedUp(true);
    }

    public static void configureLevels() {
        Level level0 = InitOfClassesThroughSaveFile.getLevels().get(0);
        Location location0 = InitOfClassesThroughSaveFile.getLocations().get(0);

        level0.setId(1);
        level0.setDescription("test description for level0");
        level0.setName("test name for level0");
        level0.setFirstTimeEnteringLevel(true);
        level0.setTotalPuzzleCount(5);
        level0.setStartLocation(location0);
    }

    public static void configureLocations() {
        Location location0 = InitOfClassesThroughSaveFile.getLocations().get(0);
        Location location1 = InitOfClassesThroughSaveFile.getLocations().get(1);
        Item item0 = InitOfClassesThroughSaveFile.getItems().get(0);
        Item item1 = InitOfClassesThroughSaveFile.getItems().get(1);
        NPC friendlyNPC0 = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(0);
        NPC enemyNPC0 = InitOfClassesThroughSaveFile.getEnemyNPCs().get(0);

        //Location 0 config
        HashMap<String, Location> location0Connections = new HashMap<>();
        location0Connections.put("north",location1);
        location0.setListOfConnectedLocations(location0Connections);

        ArrayList<Item> location0items = new ArrayList<>();
        location0items.add(item0);
        location0items.add(item1);
        location0.setListOfItems(location0items);

        ArrayList<NPC> location0FriendlyNPCs = new ArrayList<>();
        location0FriendlyNPCs.add(friendlyNPC0);
        location0.setListOfFriendlyNPCs(location0FriendlyNPCs);

        location0.setDescription("temporary description for location0.");
        location0.setName("location0");


        //Location 1 config
        HashMap<String, Location> location1Connections = new HashMap<>();
        location1Connections.put("south",location0);
        location1.setListOfConnectedLocations(location1Connections);

        ArrayList<NPC> location1EnemyNPCs = new ArrayList<>();
        location1EnemyNPCs.add(enemyNPC0);
        location1.setListOfEnemyNPCs(location1EnemyNPCs);

        location1.setDescription("temporary description for location1.");
        location1.setName("location1");
    }

    public static void configureFriendlyNPCs() {
        NPC npc0 = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(0);

        npc0.setName("Henry");
        npc0.setDescription("test description for Henry");
    }

    private static void configureEnemyNPCs() {
        NPC npc0 = InitOfClassesThroughSaveFile.getEnemyNPCs().get(0);

        npc0.setName("Skeleton");
        npc0.setPercentChanceToShowUpAtLocationSwitch(100);
        npc0.setCanAttack(true);
        npc0.setCanBeAttacked(true);
        npc0.setDamage(5);
        npc0.setCurrentHealth(50);
    }

    public static void configureInventory() {
        //Empty inv at start
    }

    public static void configurePlayer() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Inventory inventory = InitOfClassesThroughSaveFile.getInventory();
        Level level0 = InitOfClassesThroughSaveFile.getLevels().get(0);

        playerStats.setCurrentLevel(level0);
        playerStats.setCurrentLocation(level0.getStartLocation());
        playerStats.setInventory(inventory);
    }
}
