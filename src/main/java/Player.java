
public class Player {
    private Room currentRoom;
    private Level currentLevel;
    private Inventory inventory;

    //Set Methods
    public void setCurrentLevel(Level level) { currentLevel = level; }
    public void setCurrentRoom(Room currentRoom) { this.currentRoom = currentRoom; }
    public void setInventory(Inventory inventory) { this.inventory = inventory;}
    public void movePlayer(String dirToMove){
        Room roomToMove = currentRoom.getRoomInDirection(dirToMove);
        setCurrentRoom(roomToMove);
    }
    public void pickUpPickupableItem(String nameOfItemToPickUp){
        PickupableItem itemToPickUp = currentRoom.getPickupableItemByName(nameOfItemToPickUp);
        if (itemToPickUp != null){
            currentRoom.deletePickupableItemFromList(itemToPickUp);
            getInventory().addToInventory(itemToPickUp);
            System.out.println(itemToPickUp.getTextForItemPickedUp());
        }
    }
    public void actionStaticItem(String nameOfStaticItemToAction){
        StaticItem staticItemToAction = currentRoom.getStaticItemByName(nameOfStaticItemToAction);
        if (staticItemToAction.isActionable()){
            currentRoom.deleteStaticItemFromList(staticItemToAction);
            getCurrentLevel().decreasePuzzlesLeftToSolve();
            System.out.println(staticItemToAction.getTextForPuzzleSolved());
        }
        else{ System.out.println("HINT : This item needs another item."); }
    }
    public void usePickupableItemOnStaticItem(String pItem, String sItem){
        StaticItem staticItem = getCurrentRoom().getStaticItemByName(sItem);
        PickupableItem pickupableItem = getInventory().getItemByName(pItem);

        if (staticItem.getNeedsItem() != null){
            if (staticItem.getNeedsItem().equals(pickupableItem)){
                getCurrentRoom().deleteStaticItemFromList(staticItem);
                inventory.deleteItemFromInventory(pickupableItem);
                getCurrentLevel().decreasePuzzlesLeftToSolve();
                System.out.println(staticItem.getTextForPuzzleSolved());
            }
            else{
                System.out.println("Wrong item used on item.");
            }
        }
        else{
            System.out.println("This item needs no other item.");
        }
    }

    //Get Methods
    public Level getCurrentLevel() { return currentLevel; }
    public Room getCurrentRoom() { return currentRoom; }
    public Inventory getInventory() { return inventory; }
}
