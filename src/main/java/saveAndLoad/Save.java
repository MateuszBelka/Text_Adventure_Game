package saveAndLoad;

import com.google.gson.Gson;
import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import gameElements.player.Inventory;
import gameElements.player.Player;
import initialisation.CollectionOfAllClasses;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Save {

    public static void writeGameSave(String fileName) {
        encodeIDsOfObjects();
        populateJsonWithClasses(fileName);
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
        Player player = CollectionOfAllClasses.getPlayer();
        Location currentLocation = player.getCurrentLocation();

        player.setCurrentLocationID(currentLocation.getId());
    }

    private static void connectPlayerToLevel() {
        Player player = CollectionOfAllClasses.getPlayer();
        Level currentLevel = player.getCurrentLevel();

        player.setCurrentLevelID(currentLevel.getId());
    }

    private static void connectLevelsToLocation() {
        for (Level level : CollectionOfAllClasses.getLevels()) {
            Location startLocation = level.getStartLocation();
            level.setStartLocationID(startLocation.getId());
        }
    }

    private static void connectLocationsToItems() {
        for (Location location : CollectionOfAllClasses.getLocations()) {
            ArrayList<Integer> newListOfItemsIDs = new ArrayList<>();

            for (Item item : location.getListOfItems()) {
                newListOfItemsIDs.add(item.getId());
            }

            location.setListOfItemsIDs(newListOfItemsIDs);
        }
    }

    private static void connectLocationsToNPCs() {
        for (Location location : CollectionOfAllClasses.getLocations()) {
            ArrayList<Integer> newListOfNPCsIDs = new ArrayList<>();

            for (NPC npc : location.getListOfNPCs()) {
                newListOfNPCsIDs.add(npc.getId());
            }

            location.setListOfNPCsIDs(newListOfNPCsIDs);
        }
    }

    private static void connectLocationsToHashMap() {
        for (Location location : CollectionOfAllClasses.getLocations()) {
            HashMap<String, Integer> newListOfConnectedLocationsIDs = new HashMap<>();

            for (Map.Entry<String, Location> locationEntry : location.getListOfConnectedLocations().entrySet()) {
                newListOfConnectedLocationsIDs.put(locationEntry.getKey(), locationEntry.getValue().getId());
            }

            location.setListOfConnectedLocationsIDs(newListOfConnectedLocationsIDs);
        }
    }

    private static void populateJsonWithClasses(String fileName) {
        CollectionOfAllClasses saveGameObjects = new CollectionOfAllClasses();
        Gson gson = new Gson();
        String json = gson.toJson(saveGameObjects);

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}