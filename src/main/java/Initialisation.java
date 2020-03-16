import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;
import java.util.ArrayList;

public class Initialisation {
    //Variable Declaration
    private ArrayList<Game>                 games;
    private ArrayList<Player>               players;
    private ArrayList<InputValidator>       inputValidators;
    private ArrayList<StoryTextOutput>      storyTextOutputs;
    private ArrayList<Inventory>            inventories;
    private ArrayList<Level>                levels;
    private ArrayList<Room>                 rooms;
    private ArrayList<StaticItem>           staticItems;
    private ArrayList<PickupableItem>       pickupableItems;
    private Boolean                         exitSwitch = false;

    //Get Methods
    public ArrayList<Game>                  getGames()              { return games; }
    public ArrayList<Player>                getPlayers()            { return players; }
    public ArrayList<InputValidator>        getInputValidators()    { return inputValidators;}
    public ArrayList<StoryTextOutput>       getStoryTextOutputs()   { return storyTextOutputs; }
    public ArrayList<Inventory>             getInventories()        { return inventories;}
    public ArrayList<Level>                 getLevels()             { return levels; }
    public ArrayList<Room>                  getRooms()              { return rooms; }
    public ArrayList<StaticItem>            getStaticItems()        { return staticItems; }
    public ArrayList<PickupableItem>        getPickupableItems()    { return pickupableItems; }
    public Boolean                          getExitSwitch()         { return exitSwitch; }

    //Set Methods
    private void setGames(ArrayList<Game> games)                              { this.games = games; }
    private void setPlayers(ArrayList<Player> players)                        { this.players = players; }
    private void setInputValidators(ArrayList<InputValidator> inputValidators){ this.inputValidators = inputValidators;}
    private void setStoryTextOutputs(ArrayList<StoryTextOutput> outputs)      { this.storyTextOutputs = outputs; }
    private void setInventories(ArrayList<Inventory> inventories)             { this.inventories = inventories; }
    private void setLevels(ArrayList<Level> levels)                           { this.levels = levels; }
    private void setRooms(ArrayList<Room> rooms)                              { this.rooms = rooms; }
    private void setStaticItems(ArrayList<StaticItem> staticItems)            { this.staticItems = staticItems; }
    private void setPickupableItems(ArrayList<PickupableItem> pickupableItems){ this.pickupableItems = pickupableItems;}
    public  void setExitSwitch(Boolean exitSwitch)                            { this.exitSwitch = exitSwitch; }

    //Delete Method
    public void deletePreviousLevel() { levels.remove(0); }

    /*
     * The following function is responsible for starting the entire game and as such overlooks class specific initialization functions.
     *
     * Before configuring attributes of all individual objects,
     * it is necessary to initialize all of them initially so that
     * we don't encounter situation where an object attempt to locate memory location of
     * an object that has not yet been initialized.
     */
    public void initializeEntireSystem() {
        /*
         * Initializes all of the classes used in our system.
         *
         * From the point of view of the story you are trying to tell,
         * this part is responsible for determining how much of what there is.
         * (i.e. 1 player, 2 levels, and 20 rooms total)
         */
        setGames(initializeGames());
        setPlayers(initializePlayers());
        setInputValidators(initializeInputValidators());
        setStoryTextOutputs(initializeStoryTextOutputs());
        setInventories(initializeInventories());
        setLevels(initializeLevels());
        setRooms(initializeRooms());
        setStaticItems(initializeStaticItems());
        setPickupableItems(initializePickupableItems());

        /*
         * Configure all attibutes of newly created objects.
         *
         * This includes creating direct accesses between objects.
         * (i.e. Game object knows how many levels there are and their order)
         */
        configurePickupableItems();
        configureStaticItems();
        configureRooms();
        configureLevels();
        configureInventories();
        configureGames();
        configurePlayers();
    }

