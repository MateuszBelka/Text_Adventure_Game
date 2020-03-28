package saveAndLoad;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
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
        setIDsOfNPCs();
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

    private static void setIDsOfNPCs() {
        int id = 1;
        for (NPC npc : InitOfClassesThroughSaveFile.getNpcs()) {
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
        /*
         * TODO:
         *  Check the following classes for possible IDs
         *  when they will be implemented:
         *  -Inventory
         *  -StoryTextPrinter
         *  -Item
         *  -NPC
         */
        connectPlayerToLocation();
        connectPlayerToLevel();
        connectLevelsToLocation();
        connectLocationsToItems();
        connectLocationsToNPCs();
        connectLocationsToHashMap();
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

    private static void connectLevelsToLocation() {
        for (Level level : InitOfClassesThroughSaveFile.getLevels()) {
            Location startLocation = level.getStartLocation();
            level.setStartLocationID(startLocation.getId());
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

    private static void connectLocationsToNPCs() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            ArrayList<Integer> newListOfNPCsIDs = new ArrayList<>();

            for (NPC npc : location.getListOfNPCs()) {
                newListOfNPCsIDs.add(npc.getId());
            }

            location.setListOfNPCsIDs(newListOfNPCsIDs);
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