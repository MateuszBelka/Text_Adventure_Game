import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        //game creation
        Game game = new Game();
        Level level = new Level();
        Room room1 = new Room();
        Room room2 = new Room();
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
        room2.print();
//        inventory.print();

        //tmp settings
        player.setCurrentRoom(room1);
        ArrayList<String> dirlist = new ArrayList<>();
        dirlist.add("north");
        dirlist.add("south");
        room1.setListOfAvailableDirections(dirlist);
        room1.setNorth(room2);
        dirlist.clear();
        dirlist.add("south");
        room2.setListOfAvailableDirections(dirlist);
        room2.setSouth(room1);
        staticItem1.setName("button");
        staticItem2.setName("fridge");
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
            String input = scanner.nextLine();
            if (input.equals("exit")) {exitSwitch = true;}
            inputHandler.handleInput(input, player);
        }
    }
}