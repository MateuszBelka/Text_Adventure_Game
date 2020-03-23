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
import gameElements.player.Player;
import gameElements.player.PlayerProgression;
import initialisation.CollectionOfAllClasses;
import input.validation.WordValidation;
import storyText.StoryTextGetter;
import sun.plugin2.message.GetAppletMessage;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
    public static void loadGameSave(String fileName) throws FileNotFoundException {
        // Create instances of all classes and populate majority of their variables using provided Json file.
        initializeClassesFromJson(fileName);

        // Convert ID variables to their expected object references.
        decodeIDsToObjects();
    }

    private static void initializeClassesFromJson(String fileName) throws FileNotFoundException {
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
        FileReader jsonFile = new FileReader(fileName);

        // Populate static variables of CollectionOfAllClasses from json file.
        CollectionOfAllClasses loadNewGameObjects = gson.fromJson(jsonFile, CollectionOfAllClasses.class);

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
        connectWordValidatorToPlayer();
        connectStoryTextGetterToPlayer();
        connectPlayerProgressToPlayer();
        connectLevelsToLocation();
        connectLocationsToItems();
        connectLocationsToNPCs();
        connectLocationsToHashMap();
    }

    private static void connectPlayerToLocation() {
        Player player = CollectionOfAllClasses.getPlayer();
        for (Location location : CollectionOfAllClasses.getLocations()) {
            if (player.getCurrentLocationID() == location.getId()) {
                player.setCurrentLocation(location);
            }
        }
    }

    private static void connectPlayerToLevel() {
        Player player = CollectionOfAllClasses.getPlayer();
        for (Level level : CollectionOfAllClasses.getLevels()) {
            if (player.getCurrentLevelID() == level.getId()) {
                player.setCurrentLevel(level);
            }
        }
    }

    private static void connectPlayerToInventory() {
        Player player = CollectionOfAllClasses.getPlayer();
        Inventory inv = CollectionOfAllClasses.getInventory();

        player.setInventory(inv);
    }

    private static void connectWordValidatorToPlayer() {
        WordValidation wordValidation = CollectionOfAllClasses.getWordValidation();
        Player player = CollectionOfAllClasses.getPlayer();

        wordValidation.setPlayer(player);
    }

    private static void connectStoryTextGetterToPlayer() {
        StoryTextGetter getter = CollectionOfAllClasses.getStoryTextGetter();
        Player player = CollectionOfAllClasses.getPlayer();

        getter.setPlayer(player);
    }

    private static void connectPlayerProgressToPlayer() {
        PlayerProgression progression = CollectionOfAllClasses.getPlayerProgression();
        Player player = CollectionOfAllClasses.getPlayer();

        progression.setPlayer(player);
    }

    // Connect all levels to their starting locations
    private static void connectLevelsToLocation() {
        // Loop through all levels in the game
        for (Level level : CollectionOfAllClasses.getLevels()) {
            // Go through all location until we find the one that is i's level starting location
            for (Location location : CollectionOfAllClasses.getLocations()) {
                if (level.getStartLocationID() == location.getId()) {
                    level.setStartLocation(location);
                    break;
                }
            }
        }
    }

    private static void connectLocationsToItems() {
        for (Location location : CollectionOfAllClasses.getLocations()) {
            ArrayList<Item> newListOfItems = new ArrayList<>();

            for (Integer id : location.getListOfItemsIDs()) {
                for (Item item : CollectionOfAllClasses.getItems()) {
                    if (id == item.getId()) {
                        newListOfItems.add(item);
                        break;
                    }
                }
            }

            location.setListOfItems(newListOfItems);
        }
    }

    private static void connectLocationsToNPCs() {
        for (Location location : CollectionOfAllClasses.getLocations()) {
            ArrayList<NPC> newListOfNPCs = new ArrayList<>();

            for (Integer id : location.getListOfNPCsIDs()) {
                for (NPC npc : CollectionOfAllClasses.getNpcs()) {
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
        for (Location location : CollectionOfAllClasses.getLocations()) {
            HashMap<String, Location> newListOfConnectedLocations = new HashMap<>();

            for (Map.Entry<String, Integer> integerEntry : location.getListOfConnectedLocationsIDs().entrySet()) {
                for (Location possibleConnectedLocation : CollectionOfAllClasses.getLocations()) {
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






















