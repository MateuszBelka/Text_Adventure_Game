package initialisation;

import gameElements.levelAndContents.npc.NPC;
import gameElements.player.*;
import gameElements.levelAndContents.*;

import java.util.ArrayList;

/*
 * Benefit of maintaining all variables as static in a class
 * that will always have only one instance at a time is that
 * no one has to ever keep track of instances of the class
 * and in case they have to be created,
 * then they can be immediately set to null (deleted)
 */
public class InitOfClassesThroughSaveFile {
    private static ArrayList<Item> items;
    private static ArrayList<Level> levels;
    private static ArrayList<Location> locations;
    private static ArrayList<NPC> friendlyNPCs;
    private static ArrayList<NPC> enemyNPCs;
    private static Inventory inventory;
    private static PlayerStats playerStats;

    //Setters
    public static void setItems(ArrayList<Item> items) {
        InitOfClassesThroughSaveFile.items = items;
    }

    public static void setLevels(ArrayList<Level> levels) {
        InitOfClassesThroughSaveFile.levels = levels;
    }

    public static void setLocations(ArrayList<Location> locations) {
        InitOfClassesThroughSaveFile.locations = locations;
    }

    public static void setFriendlyNPCs(ArrayList<NPC> friendlyNPCs) {
        InitOfClassesThroughSaveFile.friendlyNPCs = friendlyNPCs;
    }

    public static ArrayList<NPC> getEnemyNPCs() {
        return enemyNPCs;
    }

    public static void setEnemyNPCs(ArrayList<NPC> enemyNPCs) {
        InitOfClassesThroughSaveFile.enemyNPCs = enemyNPCs;
    }

    public static void setInventory(Inventory inventory) {
        InitOfClassesThroughSaveFile.inventory = inventory;
    }

    public static void setPlayerStats(PlayerStats playerStats) {
        InitOfClassesThroughSaveFile.playerStats = playerStats;
    }

    //Getters
    public static ArrayList<Item> getItems() {
        return items;
    }

    public static ArrayList<Level> getLevels() {
        return levels;
    }

    public static ArrayList<Location> getLocations() {
        return locations;
    }

    public static ArrayList<NPC> getFriendlyNPCs() {
        return friendlyNPCs;
    }

    public static Inventory getInventory() {
        return inventory;
    }

    public static PlayerStats getPlayerStats() {
        return playerStats;
    }
}