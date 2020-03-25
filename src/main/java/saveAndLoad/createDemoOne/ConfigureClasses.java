package saveAndLoad.createDemoOne;

import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import gameElements.player.PlayerLevellingProgression;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStandardClasses;
import input.validation.InputValidation;
import input.validation.Validation;
import input.validation.WordValidation;
import output.StoryTextGetter;

public class ConfigureClasses {
    public static void configureEverything() {
        configurePlayer();
        configureWordValidation();
        //might need to configure inv for other demos
        configureValidation();
        configureStoryTextGetter();
        configureStoryTextPrinter();
        configurePlayerProgression();
        configureItems();
        configureLocations();
        configureLevels();
        configureNPCs();
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
        WordValidation wordValidation = InitOfStandardClasses.getWordValidation();
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        wordValidation.setPlayerStats(playerStats);
    }

    public static void configureValidation() {
        Validation validation = InitOfStandardClasses.getValidation();
        WordValidation wordValidation = InitOfStandardClasses.getWordValidation();
        InputValidation inputValidation = InitOfStandardClasses.getInputValidation();

        validation.setWordValidation(wordValidation);
        validation.setInputValidation(inputValidation);
    }

    public static void configureStoryTextGetter() {
        StoryTextGetter storyTextGetter = InitOfStandardClasses.getStoryTextGetter();
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        storyTextGetter.setPlayerStats(playerStats);
    }

    public static void configureStoryTextPrinter() {
        //Currently unfinished as of 23.03 10:30
    }

    public static void configurePlayerProgression() {
        PlayerLevellingProgression playerLevellingProgression = InitOfStandardClasses.getPlayerProgression();
        PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();

        playerLevellingProgression.setPlayerStats(playerStats);
    }

    public static void configureItems() {
        //Waiting for Item Class to be finished
    }

    public static void configureLocations() {
        //Waiting for Item Class to be finished
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

    public static void configureNPCs() {
        //Waiting for NPC Class to be finished
    }
}
