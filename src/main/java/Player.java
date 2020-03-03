
public class Player {
    private Room currentRoom;
    private Level currentLevel;

    //Set Methods
    public void setCurrentLevel(Level level) {currentLevel = level; }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    //Get Methods
    public Level getCurrentLevel() { return currentLevel; }
    public Room getCurrentRoom() {
        return currentRoom;
    }
}
