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
    ArrayList<InputHandler> inputHandlers;
    ArrayList<Output> outputs;
    //ArrayList<Inventory> inventories;
    ArrayList<Level> levels;
    ArrayList<Room> rooms;
    ArrayList<StaticItem> staticItems;
    ArrayList<PickupableItem> pickupableItems;
    Boolean exitSwitch;

    public Initialisation() {
        this.exitSwitch = false;
    }

    //Get Methods
    public ArrayList<Game> getGames() {
        return games;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public ArrayList<InputHandler> getInputHandlers() {
        return inputHandlers;
    }
    public ArrayList<Output> getOutputs() {
        return outputs;
    }
    /*
    private ArrayList<Inventory> getInventories() {

    }
    */
    public ArrayList<Level> getLevels() {
        return levels;
    }
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public ArrayList<StaticItem> getStaticItems() {
        return staticItems;
    }
    public ArrayList<PickupableItem> getPickupableItems() {
        return pickupableItems;
    }
    public Boolean getExitSwitch() {
        return exitSwitch;
    }
    //Set Methods
    private void setGames(ArrayList<Game> games) {
        this.games = games;
    }
    private void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    private void setInputHandlers(ArrayList<InputHandler> inputHandlers) {
        this.inputHandlers = inputHandlers;
    }
    private void setOutputs(ArrayList<Output> outputs) {
        this.outputs = outputs;
    }
    private void setLevels(ArrayList<Level> levels) {
        this.levels = levels;
    }
    private void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    private void setStaticItems(ArrayList<StaticItem> staticItems) {
        this.staticItems = staticItems;
    }
    private void setPickupableItems(ArrayList<PickupableItem> pickupableItems) {
        this.pickupableItems = pickupableItems;
    }
    public void setExitSwitch(Boolean exitSwitch) {
        this.exitSwitch = exitSwitch;
    }

    /* The following function is responsible for starting the entire game
     * and as such overlooks class specific initialization functions.
     *
     * Dev note (delete later):
     * We firstly have to init all classses in order to be
     * able to access them while configuring objects.
     */
    public void initializeEntireStory() {
        //initialise classes
        setGames(initializeGames());
        setPlayers(initializePlayers());
        setInputHandlers(initializeInputHandlers());
        setOutputs(initializeOutputs());
        //setInventories(initializeInventories());
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
        //configureInventories();
        configureInputHandlers();
        configurePlayers();
        configureGames();
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
    private ArrayList<InputHandler> initializeInputHandlers() {
        ArrayList<InputHandler> inputHandlers = new ArrayList<>();
        InputHandler inputHandler = new InputHandler();

        inputHandlers.add(inputHandler);

        return inputHandlers;
    }
    private ArrayList<Output> initializeOutputs() {
        ArrayList<Output> outputs = new ArrayList<>();
        Output output = new Output();

        outputs.add(output);

        return outputs;
    }
    /*
    private ArrayList<Inventory> initializeInventories() {

    }
    */
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
        StaticItem staticItem = new StaticItem();

        staticItems.add(staticItem);

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

        game0.setListOfLevels(getLevels());
        game0.setLevelsLeftToSolve();
    }
    private void configurePlayers() {
        Player player0 = getPlayers().get(0);
        Level currentLevel = getGames().get(0).getListOfLevels().get(0);
        Room currentRoom = player0.getCurrentLevel().getListOfRooms().get(0);

        player0.setCurrentLevel(currentLevel);
        player0.setCurrentRoom(currentRoom);
    }
    private void configureInputHandlers() {
        /* Dunno if anything has to be here
         * and if there is I don't know what it is
         */
    }
    private void configureOutputs() {
        /* Class is empty
         */
    }
    /*
    private void configureInventories() {

    }
    */
    private void configureLevels() {
        Level level0 = getLevels().get(0);
        String storyText = "temporary story text for 1st Level.";

        level0.setListOfRooms(getRooms());
        level0.setPuzzlesLeftToSolve();
        level0.setStoryText(storyText);
    }
    private void configureRooms() {
        PickupableItem pickupableItem1 = getPickupableItems().get(0);
        StaticItem staticItem1 = getStaticItems().get(0);
        Room room1 = getRooms().get(0);
        Room room2 = getRooms().get(1);
        String textAboutRoom1= "temporary text about room 1.";
        String textAboutRoom2= "temporary text about room 2.";

        room1.updateRoomDirections(room2,null,null,null);
        room1.updateListOfAvailableDirectionsUsingRooms();
        room1.addPickupableItemToList(pickupableItem1); //possible error if ArrayList is not initialized
        room1.addStaticItemToList(staticItem1);
        room1.setLevel(getLevels().get(0));
        room1.setTextAboutRoom(textAboutRoom1);

        room2.updateRoomDirections(null,null,room1,null);
        room2.updateListOfAvailableDirectionsUsingRooms();
        room2.setLevel(getLevels().get(0));
        room2.setTextAboutRoom(textAboutRoom2);
    }
    private void configureStaticItems() {
        StaticItem staticItem1 = getStaticItems().get(0);
        PickupableItem pickupableItem1 = getPickupableItems().get(0);
        String textAboutThisItem = "temporary text about this static item1.";
        String textForPuzzleSolved = "temporary text for puzzle solved1.";
        String name = "temporary name for static item1.";

        staticItem1.setNeedsItem(pickupableItem1);
        staticItem1.setTextAboutThisItem(textAboutThisItem);
        staticItem1.setTextForPuzzleSolved(textForPuzzleSolved);
        staticItem1.setName(name);
    }
    private void configurePickupableItems() {
        PickupableItem pickupableItem1 = getPickupableItems().get(0);
        StaticItem staticItem1 = getStaticItems().get(0);
        String name = "temporary name for pickupable item1.";
        String textAboutThisItem = "temporary text about this pickupable item1.";

        pickupableItem1.setName(name);
        pickupableItem1.setStaticItemToUseOn(staticItem1);
        pickupableItem1.setTextAboutThisItem(textAboutThisItem);
    }
}