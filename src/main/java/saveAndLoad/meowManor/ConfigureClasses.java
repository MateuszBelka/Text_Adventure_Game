package saveAndLoad.meowManor;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

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
        //static
        Item canOfAnchovies = InitOfClassesThroughSaveFile.getItems().get(0);
        Item fishTank = InitOfClassesThroughSaveFile.getItems().get(1);
        Item bagOfCatTreats = InitOfClassesThroughSaveFile.getItems().get(2);
        Item cart = InitOfClassesThroughSaveFile.getItems().get(3);
        Item signOnDoor = InitOfClassesThroughSaveFile.getItems().get(4);

        //pickupable
        Item rock = InitOfClassesThroughSaveFile.getItems().get(5);
        Item fishShapedKey = InitOfClassesThroughSaveFile.getItems().get(6);
        Item clippers = InitOfClassesThroughSaveFile.getItems().get(7);
        Item canOfTuna = InitOfClassesThroughSaveFile.getItems().get(8);
        Item laserPointer = InitOfClassesThroughSaveFile.getItems().get(9);

        //Starting inv items
        Item redBull = InitOfClassesThroughSaveFile.getItems().get(10);
        Item kitKat = InitOfClassesThroughSaveFile.getItems().get(11);


        // canOfAnchovies
        canOfAnchovies.setDescription("Gross, canned anchovies? " +
                "Well, food is food. It doesn’t have a tab to be pulled, " +
                "so it must be\n opened another way.\n");

        // fishTank
        fishTank.setDescription("The fish tank is huge, " +
                "and it looks like the owner put jewels " +
                "at the bottom rather than rocks…");

        // bagOfCatTreats
        bagOfCatTreats.setDescription("A large bag of high-quality cat treats.");

        // cart
        cart.setDescription("The cart is full of all kinds of dried catnip.");

        // signOnDoor
        signOnDoor.setDescription("The golden-colored print on this sign is really small…");

        // rock
        rock.setDescription("");

        // fishShapedKey
        fishShapedKey.setDescription("A fish-shaped, gold and diamond-encrusted key.");

        // clippers
        clippers.setDescription("An ordinary pair of hair-clippers. " +
                "Weird. I thought cats loved their fur?");
    }

    public static void configureLevels() {
        //todo
        Level level1 = InitOfClassesThroughSaveFile.getLevels().get(0);
        Level level2 = InitOfClassesThroughSaveFile.getLevels().get(1);

        //level1
        Location Foyer = InitOfClassesThroughSaveFile.getLocations().get(0);
        Location Garden = InitOfClassesThroughSaveFile.getLocations().get(1);
        Location theStudy = InitOfClassesThroughSaveFile.getLocations().get(2);

        //level2
        Location livingRoom = InitOfClassesThroughSaveFile.getLocations().get(3);
        Location meowsterBedroom = InitOfClassesThroughSaveFile.getLocations().get(4);


    }

    public static void configureLocations() {
        //todo
        //level1
        Location Foyer = InitOfClassesThroughSaveFile.getLocations().get(0);
        Location Garden = InitOfClassesThroughSaveFile.getLocations().get(1);
        Location theStudy = InitOfClassesThroughSaveFile.getLocations().get(2);

        //level2
        Location livingRoom = InitOfClassesThroughSaveFile.getLocations().get(3);
        Location meowsterBedroom = InitOfClassesThroughSaveFile.getLocations().get(4);

        //Items
        Item canOfAnchovies = InitOfClassesThroughSaveFile.getItems().get(0);
        Item fishTank = InitOfClassesThroughSaveFile.getItems().get(1);
        Item bagOfCatTreats = InitOfClassesThroughSaveFile.getItems().get(2);
        Item cart = InitOfClassesThroughSaveFile.getItems().get(3);
        Item signOnDoor = InitOfClassesThroughSaveFile.getItems().get(4);
        Item rock = InitOfClassesThroughSaveFile.getItems().get(5);
        Item fishShapedKey = InitOfClassesThroughSaveFile.getItems().get(6);
        Item clippers = InitOfClassesThroughSaveFile.getItems().get(7);
        Item canOfTuna = InitOfClassesThroughSaveFile.getItems().get(8);
        Item laserPointer = InitOfClassesThroughSaveFile.getItems().get(9);

        //FriendlyNPC
        NPC milk = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(0);
        NPC christofur = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(1);
        NPC bartholomeow = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(2);
        NPC patchesFriendly = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(3);

        //EnemyNPC
        NPC lucky = InitOfClassesThroughSaveFile.getEnemyNPCs().get(0);
        NPC patchesEnemy = InitOfClassesThroughSaveFile.getEnemyNPCs().get(1);
        NPC wildCat = InitOfClassesThroughSaveFile.getEnemyNPCs().get(2);


    }

    public static void configureFriendlyNPCs() {
        //todo
        NPC milk = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(0);
        NPC christofur = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(1);
        NPC bartholomeow = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(2);
        NPC patchesFriendly = InitOfClassesThroughSaveFile.getFriendlyNPCs().get(3);
    }

    private static void configureEnemyNPCs() {
        //todo
        NPC lucky = InitOfClassesThroughSaveFile.getEnemyNPCs().get(0);
        NPC patchesEnemy = InitOfClassesThroughSaveFile.getEnemyNPCs().get(1);
        NPC wildCat = InitOfClassesThroughSaveFile.getEnemyNPCs().get(2);
    }

    public static void configureInventory() {
        Inventory inv = InitOfClassesThroughSaveFile.getInventory();

        Item redBull = InitOfClassesThroughSaveFile.getItems().get(10);
        Item kitKat = InitOfClassesThroughSaveFile.getItems().get(11);

        inv.getListOfItems().add(redBull);
        inv.getListOfItems().add(kitKat);
    }

    public static void configurePlayer() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Inventory inventory = InitOfClassesThroughSaveFile.getInventory();
        Level level1 = InitOfClassesThroughSaveFile.getLevels().get(0);

        playerStats.setCurrentLevel(level1);
        playerStats.setCurrentLocation(level1.getStartLocation());
        playerStats.setInventory(inventory);
    }
}
