import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Initialisation init = new Initialisation();

        //main game loop
        while (!init.getGames().get(0).isCompleted() && init.getExitSwitch().equals(false)) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {init.setExitSwitch(true);}
            init.getInputHandlers().get(0).handleInput(input, init.getPlayers().get(0));
        }
    }
}