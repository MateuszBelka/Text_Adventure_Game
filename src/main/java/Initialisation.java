import java.util.ArrayList;

/* Potential issue:
 * Make sure all ArrayList are initialized,
 * otherwise you might end up trying to add item to
 * a list that doesn't exist yet.
 */

public class Initialisation {
    //Variable Declaration
    ArrayList<Game> games;
    ArrayList<Player> players;
    ArrayList<InputValidator> inputValidators;
    ArrayList<StoryTextOutput> storyTextOutputs;
    ArrayList<Inventory> inventories;
    ArrayList<Level> levels;
    ArrayList<Room> rooms;
    ArrayList<StaticItem> staticItems;
    ArrayList<PickupableItem> pickupableItems;
    Boolean exitSwitch;

    public Initialisation() { this.exitSwitch = false; }

    //Get Methods
    public ArrayList<Game> getGames() { return games; }
    public ArrayList<Player> getPlayers() { return players; }
    public ArrayList<InputValidator> getInputValidators() { return inputValidators;}
    public ArrayList<StoryTextOutput> getStoryTextOutputs() { return storyTextOutputs; }
    public ArrayList<Inventory> getInventories() {return inventories;}
    public ArrayList<Level> getLevels() { return levels; }
    public ArrayList<Room> getRooms() { return rooms; }
    public ArrayList<StaticItem> getStaticItems() { return staticItems; }
    public ArrayList<PickupableItem> getPickupableItems() { return pickupableItems; }
    public Boolean getExitSwitch() { return exitSwitch; }

    //Set Methods
    private void setGames(ArrayList<Game> games) { this.games = games; }
    private void setPlayers(ArrayList<Player> players) { this.players = players; }
    private void setInputValidators(ArrayList<InputValidator> inputValidators) { this.inputValidators = inputValidators; }
    private void setOutputs(ArrayList<StoryTextOutput> outputs) { this.storyTextOutputs = outputs; }
    private void setLevels(ArrayList<Level> levels) { this.levels = levels; }
    private void setRooms(ArrayList<Room> rooms) { this.rooms = rooms; }
    private void setStaticItems(ArrayList<StaticItem> staticItems) { this.staticItems = staticItems; }
    private void setPickupableItems(ArrayList<PickupableItem> pickupableItems){this.pickupableItems = pickupableItems;}
    public void setExitSwitch(Boolean exitSwitch) { this.exitSwitch = exitSwitch; }
    public void setInventories(ArrayList<Inventory> inventories) { this.inventories = inventories; }

    /* The following function is responsible for starting the entire game
     * and as such overlooks class specific initialization functions.
     *
     * Dev note (delete later):
     * We firstly have to init all classses in order to be
     * able to access them while configuring objects.
     */
    public void initializeEntireSystem() {
        //initialise classes
        setGames(initializeGames());
        setPlayers(initializePlayers());
        setInputValidators(initializeInputHandlers());
        setOutputs(initializeOutputs());
        setInventories(initializeInventories());
        setLevels(initializeLevels());
        setRooms(initializeRooms());
        setStaticItems(initializeStaticItems());
        setPickupableItems(initializePickupableItems());

        //configure classes
        configurePickupableItems();
        configureStaticItems();
        configureRooms();
        configureLevels();
        configureOutputs();
        configureInventories();
        configureGames();
        configurePlayers();
    }

    //Initialise class
    private ArrayList<Game> initializeGames() {
        ArrayList<Game> games = new ArrayList<>();
        Game game = new Game();

        games.add(game);

        return games;
    }
    private ArrayList<Player> initializePlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Player player = new Player();

        players.add(player);

        return players;
    }
    private ArrayList<InputValidator> initializeInputHandlers() {
        ArrayList<InputValidator> inputValidators = new ArrayList<>();
        InputValidator inputHandler = new InputValidator();

        inputValidators.add(inputHandler);

        return inputValidators;
    }
    private ArrayList<StoryTextOutput> initializeOutputs() {
        ArrayList<StoryTextOutput> outputs = new ArrayList<>();
        StoryTextOutput storyTextOutput = new StoryTextOutput();

        outputs.add(storyTextOutput);

        return outputs;
    }
    private ArrayList<Inventory> initializeInventories() {
        ArrayList<Inventory> inventories = new ArrayList<>();
        Inventory inventory = new Inventory();

        inventories.add(inventory);

        return inventories;
    }
    private ArrayList<Level> initializeLevels() {
        ArrayList<Level> levels = new ArrayList<>();
        Level level = new Level();

        levels.add(level);

        return levels;
    }
    private ArrayList<Room> initializeRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        Room room1 = new Room();
        Room room2 = new Room();

        rooms.add(room1);
        rooms.add(room2);

        return rooms;
    }
    private ArrayList<StaticItem> initializeStaticItems() {
        ArrayList<StaticItem> staticItems = new ArrayList<>();
        StaticItem staticItem1 = new StaticItem();
        StaticItem staticItem2 = new StaticItem();

        staticItems.add(staticItem1);
        staticItems.add(staticItem2);

        return staticItems;
    }
    private ArrayList<PickupableItem> initializePickupableItems() {
        ArrayList<PickupableItem> pickupableItems = new ArrayList<>();
        PickupableItem pickupableItem = new PickupableItem();

        pickupableItems.add(pickupableItem);

        return pickupableItems;
    }

    //Configure object
    private void configureGames() {
        Game game0 = getGames().get(0);
        Player player0 = getPlayers().get(0);

        game0.setPlayer(player0);
        game0.setListOfLevels(getLevels());
        game0.setLevelsLeftToSolve();
    }
    private void configurePlayers() {
        Player player0 = getPlayers().get(0);
        Game game0 = getGames().get(0);

        Level currentLevel = game0.getListOfLevels().get(0);
        player0.setCurrentLevel(currentLevel);

        Room currentRoom = player0.getCurrentLevel().getListOfRooms().get(0);
        player0.setCurrentRoom(currentRoom);

        Inventory inventory = getInventories().get(0);
        player0.setInventory(inventory);
    }
