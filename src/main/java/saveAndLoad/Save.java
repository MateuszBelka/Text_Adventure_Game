package saveAndLoad;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Save {

    public static void writeGameSave(String fileName) {
        setIDsOfObjects();
        encodeIDsOfObjects();
        populateJsonWithClasses(fileName);
    }

    private static void setIDsOfObjects() {
        setIDsOfItems();
        setIDsOfLevels();
        setIDsOfLocations();
        setIDsOfFriendlyNPCs();
        setIDsOfEnemyNPCs();
    }

    private static void setIDsOfItems() {
        int id = 1;
        for (Item item : InitOfClassesThroughSaveFile.getItems()) {
            item.setId(id);
            id++;
        }
    }

    private static void setIDsOfLevels() {
        int id = 1;
        for (Level level : InitOfClassesThroughSaveFile.getLevels()) {
            level.setId(id);
            id++;
        }
    }

    private static void setIDsOfLocations() {
        int id = 1;
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            location.setId(id);
            id++;
        }
    }

    private static void setIDsOfFriendlyNPCs() {
        int id = 1;
        for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
            npc.setId(id);
            id++;
        }
    }

    private static void setIDsOfEnemyNPCs() {
        int id = 1;
        for (NPC npc : InitOfClassesThroughSaveFile.getEnemyNPCs()) {
            npc.setId(id);
            id++;
        }
    }

    /*
     * Allows us to maintain the object references even through
     * serialisation by establishing id link instead of pointer reference.
     *
     * The following method updates the values of all IDs.
     */
    private static void encodeIDsOfObjects() {
        connectPlayerToLocation();
        connectPlayerToLevel();
        connectPlayerToLocations();
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
        Location currentLocation = playerStats.getCurrentLocation();

        playerStats.setCurrentLocationID(currentLocation.getId());
    }

    private static void connectPlayerToLevel() {
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
        Level currentLevel = playerStats.getCurrentLevel();

        playerStats.setCurrentLevelID(currentLevel.getId());
    }

    private static void connectPlayerToLocations() {
        for (Location location : InitOfClassesThroughSaveFile.getPlayerStats().getListOfMovedLocations()) {
            InitOfClassesThroughSaveFile.getPlayerStats().getListOfMovedLocationsIDs().add(location.getId());
        }
    }

    private static void connectLevelsToLocation() {
        for (Level level : InitOfClassesThroughSaveFile.getLevels()) {
            Location startLocation = level.getStartLocation();
            level.setStartLocationID(startLocation.getId());
        }
    }

    private static void connectLevelsToLevels() {
        for (Level level : InitOfClassesThroughSaveFile.getLevels()) {
            level.setNextLevelID(level.getNextLevel().getId());
        }
    }

    private static void connectLocationsToItems() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            ArrayList<Integer> newListOfItemsIDs = new ArrayList<>();

            for (Item item : location.getListOfItems()) {
                newListOfItemsIDs.add(item.getId());
            }

            location.setListOfItemsIDs(newListOfItemsIDs);
        }
    }

    private static void connectLocationsToFriendlyNPCs() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            ArrayList<Integer> newListOfFriendlyNPCsIDs = new ArrayList<>();

            for (NPC npc : location.getListOfFriendlyNPCs()) {
                newListOfFriendlyNPCsIDs.add(npc.getId());
            }

            location.setListOfFriendlyNPCsIDs(newListOfFriendlyNPCsIDs);
        }
    }

    private static void connectLocationsToEnemyNPCs() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            ArrayList<Integer> newListOfEnemyNPCsIDs = new ArrayList<>();

            for (NPC npc : location.getListOfEnemyNPCs()) {
                newListOfEnemyNPCsIDs.add(npc.getId());
            }

            location.setListOfEnemyNPCsIDs(newListOfEnemyNPCsIDs);
        }
    }

    private static void connectLocationsToHashMap() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            HashMap<String, Integer> newListOfConnectedLocationsIDs = new HashMap<>();

            for (Map.Entry<String, Location> locationEntry : location.getListOfConnectedLocations().entrySet()) {
                newListOfConnectedLocationsIDs.put(locationEntry.getKey(), locationEntry.getValue().getId());
            }

            location.setListOfConnectedLocationsIDs(newListOfConnectedLocationsIDs);
        }
    }

    private static void connectItemsToNPCs() {
        for (Item item : InitOfClassesThroughSaveFile.getItems()) {
            for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
                if (item.getNpcToListenWithItemTo().getId() == npc.getId()) {
                    item.setNpcToListenWithItemToID(npc.getId());
                }
                if (item.getNpcToGiveItemTo().getId() == npc.getId()) {
                    item.setNpcToGiveItemToID(npc.getId());
                }
            }
        }
    }

    private static void connectItemsToItems() {
        for (Item item : InitOfClassesThroughSaveFile.getItems()) {
            for (Item itemToConnect : InitOfClassesThroughSaveFile.getItems()) {
                if (item.getItemToBreakWith().getId() == itemToConnect.getId()) {
                    item.setItemToBreakWithID(itemToConnect.getId());
                }
                if (item.getItemToBeUsedBy().getId() == itemToConnect.getId()) {
                    item.setItemToBeUsedByID(itemToConnect.getId());
                }
                if (item.getItemToBeUsedOn().getId() == itemToConnect.getId()) {
                    item.setItemToBeUsedOnID(itemToConnect.getId());
                }
                if (item.getItemToCutWith().getId() == itemToConnect.getId()) {
                    item.setItemToCutWithID(itemToConnect.getId());
                }
                if (item.getItemToListenWith().getId() == itemToConnect.getId()) {
                    item.setItemToListenWithID(itemToConnect.getId());
                }
                if (item.getItemToUnlockWith().getId() == itemToConnect.getId()) {
                    item.setItemToUnlockWithID(itemToConnect.getId());
                }
                if (item.getItemToUnlock().getId() == itemToConnect.getId()) {
                    item.setItemToUnlockID(itemToConnect.getId());
                }
                if (item.getItemToOpenWith().getId() == itemToConnect.getId()) {
                    item.setItemToOpenWithID(itemToConnect.getId());
                }
                if (item.getItemToBeOpened().getId() == itemToConnect.getId()) {
                    item.setItemToBeOpenedID(itemToConnect.getId());
                }
                if (item.getItemToCloseWith().getId() == itemToConnect.getId()) {
                    item.setItemToCloseWithID(itemToConnect.getId());
                }
            }
        }
    }

    private static void connectNPCToNPC() {
        for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
            for (NPC npcToConnect : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
                if (npc.getNpcToGiveItemTo().getId() == npcToConnect.getId()) {
                    npc.setNpcToGiveItemToID(npcToConnect.getId());
                }
            }
        }
    }

    private static void connectNPCToItems() {
        for (NPC npc : InitOfClassesThroughSaveFile.getFriendlyNPCs()) {
            for (Item item : InitOfClassesThroughSaveFile.getItems()) {
                if (npc.getItemToGive().getId() == item.getId()) {
                    npc.setItemToGiveID(item.getId());
                }
                if (npc.getItemToBeUsedBy().getId() == item.getId()) {
                    npc.setItemToBeUsedByID(item.getId());
                }
                if (npc.getItemToBeUsedOn().getId() == item.getId()) {
                    npc.setItemToBeUsedOnID(item.getId());
                }
                if (npc.getItemToCutWith().getId() == item.getId()) {
                    npc.setItemToCutWithID(item.getId());
                }
                if (npc.getItemToListenWith().getId() == item.getId()) {
                    npc.setItemToListenWithID(item.getId());
                }
                if (npc.getItemToUnlockWith().getId() == item.getId()) {
                    npc.setItemToUnlockWithID(item.getId());
                }
                if (npc.getItemToUnlock().getId() == item.getId()) {
                    npc.setItemToUnlockID(item.getId());
                }
                if (npc.getItemToOpenWith().getId() == item.getId()) {
                    npc.setItemToOpenWithID(item.getId());
                }
                if (npc.getItemToBeOpened().getId() == item.getId()) {
                    npc.setItemToBeOpenedID(item.getId());
                }
                if (npc.getItemToCloseWith().getId() == item.getId()) {
                    npc.setItemToCloseWithID(item.getId());
                }
            }
        }
    }

    private static void connectInventoryToItems() {
        for (Item inventoryItem : InitOfClassesThroughSaveFile.getInventory().getListOfItems()) {
            InitOfClassesThroughSaveFile.getInventory().getListOfItemsIDs().add(inventoryItem.getId());
        }
    }

    private static void populateJsonWithClasses(String fileName) {
        try {
            InitOfClassesThroughSaveFile saveGameObjects = new InitOfClassesThroughSaveFile();
            FileWriter fileWriter = new FileWriter(fileName);
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithModifiers(java.lang.reflect.Modifier.TRANSIENT)
                    .setPrettyPrinting()
                    .create();


            gson.toJson(saveGameObjects, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}