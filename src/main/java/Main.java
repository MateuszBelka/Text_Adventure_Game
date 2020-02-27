
public class Main {
    public static void main (String[] args){
        Game game = new Game();
        Room room = new Room();
        GameLoadStory gameLoadStory = new GameLoadStory();
        StaticItem staticItem = new StaticItem();
        PickupableItem pickupableItem = new PickupableItem();
        Player player = new Player();
        Inventory inventory = new Inventory();
        Input input = new Input();
        Output output = new Output();

        game.print();
        room.print();
        gameLoadStory.print();
        staticItem.print();
        pickupableItem.print();
        player.print();
        inventory.print();
        input.print();
        output.print();
    }
}