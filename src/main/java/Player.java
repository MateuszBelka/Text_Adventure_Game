import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private Level currentLevel;
    private Inventory inventory;
    private int currentXP;
    private int maxXP;
    private int currentHealth;
    private int maxHealth;
    private int currentHunger;
    private int maxHunger;

    private int HUNGER_DAMAGE
    private int playerLevel;

    public Player() {

        currentXP = 0;
        maximumXP = 100;
        maxHealth = 100;
        maxHunger = 100;
        currentHunger = 0;
        currentHealth = maxHealth;
        playerLevel = 1;
    }
    //Set Methods
    public void setCurrentLevel(Level currentLevel) { this.currentLevel = currentLevel; }

    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    public void setInventory(Inventory inventory) { this.inventory = inventory;}

    public void setCurrentXP(int currentXP) {this.currentXP = currentXP;}

    public void setMaximumXP(int maximumXP) {this.maximumXP = maximumXP;}

    public void setCurrentHealth(int currentHealth) {this.currentHealth = currentHealth;}

    public void setPlayerLevel(int playerLevel) {this.playerLevel = playerLevel;}

    }

    //Player actions
    public void movePlayer(String dirToMove){
        //Method gets the Room of the specified direction, which is found in currentRoom.
        //Then sets currentRoom to that found Room. (Thus, moves player to room stated in direction.)
        Room roomToMove = currentRoom.getRoomInDirection(dirToMove);
        setCurrentRoom(roomToMove);
    }

    public void pickUpPickupableItem(String nameOfItemToPickUp){
        //Method gets pickupableItem from its list in currentRoom.
        // When found, method deletes it from this list, and adds it to the list of player's inventory.
        PickupableItem itemToPickUp = currentRoom.getPickupableItemByName(nameOfItemToPickUp);
            currentRoom.deletePickupableItemFromList(itemToPickUp);
            getInventory().addToInventory(itemToPickUp);
    }

    public void actionStaticItem(String nameOfStaticItemToAction){
        //Gets static item from currentRoom's list.
        //Deletes static item from this list, and decreases puzzlesLeftToSolve.
        StaticItem staticItemToAction = currentRoom.getStaticItemByName(nameOfStaticItemToAction);
        currentRoom.deleteStaticItemFromList(staticItemToAction);
        getCurrentLevel().decreasePuzzlesLeftToSolve();
        increaseCurrentXP();
    }

    public void usePickupableItemOnStaticItem(String pItem, String sItem){
        //Gets staticItem from currentRoom's list, and pickupableItem from player's inventory's list.
        //StaticItem is deleted from current Room, pickupableItem is deleted from inventory,
        //and puzzlesLeftToSolve is decreased.
        StaticItem staticItem = getCurrentRoom().getStaticItemByName(sItem);
        PickupableItem pickupableItem = getInventory().getItemByName(pItem);

        getCurrentRoom().deleteStaticItemFromList(staticItem);
        inventory.deleteItemFromInventory(pickupableItem);
        getCurrentLevel().decreasePuzzlesLeftToSolve();
        increaseCurrentXP();
    }

    public void increaseCurrentXP() {
        final int increaseCurrentXPby = getMaximumXP() / (getPlayerLevel() * 30); //this
        final int newCurrentXP = getCurrentXP() + increaseCurrentXPby;

        if (newCurrentXP < getMaximumXP()) { //when updated xp < max xp
            setCurrentXP(newCurrentXP);
        }
        else {
            setCurrentXP(newCurrentXP-getMaximumXP()); //when updated xp >= max xp
            incrementPlayerLevel();
            increaseMaximumXP();
        }
    }

    public void decreaseHealth(int i) {
    // decreases healthPoints
        setCurrentHealth(getCurrentHealth - i);
    }

    public void CheckHungerLevel() {
    // decreases healthPoints based on hungerLevel
        if (hungerLevel <= 50) {
            decreaseHealth(HUNGER_DAMAGE);

        }
        // notifies player of death, reverts game back to previous save?
        if (currentHealth <= 0) {
             ///revert back to previous save?
        }
    }

    public void eatFood(int foodPoints) { //placeholder for now
        increaseHealth(foodPoints);
    }

    public void increaseHealth ( int i){
    // increases healthPoints after eating food
        setCurrentHealth(getCurrentHealth()+i);

        }
    }

    public void incrementPlayerLevel() { setPlayerLevel(getPlayerLevel() + 1); }

    public void increaseMaximumXP() { setMaximumXP(getPlayerLevel() * getMaximumXP()); }

    //Get Methods
    public Level getCurrentLevel() { return currentLevel; }

    public Room getCurrentRoom() { return currentRoom; }

    public Inventory getInventory() { return inventory; }

    private int getCurrentHealth() {return currentHealth;}

    private int getCurrentXP() {return currentXP;}

    private int getMaximumXP() {return maximumXP;}

    private int getPlayerLevel() {return playerLevel;}

    public void progressPlayer (Initialisation init) {
        ArrayList<Level> levels = init.getLevels();
        if (levels.size() == 1){ System.out.println("Game Completed!\n"); }
        else {
            currentLevel = levels.get(1);
            currentRoom = currentLevel.getListOfRooms().get(0);
            currentLevel.updatePuzzlesLeftToSolve();
            System.out.println("Level Completed!\n");
            init.deletePreviousLevel();
        }
    }
}