    /*
     * Initializes all the classes used in our system.
     *
     * From the point of view of the story you are trying to tell,
     * this part is responsible for determining how much of what there is.
     * (i.e. 1 player, 2 levels, and 20 rooms total)
     */
    private ArrayList<Game>             initializeGames() {
        games = new ArrayList<>();
        Game game = new Game();

        games.add(game);

        return games;
    }
    private ArrayList<Player>           initializePlayers() {
        players = new ArrayList<>();
        Player player = new Player();

        players.add(player);

        return players;
    }
    private ArrayList<InputValidator>   initializeInputValidators() {
        inputValidators = new ArrayList<>();
        InputValidator inputHandler = new InputValidator();

        inputValidators.add(inputHandler);

        return inputValidators;
    }
    private ArrayList<StoryTextOutput>  initializeStoryTextOutputs() {
        ArrayList<StoryTextOutput> outputs = new ArrayList<>();
        StoryTextOutput storyTextOutput = new StoryTextOutput();

        outputs.add(storyTextOutput);

        return outputs;
    }
    private ArrayList<Inventory>        initializeInventories() {
        inventories = new ArrayList<>();
        Inventory inventory = new Inventory();

        inventories.add(inventory);

        return inventories;
    }
    private ArrayList<Level>            initializeLevels() {
        levels = new ArrayList<>();
        Level level1 = new Level();
        Level level2 = new Level();

        levels.add(level1);
        levels.add(level2);

        return levels;
    }
    private ArrayList<Room>             initializeRooms() {
        rooms = new ArrayList<>();
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);

        return rooms;
    }
    private ArrayList<StaticItem>       initializeStaticItems() {
        staticItems = new ArrayList<>();
        StaticItem staticItem1 = new StaticItem();
        StaticItem staticItem2 = new StaticItem();
        StaticItem staticItem3 = new StaticItem();

        staticItems.add(staticItem1);
        staticItems.add(staticItem2);
        staticItems.add(staticItem3);

        return staticItems;
    }
    private ArrayList<PickupableItem>   initializePickupableItems() {
        pickupableItems = new ArrayList<>();
        PickupableItem pickupableItem = new PickupableItem();

        pickupableItems.add(pickupableItem);

        return pickupableItems;
    }

    /*
     * Configure all attibutes of newly created objects.
     *
     * This includes creating direct accesses between objects.
     * (i.e. Game object knows how many levels there are and their order)
     */
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

        ArrayList<Room> roomList1 = new ArrayList<>();
        roomList1.add(getRooms().get(0));
        roomList1.add(getRooms().get(1));
        level0.setListOfRooms(roomList1);
        level0.updatePuzzlesLeftToSolve();
        level0.setStoryText(storyText);

        Level level1 = getLevels().get(1);
        String storyText2 = "(LEVEL 2)   You miraculously teleported outside!";
        ArrayList<Room> roomList2 = new ArrayList<>();
        roomList2.add(getRooms().get(2));
        level1.updatePuzzlesLeftToSolve();
        level1.setStoryText(storyText2);
        level1.setListOfRooms(roomList2);

    }
    private void configureRooms() {
        PickupableItem pickupableItem1 = getPickupableItems().get(0);
        StaticItem staticItem1 = getStaticItems().get(0);
        StaticItem staticItem2 = getStaticItems().get(1);
        StaticItem staticItem3 = getStaticItems().get(2);
        Room room1 = getRooms().get(0);
        Room room2 = getRooms().get(1);
        Room room3 = getRooms().get(2);
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

        String textAboutRoom3 = "(Outside)";
        room3.updateRoomDirections(null, null, null, null);
        room3.setTextAboutRoom(textAboutRoom3);
        room3.addStaticItemToList(staticItem3);
        room3.setLevel(getLevels().get(1));
        room3.updateListOfAvailableDirectionsUsingRooms();
    }
    private void configureStaticItems() {
        StaticItem staticItem1 = getStaticItems().get(0);
        StaticItem staticItem2 = getStaticItems().get(1);
        StaticItem staticItem3 = getStaticItems().get(2);
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

        String text3Before = "You see a *beautiful tree* that you might want to climb.";
        String text3After = "You climb the tree, and decide to make it your home.";
        staticItem3.setTextAboutThisItem(text3Before);
        staticItem3.setTextForPuzzleSolved(text3After);
        staticItem3.setName("tree");
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