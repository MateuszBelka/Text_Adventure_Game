import org.beryx.textio.TextTerminal;

public class Player {
    private Room currentRoom;
    private Level currentLevel;
    private Inventory inventory;
    private Game currentGame;

    //Set Methods
    public void setCurrentLevel(Level currentLevel) { this.currentLevel = currentLevel; }
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }
    public void setInventory(Inventory inventory) { this.inventory = inventory;}

    //Player actions
    public void movePlayer(String dirToMove){ //function to move player in inputted direction
        Room roomToMove = currentRoom.getRoomInDirection(dirToMove);
        setCurrentRoom(roomToMove);
    }
    public void pickUpPickupableItem(String nameOfItemToPickUp, TextTerminal terminal){ //picking up pickupable item and storing in inventory
        PickupableItem itemToPickUp = currentRoom.getPickupableItemByName(nameOfItemToPickUp);
        if (itemToPickUp != null){
            currentRoom.deletePickupableItemFromList(itemToPickUp);
            getInventory().addToInventory(itemToPickUp);
            terminal.printf("%s\n", itemToPickUp.getTextForItemPickedUp());
        }
    }
    public void actionStaticItem(String nameOfStaticItemToAction, TextTerminal terminal){ //actioning of the static item
        StaticItem staticItemToAction = currentRoom.getStaticItemByName(nameOfStaticItemToAction);
        if (staticItemToAction.isActionable()){
            currentRoom.deleteStaticItemFromList(staticItemToAction);
            getCurrentLevel().decreasePuzzlesLeftToSolve();
            terminal.printf("%s\n", staticItemToAction.getTextForPuzzleSolved());
        }
        else{ terminal.printf("HINT : This item needs another item.\n"); }
    }
    public void usePickupableItemOnStaticItem(String pItem, String sItem, TextTerminal terminal){ //using pickupable itemon static item and removing
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
}
