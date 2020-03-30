package gameElements.player;

import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

import java.util.ArrayList;

public class PlayerStats {
    private transient Location currentLocation;
    private int currentLocationID;

    private transient Level currentLevel;
    private int currentLevelID;

    private transient Inventory inventory;

    private transient ArrayList<Location> listOfMovedLocations = new ArrayList<>();
    private ArrayList<Integer> listOfMovedLocationsIDs = new ArrayList<>();

    private int damage = 15;
    private int maximumXP = 100;
    private int maxHealth = 100;
    private int maxHunger = 100;
    private int currentHunger = maxHunger;
    private int hungerDrain = 5;
    private int foodHungerIncrease = 15;
    private int foodHealthIncrease = 10;

    private int maxPlayerLevel = 100;
    private int hungerDamage = 20;
    private int currentXP = 0;
    private int currentHealth = maxHealth;
    private int playerLevel = 1;
    private int xpReward = 10;
    private int puzzlesSolvedCount = 0;


    //Get Methods
    public int getXpReward() {
        return xpReward;
    }
    public ArrayList<Location> getListOfMovedLocations() {
        return listOfMovedLocations;
    }
    public ArrayList<Integer> getListOfMovedLocationsIDs() {
        return listOfMovedLocationsIDs;
    }
    public Location getCurrentLocation() {
        return currentLocation;
    }
    public int getCurrentLocationID() {
        return currentLocationID;
    }
    public Level getCurrentLevel() {
        return currentLevel;
    }
    public int getCurrentLevelID() {
        return currentLevelID;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public int getCurrentHunger() {return currentHunger;}
    public int getMaxHunger() {return maxHunger;}
    public int getCurrentHealth() {return currentHealth;}
    public int getCurrentXP() {return currentXP;}
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getMaximumXP() {return maximumXP;}
    public int getPlayerLevel() {return playerLevel;}
    public int getDamage() {
        return damage;
    }
    public int getHungerDamage() {
        return hungerDamage;
    }
    public int getHungerDrain() {
        return hungerDrain;
    }
    public int getFoodHungerIncrease() {
        return foodHungerIncrease;
    }
    public int getFoodHealthIncrease() {
        return foodHealthIncrease;
    }
    public int getMaxPlayerLevel() {
        return maxPlayerLevel;
    }
    public int getPuzzlesSolvedCount() {
        return puzzlesSolvedCount;
    }

    //Set Methods
    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    public void setCurrentLocationID(int currentLocationID) {
        this.currentLocationID = currentLocationID;
    }
    public void setCurrentLevelID(int currentLevelID) {
        this.currentLevelID = currentLevelID;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public void setCurrentXP(int currentXP) {this.currentXP = currentXP;}
    public void setCurrentHealth(int currentHealth) {this.currentHealth = currentHealth;}
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public void setMaxHunger(int maxHunger) {
        this.maxHunger = maxHunger;
    }
    public void setPlayerLevel(int playerLevel) {this.playerLevel = playerLevel;}
    public void setMaximumXP(int maximumXP) {this.maximumXP = maximumXP;}
    public void setCurrentHunger(int currentHunger) { this.currentHunger = currentHunger; }
    public void setMaximumHunger(int maxHunger) { this.maxHunger = maxHunger; }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setHungerDamage(int hungerDamage) {
        this.hungerDamage = hungerDamage;
    }
    public void setHungerDrain(int hungerDrain) {
        this.hungerDrain = hungerDrain;
    }
    public void setFoodHungerIncrease(int foodHungerIncrease) {
        this.foodHungerIncrease = foodHungerIncrease;
    }
    public void setFoodHealthIncrease(int foodHealthIncrease) {
        this.foodHealthIncrease = foodHealthIncrease;
    }
    public void setMaxPlayerLevel(int maxPlayerLevel) {
        this.maxPlayerLevel = maxPlayerLevel;
    }
    public void setXpReward(int xpReward) {
        this.xpReward = xpReward;
    }
    public void setPuzzlesSolvedCount(int puzzlesSolvedCount) {
        this.puzzlesSolvedCount = puzzlesSolvedCount;
    }

    public void addLocationToMovedLocationsList(Location location) { listOfMovedLocations.add(location); }

    public  void setCurrentLocationToPreviousLocation() {
        if (listOfMovedLocations.size() > 0){
            Location previousLocation = listOfMovedLocations.get(listOfMovedLocations.size() - 1);
            setCurrentLocation(previousLocation);
            NonStoryPrinter.print("Backtracked to previous location.");
        }
        else{
            PlayerStats playerStats = InitOfClassesThroughSaveFile.getPlayerStats();
            NonStoryPrinter.print("Not yet moved: cannot backtrack.");
        }
    }
}
