package gameElements.player;

import gameElements.levelAndContents.Level;
import gameElements.levelAndContents.Location;
import initialisation.CollectionOfAllClasses;

public class Player {
    Location currentLocation;
    Level currentLevel;
    Inventory inventory = CollectionOfAllClasses.getInventory();
    private int maximumXP = 100;
    private int maxHealth = 100;
    private int maxHunger = 100;
    private int maxPlayerLevel = 100; //todo: put this edge case in the set and increment method
    private int HUNGER_DAMAGE;
    private int currentXP = 0;
    private int currentHunger = 0;
    private int currentHealth = maxHealth;
    private int playerLevel = 1;

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Level getCurrentLevel() {
        return currentLevel;
    }

    protected int getPlayerLevel() {return playerLevel;}

    private int getCurrentHunger() {return currentHunger;}

    private int getCurrentHealth() {return currentHealth;}

    protected int getCurrentXP() {return currentXP;}

    protected int getMaximumXP() {return maximumXP;}

    protected void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    protected void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    protected void setCurrentXP(int currentXP) {this.currentXP = currentXP;}

    protected void setCurrentHealth(int currentHealth) {this.currentHealth = currentHealth;}

    protected void setPlayerLevel(int playerLevel) {this.playerLevel = playerLevel;}

    protected void setMaximumXP(int maximumXP) {this.maximumXP = maximumXP;}

    protected void incrementPlayerLevel() { setPlayerLevel(getPlayerLevel() + 1); }

    protected void increaseHealth ( int i){
        // increases healthPoints after eating food
        setCurrentHealth(getCurrentHealth()+i);
    }

    protected void increaseMaximumXP() { setMaximumXP(getPlayerLevel() * getMaximumXP()); }
}
