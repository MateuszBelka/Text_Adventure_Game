import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;

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
        Room room = new Room();

        rooms.add(room);

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
        getGames().get(0).setListOfLevels(getLevels());
        //set levelsLeftToSolve
    }
    private void configurePlayers() {
        Level currentLevel = getGames().get(0).getListOfLevels().get(0);
        getPlayers().get(0).setCurrentLevel(currentLevel);

        Room currentRoom = getPlayers().get(0).getCurrentLevel().getListOfRooms().get(0);
        getPlayers().get(0).setCurrentRoom(currentRoom);
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
        ArrayList<Room> listOfRooms = rooms;
        getLevels().get(0).setListOfRooms(listOfRooms);

        //set puzzlesLeftToSolve

        String storyText = "temporary story text for 1st Level.";
        getLevels().get(0).setStoryText(storyText);
    }
    private void configureRooms() {


    }
    private void configureStaticItems() {

    }
    private void configurePickupableItems() {

    }
}

//    //game creation
//    Game game = new Game();
//    Level level = new Level();
//    Room room1 = new Room();
//    Room room2 = new Room();
//    Output output = new Output();
//    Initialisation initialisation = new Initialisation();
//    StaticItem staticItem1 = new StaticItem();      //for actioning testing
//    StaticItem staticItem2 = new StaticItem();      //for using with item testing
//    PickupableItem pickupableItem = new PickupableItem();
//    Player player = new Player();
//    Inventory inventory = new Inventory();
//    InputHandler inputHandler = new InputHandler();
//    Scanner scanner = new Scanner(System.in);
//    Boolean exitSwitch = false;

//    //tmp settings
//    player.setCurrentRoom(room1);               //tmp
//    room1.setListOfAvailableDir("north");       //tmp
//    room1.setListOfAvailableDir("south");       //tmp
//    staticItem1.setName("button");      //tmp
//    staticItem2.setName("fridge");      //tmp
//    pickupableItem.setName("milk");     //tmp
//    player.getCurrentRoom().setListOfStaticItems(staticItem1);          //tmp
//    player.getCurrentRoom().setListOfStaticItems(staticItem2);          //tmp
//    player.getCurrentRoom().setListOfPickupableItems(pickupableItem);   //tmp
