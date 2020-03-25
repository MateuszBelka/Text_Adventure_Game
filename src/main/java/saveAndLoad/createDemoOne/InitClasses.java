package saveAndLoad.createDemoOne;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.NPC;
import gameElements.player.Inventory;
import gameElements.player.PlayerStats;
import gameElements.player.PlayerLevellingProgression;
import initialisation.InitOfClassesThroughSaveFile;
import input.validation.InputValidation;
import input.validation.Validation;
import input.validation.WordValidation;
import output.StoryTextGetter;
import output.StoryTextPrinter;

import java.util.ArrayList;

public class InitClasses {
    public static void initEverything() {
        InitOfClassesThroughSaveFile.setPlayerStats(initPlayer());
        InitOfClassesThroughSaveFile.setWordValidation(initWordValidation());
        InitOfClassesThroughSaveFile.setInventory(initInventory());
        InitOfClassesThroughSaveFile.setValidation(initValidation());
        InitOfClassesThroughSaveFile.setInputValidation(initInputValidation());
        InitOfClassesThroughSaveFile.setStoryTextGetter(initStoryTextGetter());
        InitOfClassesThroughSaveFile.setStoryTextPrinter(initStoryTextPrinter());
        InitOfClassesThroughSaveFile.setPlayerProgression(initPlayerProgression());
        InitOfClassesThroughSaveFile.setLevels(initLevels());
        InitOfClassesThroughSaveFile.setLocations(initLocations());
        InitOfClassesThroughSaveFile.setItems(initItems());
        InitOfClassesThroughSaveFile.setNpcs(initNPC());
    }

    public static PlayerStats initPlayer() {
        return new PlayerStats();
    }

    public static WordValidation initWordValidation() {
        return new WordValidation();
    }

    public static Inventory initInventory() {
        return new Inventory();
    }

    public static Validation initValidation() {
        return new Validation();
    }

    public static InputValidation initInputValidation() {
        return new InputValidation();
    }

    public static StoryTextGetter initStoryTextGetter() {
        return new StoryTextGetter();
    }

    public static StoryTextPrinter initStoryTextPrinter() {
        return new StoryTextPrinter();
    }

    public static PlayerLevellingProgression initPlayerProgression() {
        return new PlayerLevellingProgression();
    }

    public static ArrayList<Level> initLevels() {
        ArrayList<Level> listOfLevels = new ArrayList<>();
        Level level0 = new Level();

        listOfLevels.add(level0);
        return listOfLevels;
    }

    public static ArrayList<Location> initLocations() {
        ArrayList<Location> listOfLocations = new ArrayList<>();
        Location location0 = new Location();
        Location location1 = new Location();

        listOfLocations.add(location0);
        listOfLocations.add(location1);
        return listOfLocations;
    }

    public static ArrayList<Item> initItems() {
        ArrayList<Item> listOfItems = new ArrayList<>();
        Item item0 = new Item();

        listOfItems.add(item0);
        return listOfItems;
    }

    public static ArrayList<NPC> initNPC() {
        ArrayList<NPC> listOfNPCs = new ArrayList<>();
        NPC npc = new NPC();

        listOfNPCs.add(npc);
        return listOfNPCs;
    }
}
