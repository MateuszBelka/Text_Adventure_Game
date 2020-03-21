package initialisation;

import gameElements.player.*;
import gameElements.levelAndContents.*;
import input.commands.CommandHandler;
import input.validation.InputValidation;
import input.validation.WordValidation;
import storyText.StoryTextGetter;
import storyText.StoryTextPrinter;
//import input.*;
//import output.*;

import java.util.ArrayList;


public class CollectionOfAllClasses {
    String name; // TESTER FOR LOADING AND SAVING
    private static Player player;
    private static WordValidation wordValidation;
    private static Inventory inventory;
    private static InputValidation inputValidation;
    private static CommandHandler commandHandler;
    private static StoryTextGetter storyTextGetter;
    private static StoryTextPrinter storyTextPrinter;
    private static PlayerProgress playerProgress;
    private static ArrayList<Level> levels;
    private static ArrayList<Location> locations;
    private static ArrayList<Item> items;
    private static ArrayList<NPC> npcs;

    public CollectionOfAllClasses(String name){this.name = name;}

    public String getName() {
        return name;
    }

    public static ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }

    public static ArrayList<NPC> getNpcs() {
        return npcs;
    }

    public static Inventory getInventory() {
        return inventory;
    }

    public static Player getPlayer() {
        return player;
    }

    public static PlayerProgress getPlayerProgress() {
        return playerProgress;
    }

    public static CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public InputValidation getInputValidation() {
        return inputValidation;
    }

    public static WordValidation getWordValidation() {
        return wordValidation;
    }

    public static StoryTextGetter getStoryTextGetter() {
        return storyTextGetter;
    }

    public static StoryTextPrinter getStoryTextPrinter() {
        return storyTextPrinter;
    }

    public static ArrayList<Level> getLevels() {
        return levels;
    }

}