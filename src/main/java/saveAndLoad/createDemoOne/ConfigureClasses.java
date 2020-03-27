package saveAndLoad.createDemoOne;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import gameElements.player.PlayerLevellingProgression;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStoryIndependentClasses;
import input.validation.InputValidation;
import input.validation.Validation;
import input.validation.WordValidation;
import output.StoryTextGetter;

import java.util.ArrayList;
import java.util.HashMap;

public class ConfigureClasses {
    public static void configureEverything() {
        //File Dependent
        configureItems();
        configureLevels();
        configureLocations();
        configureNPCs();
        configureInventory();
        configurePlayer();

        //File Independent
        configureWordValidation();
        configureValidation();
        configureStoryTextGetter();
        configureStoryTextPrinter();
        configurePlayerProgression();
    }

    public static void configureItems() {
        Item item0 = InitOfClassesThroughSaveFile.getItems().get(0);

        item0.setName("item0");
        item0.setDescription("temporary description for item0");
        item0.setDescriptionAfterPuzzleComplete("temporary description for puzzle complete for item0");
        //...//
        item0.setCanBePickedUp(true);
    }

    public static void configureLevels() {
        Level level0 = InitOfClassesThroughSaveFile.getLevels().get(0);
        Location location0 = InitOfClassesThroughSaveFile.getLocations().get(0);

        level0.setId(1);
        level0.setDescription("test description for level0");
        level0.setName("test name for level0");
        level0.setFirstTimeEnteringLevel(true);
        level0.setPuzzles();
        level0.setStartLocation(location0);
    }

    public static void configureLocations() {
        Location location0 = InitOfClassesThroughSaveFile.getLocations().get(0);
        Location location1 = InitOfClassesThroughSaveFile.getLocations().get(1);
        Item item0 = InitOfClassesThroughSaveFile.getItems().get(0);

        HashMap<String, Location> location0Connections = new HashMap<>();
        location0Connections.put("north",location1);
        location0.setListOfConnectedLocations(location0Connections);
        ArrayList<Item> location0items = new ArrayList<>();
        location0items.add(item0);
        location0.setListOfItems(location0items);
        location0.setDescription("temporary description for location0.");
        location0.setName("location0");


        HashMap<String, Location> location1Connections = new HashMap<>();
        location0Connections.put("south",location0);
        location1.setListOfConnectedLocations(location1Connections);
        location1.setDescription("temporary description for location1.");
        location1.setName("location1");
    }

    public static void configureNPCs() {
        //No npcs here
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



    public static void configureWordValidation() {
        WordValidation wordValidation = InitOfStoryIndependentClasses.getWordValidation();
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        wordValidation.setPlayerStats(playerStats);
    }

    public static void configureValidation() {
        Validation validation = InitOfStoryIndependentClasses.getValidation();
        WordValidation wordValidation = InitOfStoryIndependentClasses.getWordValidation();
        InputValidation inputValidation = InitOfStoryIndependentClasses.getInputValidation();

        validation.setWordValidation(wordValidation);
        validation.setInputValidation(inputValidation);
    }

    public static void configureStoryTextGetter() {
        StoryTextGetter storyTextGetter = InitOfStoryIndependentClasses.getStoryTextGetter();
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        storyTextGetter.setPlayerStats(playerStats);
    }

    public static void configureStoryTextPrinter() {
        //Currently unfinished as of 23.03 10:30
    }

    public static void configurePlayerProgression() {
        PlayerLevellingProgression playerLevellingProgression = InitOfStoryIndependentClasses.getPlayerProgression();
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        playerLevellingProgression.setPlayerStats(playerStats);
    }


}