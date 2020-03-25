package saveAndLoad.createDemoOne;

import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.player.Inventory;
import gameElements.player.Player;
import gameElements.player.PlayerProgression;
import initialisation.CollectionOfAllClasses;
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
        Player player = CollectionOfAllClasses.getPlayer();
        Inventory inventory = CollectionOfAllClasses.getInventory();
        Level level0 = CollectionOfAllClasses.getLevels().get(0);

        player.setCurrentLevel(level0);
        player.setCurrentLocation(level0.getStartLocation());
        player.setInventory(inventory);
    }

    public static void configureWordValidation() {
        WordValidation wordValidation = CollectionOfAllClasses.getWordValidation();
        Player player = CollectionOfAllClasses.getPlayer();

        wordValidation.setPlayer(player);
    }

    public static void configureValidation() {
        Validation validation = CollectionOfAllClasses.getValidation();
        WordValidation wordValidation = CollectionOfAllClasses.getWordValidation();
        InputValidation inputValidation = CollectionOfAllClasses.getInputValidation();

        validation.setWordValidation(wordValidation);
        validation.setInputValidation(inputValidation);
    }

    public static void configureStoryTextGetter() {
        StoryTextGetter storyTextGetter = CollectionOfAllClasses.getStoryTextGetter();
        Player player = CollectionOfAllClasses.getPlayer();

        storyTextGetter.setPlayer(player);
    }

    public static void configureStoryTextPrinter() {
        //Currently unfinished as of 23.03 10:30
    }

    public static void configurePlayerProgression() {
        PlayerProgression playerProgression = CollectionOfAllClasses.getPlayerProgression();
        Player player = CollectionOfAllClasses.getPlayer();

        playerProgression.setPlayer(player);
    }

    public static void configureItems() {
        //Waiting for Item Class to be finished
    }

    public static void configureLocations() {
        //Waiting for Item Class to be finished
    }

    public static void configureLevels() {
        Level level0 = CollectionOfAllClasses.getLevels().get(0);
        Location location0 = CollectionOfAllClasses.getLocations().get(0);

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
