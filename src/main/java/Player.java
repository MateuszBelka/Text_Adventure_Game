//import com.sun.org.apache.xml.internal.security.Init;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;
//import org.w3c.dom.Text;

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

    public void pickUpPickupableItem(String nameOfItemToPickUp, TextTerminal terminal){
        //Method gets pickupableItem from its list in currentRoom.
        // Does not proceed if list of pickupable items in currentRoom is empty.
        // When found, method then deletes it from this list, and adds it to the list of player's inventory.
        PickupableItem itemToPickUp = currentRoom.getPickupableItemByName(nameOfItemToPickUp);
        if (itemToPickUp != null){
            currentRoom.deletePickupableItemFromList(itemToPickUp);
            getInventory().addToInventory(itemToPickUp);
            terminal.printf("%s\n", itemToPickUp.getTextForItemPickedUp());
        }
    }

    public void actionStaticItem(String nameOfStaticItemToAction, TextTerminal terminal){
        //Gets static item from currentRoom's list.
        //If static item is actionable, proceeds to delete static item from this list, and decreases puzzlesLeftToSolve.
        //If static items is actionable, a hint is printed.
        StaticItem staticItemToAction = currentRoom.getStaticItemByName(nameOfStaticItemToAction);
        if (staticItemToAction.isActionable()){
            currentRoom.deleteStaticItemFromList(staticItemToAction);
            getCurrentLevel().decreasePuzzlesLeftToSolve();
            terminal.printf("%s\n", staticItemToAction.getTextForPuzzleSolved());
        }
        else{ terminal.printf("HINT : This item needs another item.\n"); }
    }

    public void usePickupableItemOnStaticItem(String pItem, String sItem, TextTerminal terminal){
        //Gets staticItem from currentRoom's list. (previously checked to exist)
        //Gets pickupableItem from player's inventory's list. (previously checked to exist)
        //If staticItem's needsItem has a value, proceeds to check if pickupableItem equals needsItem.
        //If yes, staticItem is deleted from current Room, pickupableItem is deleted from inventory,
        //And puzzlesLeftToSolve is decreased, as a puzzle is now solved.
        //Hints are given through else statements.
        //TODO: checking for null can be deleted, as null will never equal to pickupableItem
        StaticItem staticItem = getCurrentRoom().getStaticItemByName(sItem);                      //pickupable item from the inventory
        PickupableItem pickupableItem = getInventory().getItemByName(pItem);

        if (staticItem.getNeedsItem() != null){
            if (staticItem.getNeedsItem().equals(pickupableItem)){
                getCurrentRoom().deleteStaticItemFromList(staticItem);
                inventory.deleteItemFromInventory(pickupableItem);
                getCurrentLevel().decreasePuzzlesLeftToSolve();
                terminal.printf("%s\n", staticItem.getTextForPuzzleSolved());
            }
            else{
                terminal.printf("Wrong item used on item.\n");
            }
        }
        else{
            terminal.printf("This item needs no other item.\n");
        }
    }

    //Get Methods
    public Level getCurrentLevel() { return currentLevel; }

    public Room getCurrentRoom() { return currentRoom; }

    public Inventory getInventory() { return inventory; }

    public void progressPlayer (Initialisation init, TextTerminal<SwingTextTerminal> terminal){

        ArrayList<Level> levels = init.getLevels();
        if (levels.size() == 1){ terminal.printf("Game Completed!\n\n\n"); }
        else {
            currentLevel = levels.get(1);
            currentRoom = currentLevel.getListOfRooms().get(0);
            currentLevel.updatePuzzlesLeftToSolve();
            init.deletePreviousLevel();
        }
    }
}
