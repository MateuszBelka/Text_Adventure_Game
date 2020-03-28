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
import gameElements.levelAndContents.NPC;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import gameElements.player.PlayerLevellingProgression;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStoryIndependentClasses;
import input.validation.WordValidation;
import output.StoryTextGetter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Load {

    /*
     * Parameters: String with the location of json file
     * containing information about CollectionOfAllClasses
     *
     * Creates an instance of CollectionOfAllClasses
     * which contains information required to reconstruct
     * a game from any moment in terms of player's progress.
     *
     * Since all variables of CollectionOfAllClasses are static
     * the actual instance
     */
    public static void loadGameSave(String fileName) throws IOException {
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
        connectPlayerToInventory();
        connectLevelsToLocation();
        connectLocationsToItems();
        connectLocationsToNPCs();
        connectLocationsToHashMap();
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

    private static void connectLocationsToNPCs() {
        for (Location location : InitOfClassesThroughSaveFile.getLocations()) {
            ArrayList<NPC> newListOfNPCs = new ArrayList<>();

            for (Integer id : location.getListOfNPCsIDs()) {
                for (NPC npc : InitOfClassesThroughSaveFile.getNpcs()) {
                    if (id == npc.getId()) {
                        newListOfNPCs.add(npc);
                        break;
                    }
                }
            }

            location.setListOfNPCs(newListOfNPCs);
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
}






















