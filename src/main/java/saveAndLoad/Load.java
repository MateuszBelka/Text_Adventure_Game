package saveAndLoad;


/*
 * Gson doesn't natively support saving variables which pointer is used by multiple classes.
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
import gameElements.levelAndContents.Location;
import gameElements.player.Player;
import initialisation.CollectionOfAllClasses;

import java.io.FileNotFoundException;
import java.io.FileReader;

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
    public void loadGameSave(String fileName) throws FileNotFoundException {
        // Create instances of all classes and populate majority of their variables using provided Json file.
        initializeClassesFromJson(fileName);

        // Convert ID variables to their expected object references.
        decodeIDsToObjects();
    }

    private void initializeClassesFromJson(String fileName) throws FileNotFoundException {
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

    private void decodeIDsToObjects() {
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
        connectStoryTextGetterToPlayer();
        connectPlayerProgressToPlayer();
        connectLevelToLocation();
        connectLocationToItems();
        connectLocationToNPCs();
        connectLocationToHashMap();
    }

    private void connectPlayerToLocation() {
        Player player = CollectionOfAllClasses.getPlayer();
        for (Location location : CollectionOfAllClasses.getLocations()) {
            //if (player.getCurrentLocationID() == location.get)
        }
    }

    private void connectPlayerToLevel() {

    }

    private void connectPlayerToInventory() {

    }

    private void connectStoryTextGetterToPlayer() {

    }

    private void connectPlayerProgressToPlayer() {

    }

    private void connectLevelToLocation() {

    }

    private void connectLocationToItems() {

    }

    private void connectLocationToNPCs() {

    }

    private void connectLocationToHashMap() {

    }

}






