//    private void configureInputValidators() {
//
//        /* Dunno if anything has to be here
//         * and if there is I don't know what it is
//         */  //todo:nothing needs to be here.
//    }
    private void configureOutputs() {
        /* Class is empty
         */
    }
    private void configureInventories() {
        Inventory inventory = getInventories().get(0);
        Player player0 = getPlayers().get(0);
        player0.setInventory(inventory);
    }
    private void configureLevels() {
        Level level0 = getLevels().get(0);
        String storyText = "(LEVEL 1)     From the outside, you see that the house has two floors, " +
                "an attic, and a basement. You enter through the front door, and strangely enough, " +
                "find yourself in the kitchen? 'What a peculiar design...', you think to yourself.";

        level0.setListOfRooms(getRooms());
        level0.setPuzzlesLeftToSolve();
        level0.setStoryText(storyText);
    }
    private void configureRooms() {
        PickupableItem pickupableItem1 = getPickupableItems().get(0);
        StaticItem staticItem1 = getStaticItems().get(0);
        StaticItem staticItem2 = getStaticItems().get(1);
        Room room1 = getRooms().get(0);
        Room room2 = getRooms().get(1);
        String textAboutRoom1= "(KITCHEN)     The kitchen looks nice with its black and white tiles. " +
                "There's a fridge, a stove, a counter... To the *north*, there is an open door, " +
                "leading to the hallway.";
        String textAboutRoom2= "(HALLWAY)     You find yourself in the hallway. There are multiple doors here, " +
                "but all of them are barricaded. For a moment, you wonder why, but then quickly just accept this and" +
                " move on. " +
                "Behind you to the *south*, is the open door leading to the kitchen.";

        room1.updateRoomDirections(room2,null,null,null);
        room1.updateListOfAvailableDirectionsUsingRooms();
        room1.addPickupableItemToList(pickupableItem1); //possible error if ArrayList is not initialized
        room1.addStaticItemToList(staticItem1);
        room1.setLevel(getLevels().get(0));
        room1.setTextAboutRoom(textAboutRoom1);

        room2.updateRoomDirections(null,null,room1,null);
        room2.updateListOfAvailableDirectionsUsingRooms();
        room2.addStaticItemToList(staticItem2);
        room2.setLevel(getLevels().get(0));
        room2.setTextAboutRoom(textAboutRoom2);
    }
    private void configureStaticItems() {
        StaticItem staticItem1 = getStaticItems().get(0);
        StaticItem staticItem2 = getStaticItems().get(1);
        PickupableItem pickupableItem1 = getPickupableItems().get(0);

        String textAboutThisItem1 = "The *fridge* is buzzing with sound. " +
                "Out of curiosity you look inside it, but it is empty.";
        String textForPuzzleSolvedOfItem1 = "You place the carton of milk inside the fridge." +
                " Nice! The owners of this house will surely be glad!";
        String nameItem1 = "fridge";
        String textAboutThisItem2 = "Also, there is this *red button* here that just screams for you to press it.";
        String textForPuzzleSolvedOfItem2 = "Although nothing seems to happen, you feel slightly more satisfied, " +
                "after pressing it.";
        String nameItem2 = "button";

        staticItem1.setNeedsItem(pickupableItem1);
        staticItem1.setTextAboutThisItem(textAboutThisItem1);
        staticItem1.setTextForPuzzleSolved(textForPuzzleSolvedOfItem1);
        staticItem1.setName(nameItem1);

        staticItem2.setTextAboutThisItem(textAboutThisItem2);
        staticItem2.setTextForPuzzleSolved(textForPuzzleSolvedOfItem2);
        staticItem2.setName(nameItem2);
    }
    private void configurePickupableItems() {
        PickupableItem pickupableItem1 = getPickupableItems().get(0);
        StaticItem staticItem1 = getStaticItems().get(0);
        String name = "milk";
        String textAboutThisItem = "There is a *carton of milk* on the kitchen counter.";
        String textForItemPickedUp = "You pick up the carton of milk, and place it in your inventory. " +
                "Now what to do with it..?";

        pickupableItem1.setName(name);
        pickupableItem1.setStaticItemToUseOn(staticItem1);
        pickupableItem1.setTextAboutThisItem(textAboutThisItem);
        pickupableItem1.setTextForItemPickedUp(textForItemPickedUp);
    }
}