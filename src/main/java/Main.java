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
        Inventory inventory = new Inventory();
        InputHandler inputHandler = new InputHandler();
        Scanner scanner = new Scanner(System.in);

        //tmp code for compiler complaints
        initialisation.print();
        level.print();
        inventory.print();
        output.print();
        room2.print();
        game.print();

        //tmp settings
        player.setCurrentRoom(room1);               //tmp
        room1.setListOfAvailableDir("north");       //tmp
        room1.setListOfAvailableDir("south");       //tmp
        staticItem1.setName("button");      //tmp
        staticItem2.setName("fridge");      //tmp
        pickupableItem.setName("milk");     //tmp
        player.getCurrentRoom().setListOfStaticItems(staticItem1);          //tmp
        player.getCurrentRoom().setListOfStaticItems(staticItem2);          //tmp
        player.getCurrentRoom().setListOfPickupableItems(pickupableItem);   //tmp

        //start of game
        while (!game.isCompleted()) {
            String input = scanner.nextLine();
            inputHandler.inputValidator(input, player.getCurrentRoom());
        }
    }
}