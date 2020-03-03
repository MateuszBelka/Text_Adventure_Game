import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        //game creation
        Game game = new Game();
        Level level = new Level();
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Output output = new Output();
        Initialisation initialisation = new Initialisation();
        StaticItem staticItem1 = new StaticItem();      //for actioning testing
        StaticItem staticItem2 = new StaticItem();      //for using with item testing
        PickupableItem pickupableItem = new PickupableItem();
        Player player = new Player();
//        Inventory inventory = new Inventory();
        InputHandler inputHandler = new InputHandler();
        Scanner scanner = new Scanner(System.in);
        Boolean exitSwitch = false;

        //tmp code for compiler complaints
        initialisation.print();
        level.print();
        output.print();
//        inventory.print();

        //Tmp Settings
        player.setCurrentLevel(level);
        player.setCurrentRoom(room1);
        //room1:
        ArrayList<String> dirlist1 = new ArrayList<>();
        dirlist1.add("north");
        room1.setNorth(room2);
        dirlist1.add("south");
        room1.setSouth(room3);
        room1.setListOfAvailableDirections(dirlist1);
        //room2:
        ArrayList<String> dirlist2 = new ArrayList<>();
        dirlist2.add("south");
        room2.setSouth(room1);
        room2.setListOfAvailableDirections(dirlist2);
        //todo: if room has no staticitems or pickupable items, the list should still be iterable...
        //room3:
        ArrayList<String> dirlist3 = new ArrayList<>();
        dirlist3.add("north");
        room3.setNorth(room1);
        room3.setListOfAvailableDirections(dirlist3);
        //Stuff in room1:
        staticItem1.setName("button");
        staticItem2.setName("fridge");
        staticItem2.setNeedsItem(pickupableItem);
        pickupableItem.setName("milk");
        ArrayList<StaticItem> siList = new ArrayList<>();
        siList.add(staticItem1);
        siList.add(staticItem2);
        player.getCurrentRoom().setListOfStaticItems(siList);
        ArrayList<PickupableItem> piList = new ArrayList<>();
        piList.add(pickupableItem);
        player.getCurrentRoom().setListOfPickupableItems(piList);

        //start of game
        while (!game.isCompleted() && exitSwitch.equals(false)) {
            System.out.println("*************MAP:************");
            System.out.println("room1 dirs: " + room1.getListOfAvailableDirections());
            System.out.println("room2 dirs: " + room2.getListOfAvailableDirections());
            System.out.println("room3 dirs: " + room3.getListOfAvailableDirections());
            System.out.println("******INFO FOR TESTING:******");
            System.out.println("current room: " + player.getCurrentRoom());
            System.out.println("current room directions: " + player.getCurrentRoom().getListOfAvailableDirections());
            System.out.println("current room pickupable items: " + player.getCurrentRoom().getListOfPickupableItems());
            System.out.println("current room static items: " + player.getCurrentRoom().getListOfStaticItems());
            String input = scanner.nextLine();
            if (input.equals("exit")) {exitSwitch = true;}
            inputHandler.handleInput(input, player);
        }
    }
}