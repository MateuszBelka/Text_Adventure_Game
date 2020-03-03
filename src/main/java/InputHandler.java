import java.util.ArrayList;

public class InputHandler {
    private int totalDirInInput = 0;
    private int totalPItemsInInput = 0;
    private int totalSItemsInInput = 0;
    private ArrayList<String> listOfValidInputtedWords = new ArrayList<>();
    private String input;
    private Room currentRoom;
    private int typeOfInput;
    private Player player;

    private void resetInputHandlerVariables() {
        totalDirInInput = 0;
        totalPItemsInInput = 0;
        totalSItemsInInput = 0;
        listOfValidInputtedWords.clear();
    }

    private void updateInputHandlerVariables(String input, Player player){
        this.input = input;
        this.player = player;
        currentRoom = player.getCurrentRoom();
    }

    //parses input separated by (multiple)spaces
    private String[] inputParser(){
        String delimiters = "[ ]+";
        return input.split(delimiters);
    }

    //validate move and add to total amount of directional words in input
    private void isWordValidMove(String wordToCheck){
        for (int j = 0; j < currentRoom.getListOfAvailableDirections().size(); j++) {
            String validDir = currentRoom.getListOfAvailableDirections().get(j);
            if (wordToCheck.equals(validDir)) {
                totalDirInInput++;
                listOfValidInputtedWords.add(wordToCheck);
            }
        }
    }

    //validate staticItem and add to total amount of static items in input
    private void isWordValidStaticItem(String wordToCheck){
        if (currentRoom.getListOfStaticItems() != null){
            for (int j = 0; j < currentRoom.getListOfStaticItems().size(); j++) {
                String validStaticItemName = currentRoom.getListOfStaticItems().get(j).getName();
                if (wordToCheck.equals(validStaticItemName)){
                    totalSItemsInInput++;
                    listOfValidInputtedWords.add(wordToCheck);
                }
            }
        }
    }

    //validate pickupableItem and add to total amount of pickupable items in input
    private void isWordValidPickupableItem(String wordToCheck){
        if (currentRoom.getListOfPickupableItems() != null){
            for (int j = 0; j < currentRoom.getListOfPickupableItems().size(); j++) {
                String validPickupableItemName = currentRoom.getListOfPickupableItems().get(j).getName();
                if (wordToCheck.equals(validPickupableItemName)){
                    totalPItemsInInput++;
                    listOfValidInputtedWords.add(wordToCheck);
                }
            }
        }
    }

    //todo: rename isInputValidPickupableItem/StaticItem to something that shows it is an action. isInputValidPickup? isInputValidUseSI?
    //todo: isInputValidUsePIonSI is breaking naming convention
    private Boolean isInputValidMove(){
        return (totalDirInInput == 1 && totalPItemsInInput == 0 && totalSItemsInInput == 0);
    }
    private Boolean isInputValidUsePIonSI(){
        return (totalPItemsInInput == 1 && totalSItemsInInput == 1 && totalDirInInput == 0);
    }
    private Boolean isInputValidPickupableItem(){
        return (totalPItemsInInput == 1 && totalDirInInput == 0 && totalSItemsInInput == 0);
    }
    private Boolean isInputValidStaticItem(){
        return (totalSItemsInInput == 1 && totalDirInInput == 0 && totalPItemsInInput == 0);
    }

    public void wordValidator(){
        String[] parsedInput = inputParser();
        for (String wordToCheck : parsedInput) {
            isWordValidMove(wordToCheck);
            isWordValidStaticItem(wordToCheck);
            isWordValidPickupableItem(wordToCheck);
        }
    }

    private void inputTypeValidator(){
        if (isInputValidMove()){typeOfInput = 1;}
        else if (isInputValidPickupableItem()){typeOfInput = 2;}
        else if (isInputValidStaticItem()){typeOfInput = 3;}
        else if (isInputValidUsePIonSI()){typeOfInput = 4;}
        else typeOfInput = 0;
    }

    private void inputValidator(){
        wordValidator();
        inputTypeValidator();
    }

    private void pickUpPickupableItem(){
        String nameOfItemToPickUp = listOfValidInputtedWords.get(0);
        PickupableItem itemToPickUp = currentRoom.getPickupableItemByName(nameOfItemToPickUp);
        currentRoom.deletePickupableItemFromList(itemToPickUp);
        //todo: add item to Inventory
    }

    private void movePlayer(){
        String dirToMove = listOfValidInputtedWords.get(0);
        Room roomToMove = currentRoom.getRoomInDirection(dirToMove);
        player.setCurrentRoom(roomToMove);
    }

    private void actionStaticItem(){
        String nameOfStaticItemToAction = listOfValidInputtedWords.get(0);
        StaticItem staticItemToAction = currentRoom.getStaticItemByName(nameOfStaticItemToAction);
        if (staticItemToAction.isActionable()){
            currentRoom.deleteStaticItemFromList(staticItemToAction);
            //todo: decrease puzzles left to solve
            //todo: how to get to item, for reading its puzzle solved story text?.......
        }
        else{System.out.println("HINT : This item needs another item.");}
    }

    private void usePickupableItemOnStaticItem(){
        //todo: check valid input list 0 if it is a static item. from there on, save static item and pickupable item
        //todo: check if P item is in inventory
        //todo: check if S item is in current room
        //todo: deal with error messages
        //todo: if all is correct: delete P item from inventory, delete S item from current room S list.
    }

    private void doInput(){
        switch (typeOfInput){
            case 1:
                movePlayer();
                break;
            case 2:
                pickUpPickupableItem();
                break;
            case 3:
                actionStaticItem();
                break;
            case 4:
                System.out.println("use pickupableItem on staticItem");
//                usePickupableItemOnStaticItem();
                break;
            default:
        }
    }

    public void handleInput(String receivedInput, Player player){
        resetInputHandlerVariables();
        updateInputHandlerVariables(receivedInput, player);
        inputValidator();
        System.out.println("type: " + typeOfInput + ", valid: " + listOfValidInputtedWords);
        doInput();
    }

}
