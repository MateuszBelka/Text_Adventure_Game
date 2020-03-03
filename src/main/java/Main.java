import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Initialisation init = new Initialisation();
        init.initializeEntireStory();

        Player player = init.getPlayers().get(0);
        Game game = init.getGames().get(0);
        Boolean exitSwitch = init.getExitSwitch();
        InputHandler inputHandler = init.getInputHandlers().get(0);

        //main game loop
        while (!game.isCompleted() && exitSwitch.equals(false)) {
            System.out.println("******INFO FOR TESTING:******");
            System.out.println("current room: " + player.getCurrentRoom());
            System.out.println("current room directions: " + player.getCurrentRoom().getListOfAvailableDirections());
            System.out.println("pickupable items: " + player.getCurrentRoom().getListOfPickupableItems());
            System.out.println("static items: " + player.getCurrentRoom().getListOfStaticItems());
            System.out.println("current room pickupable items: " + player.getCurrentRoom().getListOfPickupableItems());
            System.out.println("current room static items: " + player.getCurrentRoom().getListOfStaticItems());
            String input = scanner.nextLine();
            if (input.equals("exit")) {init.setExitSwitch(true);}
            inputHandler.handleInput(input, player);
        }
    }
}