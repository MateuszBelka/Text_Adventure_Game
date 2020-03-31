package saveAndLoad;

/*
 * Gson doesn't natively support saving variables which pointer is used by multiple classes.
 * Keywords: Gson, graph of objects
 *
 * Example:
 * public class classA {
 *     public classC foo;
 * }
 * public class classB {
 *     public classC foo;
 * }
 * public class classC {
 *     int i;
 * }
 *
 * In scenario where classA.foo == classB.foo
 * Gson would create two unique instances of classC
 * and as such if in the future classA.foo.i would change
 * then this change would not be deflected in classB.foo.i
 *
 * There are multiple approaches to resolving this issue.
 * We decided to implement an ID system in which all classes
 * have IDs and variables which point to object are not included
 * in Json and instead the object's IDs are.
 *
 * During deserialization object references are added manually,
 * using custom ID matching algorithm.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.npc.NPC;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Load {

    public static void loadGameFromSave(String filePath) throws IOException {
        // Create instances of all classes and populate majority of their variables using provided Json file.
        initializeClassesFromJsonSave(filePath);

        // Convert ID variables to their expected object references.
        decodeIDsToObjects();

        // Regardless of json let player see descriptions
        configPrintingDescriptions();
    }

    private static void initializeClassesFromJsonSave(String filePath) throws IOException {
        /*
         * Create a GsonBuilder instance required to change default settings of Gson
         * Allow the serialization of static fields by setting exclusion setting to ONLY transient
         * For debugging purposes make the Json file in human-readable style
         */
        Gson gson = new GsonBuilder()
                .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
                .setPrettyPrinting()
                .create();

        // Open json file
        BufferedReader input = new BufferedReader(new FileReader(filePath));

        // Populate static variables of CollectionOfAllClasses from json file.
        InitOfClassesThroughSaveFile loadNewGameObjects = gson.fromJson(input, InitOfClassesThroughSaveFile.class);

        // Since all variables within CollectionOfAllClasses are static the object is not longer needed
        loadNewGameObjects = null;
    }

    public static void loadGame(String fileName) throws IOException {
        // Create instances of all classes and populate majority of their variables using provided Json file.
        initializeClassesFromJson(fileName);

        // Convert ID variables to their expected object references.
        decodeIDsToObjects();
    }

    private static void initializeClassesFromJson(String fileName) throws IOException {
        /*
         * Create a GsonBuilder instance required to change default settings of Gson
         * Allow the serialization of static fields by setting exclusion setting to ONLY transient
         * For debugging purposes make the Json file in human-readable style
         */
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(NPC.class, new NPCClassAdapter())
                .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
                .setPrettyPrinting()
                .create();

        // Open json file
        URL url = Load.class.getResource(fileName);
        InputStream in = url.openStream();
        BufferedReader input = new BufferedReader(new InputStreamReader(in));

        // Populate static variables of CollectionOfAllClasses from json file.
        InitOfClassesThroughSaveFile loadNewGameObjects = gson.fromJson(input, InitOfClassesThroughSaveFile.class);

        // Since all variables within CollectionOfAllClasses are static the object is not longer needed
        loadNewGameObjects = null;
    }

    private static void decodeIDsToObjects() {
        connectPlayerToLocation();
        connectPlayerToLevel();
        connectPlayerToLocations();
        connectPlayerToInventory();
        connectLevelsToLocation();
        connectLevelsToLevels();
        connectLocationsToItems();
        connectLocationsToFriendlyNPCs();
        connectLocationsToEnemyNPCs();
        connectLocationsToHashMap();
        connectItemsToItems();
        connectItemsToNPCs();
        connectNPCToItems();
        connectNPCToNPC();
        connectInventoryToItems();
    }

    private static void connectPlayerToLocation() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            if (playerStats.getCurrentLocationID() == location.getId()) {
                playerStats.setCurrentLocation(location);
            }
        }
    }

    private static void connectPlayerToLevel() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        for (Level level : InitOfClassesThroughSaveFile.getLevels()) {
            if (playerStats.getCurrentLevelID() == level.getId()) {
                playerStats.setCurrentLevel(level);
            }
        }
    }

    private static void connectPlayerToLocations() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        for (int listLocationID : playerStats.getListOfMovedLocationsIDs()) {
            for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
                if (listLocationID == location.getId()) {
                    playerStats.getListOfMovedLocations().add(location);
                    break;
                }
            }
        }
    }

    private static void connectPlayerToInventory() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Inventory inv = InitOfClassesThroughSaveFile.getInventory();

        playerStats.setInventory(inv);
    }

    // Connect all levels to their starting locations
    private static void connectLevelsToLocation() {
        // Loop through all levels in the game
        for (Level level : InitOfClassesThroughSaveFile.getLevels()) {
            // Go through all location until we find the one that is i's level starting location
            for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
                if (level.getStartLocationID() == location.getId()) {
                    level.setStartLocation(location);
                    break;
                }
            }
        }
    }

    private static void connectLevelsToLevels() {
        for (Level level : InitOfClassesThroughSaveFile.getLevels()) {
            for (Level levelToAssign : InitOfClassesThroughSaveFile.getLevels()) {
                if (level.getNextLevelID() == levelToAssign.getId()) {
                    level.setNextLevel(levelToAssign);
                    break;
                }
            }
        }
    }

    private static void connectLocationsToItems() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            if (location.getListOfItemsIDs().size() > 0) {
                ArrayList<Item> newListOfItems = new ArrayList<>();

                for (Integer id : location.getListOfItemsIDs()) {
                    for (Item item : InitOfClassesThroughSaveFile.getItems()) {
                        if (id == item.getId()) {
                            newListOfItems.add(item);
                            break;
                        }
                    }
                }

                location.setListOfItems(newListOfItems);
            }
        }
    }

    private static void connectLocationsToFriendlyNPCs() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            ArrayList<NPC> newListOfFriendlyNPCs = new ArrayList<>();

            for (Integer id : location.getListOfFriendlyNPCsIDs()) {
                for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
                    if (id == npc.getId()) {
                        newListOfFriendlyNPCs.add(npc);
                        break;
                    }
                }
            }

            location.setListOfFriendlyNPCs(newListOfFriendlyNPCs);
        }
    }

    private static void connectLocationsToEnemyNPCs() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            ArrayList<NPC> newListOfEnemyNPCs = new ArrayList<>();

            for (Integer id : location.getListOfEnemyNPCsIDs()) {
                for (NPC npc : InitOfClassesThroughSaveFile.getEnemyNPCs()) {
                    if (id == npc.getId()) {
                        newListOfEnemyNPCs.add(npc);
                        break;
                    }
                }
            }

            location.setListOfEnemyNPCs(newListOfEnemyNPCs);
        }
    }

    private static void connectLocationsToHashMap() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            HashMap<String, Location> newListOfConnectedLocations = new HashMap<>();

            for (Map.Entry<String, Integer> integerEntry : location.getListOfConnectedLocationsIDs().entrySet()) {
                for (Location possibleConnectedLocation : InitOfClassesThroughSaveFile.getLocations()) {
                    if (integerEntry.getValue() == possibleConnectedLocation.getId()) {
                        newListOfConnectedLocations.put(integerEntry.getKey(), possibleConnectedLocation);
                        break;
                    }
                }
            }

            location.setListOfConnectedLocations(newListOfConnectedLocations);
        }
    }

    private static void connectItemsToItems() {
        for (Item item : InitOfClassesThroughSaveFile.getItems()) {
            for (Item itemToConnect : InitOfClassesThroughSaveFile.getItems()) {
                if (item.getItemToBreakWithID() == itemToConnect.getId()) {
                    item.setItemToBreakWith(itemToConnect);
                }
                if (item.getItemToBeUsedByID() == itemToConnect.getId()) {
                    item.setItemToBeUsedBy(itemToConnect);
                }
                if (item.getItemToBeUsedOnID() == itemToConnect.getId()) {
                    item.setItemToBeUsedOn(itemToConnect);
                }
                if (item.getItemToCutWithID() == itemToConnect.getId()) {
                    item.setItemToCutWith(itemToConnect);
                }
                if (item.getItemToListenWithID() == itemToConnect.getId()) {
                    item.setItemToListenWith(itemToConnect);
                }
                if (item.getItemToUnlockWithID() == itemToConnect.getId()) {
                    item.setItemToUnlockWith(itemToConnect);
                }
                if (item.getItemToUnlockID() == itemToConnect.getId()) {
                    item.setItemToUnlock(itemToConnect);
                }
                if (item.getItemToOpenWithID() == itemToConnect.getId()) {
                    item.setItemToOpenWith(itemToConnect);
                }
                if (item.getItemToBeOpenedID() == itemToConnect.getId()) {
                    item.setItemToBeOpened(itemToConnect);
                }
                if (item.getItemToCloseWithID() == itemToConnect.getId()) {
                    item.setItemToCloseWith(itemToConnect);
                }
                if (!item.getItemsToDropOnBreakIDs().isEmpty()) {
                    for (int itemToDropOnBreakID : item.getItemsToDropOnBreakIDs()) {
                        if (itemToDropOnBreakID == itemToConnect.getId()) {
                            item.getItemsToDropOnBreak().add(itemToConnect);
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void connectItemsToNPCs() {
        for (Item item : InitOfClassesThroughSaveFile.getItems()) {
            for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
                if (item.getNpcToListenWithItemToID() == npc.getId()) {
                    item.setNpcToListenWithItemTo(npc);
                }
                if (item.getNpcToGiveItemToID() == npc.getId()) {
                    item.setNpcToGiveItemTo(npc);
                }
            }
        }
    }

    private static void connectNPCToItems() {
        for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
            for (Item item : InitOfClassesThroughSaveFile.getItems()) {
                if (npc.getItemToGiveID() == item.getId()) {
                    npc.setItemToGive(item);
                }
                if (npc.getItemToBeUsedByID() == item.getId()) {
                    npc.setItemToBeUsedBy(item);
                }
                if (npc.getItemToBeUsedOnID() == item.getId()) {
                    npc.setItemToBeUsedOn(item);
                }
                if (npc.getItemToCutWithID() == item.getId()) {
                    npc.setItemToCutWith(item);
                }
                if (npc.getItemToListenWithID() == item.getId()) {
                    npc.setItemToListenWith(item);
                }
                if (npc.getItemToUnlockWithID() == item.getId()) {
                    npc.setItemToUnlockWith(item);
                }
                if (npc.getItemToUnlockID() == item.getId()) {
                    npc.setItemToUnlock(item);
                }
                if (npc.getItemToOpenWithID() == item.getId()) {
                    npc.setItemToOpenWith(item);
                }
                if (npc.getItemToBeOpenedID() == item.getId()) {
                    npc.setItemToBeOpened(item);
                }
                if (npc.getItemToCloseWithID() == item.getId()) {
                    npc.setItemToCloseWith(item);
                }
            }
        }
    }

    private static void connectNPCToNPC() {
        for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
            for (NPC npcToConnect : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
                if (npc.getNpcToGiveItemToID() == npcToConnect.getId()) {
                    npc.setNpcToGiveItemTo(npcToConnect);
                }
            }
        }
    }

    private static void connectInventoryToItems() {
        for (int inventoryItemID : InitOfClassesThroughSaveFile.getInventory().getListOfItemsIDs()) {
            for (Item item : InitOfClassesThroughSaveFile.getItems()) {
                if (inventoryItemID == item.getId()) {
                    InitOfClassesThroughSaveFile.getInventory().getListOfItems().add(item);
                }
            }
        }
    }

    private static void configPrintingDescriptions() {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();

        player.getCurrentLevel().setFirstTimeEnteringLevel(true);
        player.getCurrentLocation().setFirstTimeEnteringLocation(true);
        for (int i = 0; i < player.getCurrentLocation().getListOfItems().size(); i++) {
            player.getCurrentLocation().getListOfItems().get(i).setFirstTimeEnteringLocation(true);
        }
        for (int i = 0; i < player.getCurrentLocation().getListOfFriendlyNPCs().size(); i++) {
            player.getCurrentLocation().getListOfFriendlyNPCs().get(i).setFirstTimeEnteringLocation(true);
        }
    }
}




















