import org.beryx.textio.TextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;
import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private Level currentLevel;
    private Inventory inventory;

    //Set Methods
    public void setCurrentLevel(Level currentLevel) { this.currentLevel = currentLevel; }

    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }

    public void setInventory(Inventory inventory) { this.inventory = inventory;}

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
    }

    //Get Methods
    public Level getCurrentLevel() { return currentLevel; }

    public Room getCurrentRoom() { return currentRoom; }

    public Inventory getInventory() { return inventory; }

    public void progressPlayer (Initialisation init, TextTerminal<SwingTextTerminal> terminal){
        ArrayList<Level> levels = init.getLevels();
        if (levels.size() == 1){ terminal.printf("Game Completed!\n"); }
        else {
            currentLevel = levels.get(1);
            currentRoom = currentLevel.getListOfRooms().get(0);
            currentLevel.updatePuzzlesLeftToSolve();
            terminal.printf("Level Completed!\n");
            init.deletePreviousLevel();
        }
    }
}
