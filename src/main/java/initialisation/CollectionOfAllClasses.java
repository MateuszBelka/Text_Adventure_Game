package initialisation;

import gameElements.player.*;
import gameElements.levelAndContents.*;
import input.validation.InputValidation;
import input.validation.Validation;
import input.validation.WordValidation;
import storyText.StoryTextGetter;
import storyText.StoryTextPrinter;

import java.util.ArrayList;

/*
 * Benefit of maintaining all variables as static in a class
 * that will always have only one instance at a time is that
 * no one has to ever keep track of instances of the class
 * and in case they have to be created,
 * then they can be immediately set to null (deleted)
 */
public class CollectionOfAllClasses {
    private static Player player;
    private static WordValidation wordValidation;
    private static Inventory inventory;
    private static Validation validation;
    private static InputValidation inputValidation;
    private static StoryTextGetter storyTextGetter;
    private static StoryTextPrinter storyTextPrinter;
    private static PlayerProgression playerProgression;
    private static ArrayList<Level> levels;
    private static ArrayList<Location> locations;
    private static ArrayList<Item> items;
    private static ArrayList<NPC> npcs;

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

    public static PlayerProgression getPlayerProgression() {
        return playerProgression;
    }

    public static InputValidation getInputValidation() {
        return inputValidation;
    }

    public Validation getValidation() {
        return validation;
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