import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        //main game loop
        while (!game.isCompleted() && exitSwitch.equals(false)) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {exitSwitch = true;}
            inputHandler.handleInput(input, player.getCurrentRoom());
        }
    }
}