import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Initialisation init = new Initialisation();
        init.initializeEntireStory();

        //main game loop
        while (!init.getGames().get(0).isCompleted() && init.getExitSwitch().equals(false)) {
            System.out.println("******INFO FOR TESTING:******");
            System.out.println("current room: " + init.getPlayers().get(0).getCurrentRoom());
            System.out.println("current room directions: " + init.getPlayers().get(0).getCurrentRoom().getListOfAvailableDirections());
            System.out.println("pickupable items: " + init.getPlayers().get(0).getCurrentRoom().getListOfPickupableItems());
            System.out.println("static items: " + init.getPlayers().get(0).getCurrentRoom().getListOfStaticItems());
            System.out.println("current room pickupable items: " + init.getPlayers().get(0).getCurrentRoom().getListOfPickupableItems());
            System.out.println("current room static items: " + init.getPlayers().get(0).getCurrentRoom().getListOfStaticItems());
            String input = scanner.nextLine();
            if (input.equals("exit")) {init.setExitSwitch(true);}
            init.getInputHandlers().get(0).handleInput(input, init.getPlayers().get(0));
        }
    }
}