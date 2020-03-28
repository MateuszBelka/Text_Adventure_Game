package gameElements.player;

import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;

import java.util.ArrayList;

public class PlayerStats {
    private transient Location currentLocation;
    private int currentLocationID;

    private transient Level currentLevel;
    private int currentLevelID;

    private transient Inventory inventory;

    public ArrayList<Location> listOfMovedLocations = new ArrayList<>();
    private int damage = 0;
    private int maximumXP = 100;
    private int maxHealth = 100;
    private int maxHunger = 100;
    private int currentHunger = maxHunger;
    private int hungerDrain = 10;
    private int foodHungerIncrease = 15;
    private int foodHealthIncrease = 10;

    /*
     * Dev Comment from Matt:
     * Imo the only edge case should be int size but that goes for everything.
     * Not sure what is the purpose of this variable.
     * If somebody wants to be level 100 000, why not?
     */
    private int maxPlayerLevel = 100; //todo: put this edge case in the set and increment method
    private int hungerDamage = 20;
    private int currentXP = 0;
    private int currentHealth = maxHealth;
    private int playerLevel = 1;

    //Get Methods
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

    public void addLocationToMovedLocationsList(Location location) { listOfMovedLocations.add(location); }

    public  void setCurrentLocationToPreviousLocation() {
        Location previousLocation = listOfMovedLocations.get(listOfMovedLocations.size() - 1);
        setCurrentLocation(previousLocation);
    }
}
