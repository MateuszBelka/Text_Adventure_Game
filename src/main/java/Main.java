import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Initialisation init = new Initialisation();
        init.initializeEntireSystem();

        Player player = init.getPlayers().get(0);
        Game game = init.getGames().get(0);
        InputValidator inputHandler = init.getInputValidators().get(0);

        //main game loop
        while (!game.isCompleted() && init.getExitSwitch().equals(false)) {
            System.out.println("******INFO FOR TESTING:******");
            System.out.println("current room: " + player.getCurrentRoom());
            System.out.println("current room directions: " + player.getCurrentRoom().getListOfAvailableDirections());
            System.out.println("current room pickupable items: " + player.getCurrentRoom().getListOfPickupableItems());
            System.out.println("current room static items: " + player.getCurrentRoom().getListOfStaticItems());
            System.out.println("player inventory: " + player.getInventory().getItemsInInventory());
            String input = scanner.nextLine();
            if (input.equals("exit")) {init.setExitSwitch(true);}
            inputHandler.handleInput(input, player);
        }
    }
}