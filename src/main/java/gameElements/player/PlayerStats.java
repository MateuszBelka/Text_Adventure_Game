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

    private ArrayList<Location> listOfMovedLocations = new ArrayList<>();
    private int maximumXP = 100;
    private int maxHealth = 100;
    private int maxHunger = 100;
    private int currentHunger = maxHunger;
    /*
     * Dev Comment from Matt:
     * Imo the only edge case should be int size but that goes for everything.
     * Not sure what is the purpose of this variable.
     * If somebody wants to be level 100 000, why not?
     */
    private int maxPlayerLevel = 100; //todo: put this edge case in the set and increment method
    private int HUNGER_DAMAGE;
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
    public int getCurrentHunger() {return currentHunger;}
    private int getMaxHunger() {return maxHunger;}
    private int getCurrentHealth() {return currentHealth;}
    protected int getCurrentXP() {return currentXP;}
    protected int getMaximumXP() {return maximumXP;}
    protected int getPlayerLevel() {return playerLevel;}

    //Set Methods
    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
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

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    protected void setCurrentXP(int currentXP) {this.currentXP = currentXP;}
    protected void setCurrentHealth(int currentHealth) {this.currentHealth = currentHealth;}
    protected void setPlayerLevel(int playerLevel) {this.playerLevel = playerLevel;}
    protected void setMaximumXP(int maximumXP) {this.maximumXP = maximumXP;}
    protected void setCurrentHunger(int currentHunger) { this.currentHunger = currentHunger; }
    protected void setMaximumHunger(int maxHunger) { this.maxHunger = maxHunger; }

    protected void decreaseCurrentHunger() { setCurrentHunger(currentHunger - 10); }

    //called when a character consumed something
    protected void increaseCurrentHunger() { setCurrentHunger(currentHunger + 15); }

    //the type should be changed depending on implementation, probably boolean or string, not sure yet
    public void checkCurrentHunger() {
        if (getCurrentHunger() <= 10 && getCurrentHunger() > 0) {
            //return additional message that will warn a player character being close to starving
        }
        else if (getCurrentHunger() == 0) {
            setCurrentHealth(currentHealth - 20);
            //return warning message that a character is starving and starts to lose health
        }
    }

    protected void incrementPlayerLevel() { setPlayerLevel(getPlayerLevel() + 1); }

    protected void increaseHealth ( int i){
        // increases healthPoints after eating food
        setCurrentHealth(getCurrentHealth()+i);
    }

    protected void increaseMaximumXP() { setMaximumXP(getPlayerLevel() * getMaximumXP()); }

    public void addLocationToMovedLocationsList(Location location) { listOfMovedLocations.add(location); }

    public  void setCurrentLocationToPreviousLocation() {
        Location previousLocation = listOfMovedLocations.get(listOfMovedLocations.size() - 1);
        setCurrentLocation(previousLocation);
    }
}
