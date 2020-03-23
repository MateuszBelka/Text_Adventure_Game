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

    //Get Methods
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
    public static Validation getValidation() {
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

    //Set Methods
    public static void setPlayer(Player player) {
        CollectionOfAllClasses.player = player;
    }
    public static void setWordValidation(WordValidation wordValidation) {
        CollectionOfAllClasses.wordValidation = wordValidation;
    }
    public static void setInventory(Inventory inventory) {
        CollectionOfAllClasses.inventory = inventory;
    }
    public static void setValidation(Validation validation) {
        CollectionOfAllClasses.validation = validation;
    }
    public static void setInputValidation(InputValidation inputValidation) {
        CollectionOfAllClasses.inputValidation = inputValidation;
    }
    public static void setStoryTextGetter(StoryTextGetter storyTextGetter) {
        CollectionOfAllClasses.storyTextGetter = storyTextGetter;
    }
    public static void setStoryTextPrinter(StoryTextPrinter storyTextPrinter) {
        CollectionOfAllClasses.storyTextPrinter = storyTextPrinter;
    }
    public static void setPlayerProgression(PlayerProgression playerProgression) {
        CollectionOfAllClasses.playerProgression = playerProgression;
    }
    public static void setLevels(ArrayList<Level> levels) {
        CollectionOfAllClasses.levels = levels;
    }
    public static void setLocations(ArrayList<Location> locations) {
        CollectionOfAllClasses.locations = locations;
    }
    public static void setItems(ArrayList<Item> items) {
        CollectionOfAllClasses.items = items;
    }
    public static void setNpcs(ArrayList<NPC> npcs) {
        CollectionOfAllClasses.npcs = npcs;
    }
}