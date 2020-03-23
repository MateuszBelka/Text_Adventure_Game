package gameElements.levelAndContents;

public class Level {
    private int id;
    String description;
    String name;
    Boolean firstTimeEnteringLevel = true;
    Integer puzzles;
    private transient Location startLocation;
    private int startLocationID;

    //Get Methods
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public Integer getPuzzles() {
        return puzzles;
    }
    public String getName() {
        return name;
    }
    public Location getStartLocation() {
        return startLocation;
    }
    public int getStartLocationID() {
        return startLocationID;
    }

    //Set Methods
    public void setId(int id) {
        this.id = id;
    }
    public void setPuzzles() {
        //Waiting for Item Class to be finished
    }
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }
    public void setStartLocationID(int startLocationID) {
        this.startLocationID = startLocationID;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFirstTimeEnteringLevel(Boolean firstTimeEnteringLevel) {
        this.firstTimeEnteringLevel = firstTimeEnteringLevel;
    }

    public boolean descriptionPrintedOnce (){
        if (firstTimeEnteringLevel.equals(true)){
            firstTimeEnteringLevel = false;
            return true;
        }
        return firstTimeEnteringLevel;
    }

    public void decreasePuzzles(){
        puzzles--;
    }
}
