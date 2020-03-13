import org.beryx.textio.TextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;

import java.util.ArrayList;

public class InputValidator {
    //Attributes
    private final ArrayList<String> listOfValidWords = new ArrayList<>();
    private int totalDirInInput = 0;
    private int totalPItemsInInput = 0;
    private int totalSItemsInInput = 0;
    private int typeOfInput;
    private String input;
    private Player player;
    private Room currentRoom;

    //Main Method
    public void validateInput(String input, Player player, TextTerminal<SwingTextTerminal> terminal) {
        //Resets and appoints values to attributes.
        //Proceeds to validate input and pass that input, through method calls.
        resetInputHandlerVariables();
        updateInputHandlerVariables(input, player);
        inputValidator();
        passInput(terminal);
    }

    //Class Variable Methods
    private void resetInputHandlerVariables() {
        //Resets attributes (that are used to lessen down the amount of parameters passed in this class)
        totalDirInInput = 0;
        totalPItemsInInput = 0;
        totalSItemsInInput = 0;
        listOfValidWords.clear();
    }

    private void updateInputHandlerVariables(String input, Player player){
        //Updates attributes (that are used to lessen down the amount of parameters passed in this class)
        this.input = input;
        this.player = player;
        currentRoom = player.getCurrentRoom();
    }

    //Word Input Validation Methods
    public void wordValidator(){
        //Parses input,
        //Checks if the inputted word is in the lists of current room's move/static item/pickupable item
        //(If yes, the called methods will add this word to listOfValidWords.)
        String[] parsedInput = inputParser();
        for (String wordToCheck : parsedInput) {
            isWordValidMove(wordToCheck);
            isWordValidStaticItem(wordToCheck);
            isWordValidPickupableItem(wordToCheck);
        }
    }

    private String[] inputParser(){
        //Parses input separated by (multiple)spaces.
        String delimiters = "[ ]+";
        return input.split(delimiters);
    }

    private void isWordValidMove(String wordToCheck){
        //Checks if passed word is a valid move. If yes, word is added to listOfValidWords,
        //and total directions in input is increased (needs to be 1 to have a valid input).
        for (int j = 0; j < currentRoom.getListOfAvailableDirections().size(); j++) {
            String validDir = currentRoom.getListOfAvailableDirections().get(j);
            if (wordToCheck.equals(validDir)) {
                totalDirInInput++;
                listOfValidWords.add(wordToCheck);
            }
        }
    }

    private void isWordValidStaticItem(String wordToCheck){
        //Checks if passed word is a valid static Item, by checking if it is in the list of currentRoom.
        //If yes, word is added to listOfValidWords.
        if (currentRoom.getListOfStaticItems() != null){
            for (int j = 0; j < currentRoom.getListOfStaticItems().size(); j++) {
                String validStaticItemName = currentRoom.getListOfStaticItems().get(j).getName();
                if (wordToCheck.equals(validStaticItemName)){
                    totalSItemsInInput++;
                    listOfValidWords.add(wordToCheck);
                }
            }
        }
    }

    private void isWordValidPickupableItem(String wordToCheck){
        //Checks if passed word is a valid pickupable Item, by checking if it is in the list of currentRoom.
        //If yes, word is added to listOfValidWords.
        if (currentRoom.getListOfPickupableItems() != null){
            for (int j = 0; j < currentRoom.getListOfPickupableItems().size(); j++) {
                String validPickupableItemName = currentRoom.getListOfPickupableItems().get(j).getName();
                if (wordToCheck.equals(validPickupableItemName)){
                    totalPItemsInInput++;
                    listOfValidWords.add(wordToCheck);
                }
            }
        }
        if (player.getInventory().getItemsInInventory() != null){
            for (int i = 0; i < player.getInventory().getItemsInInventory().size(); i++){
                String validPickupableItemName = player.getInventory().getItemsInInventory().get(i).getName();
                if (wordToCheck.equals(validPickupableItemName)){
                    totalPItemsInInput++;
                    listOfValidWords.add(wordToCheck);
                }
            }
        }
    }

    //Sentence Input Validation Methods
    private void inputValidator(){
        //Main method. Calls to validate words, and then based on the amount of words valid,
        //finds out the input type (which is a number), to signify what should be done with this input.
        wordValidator();
        inputTypeValidator();
    }

    private Boolean isInputADirection(){
        //Checks if input has only one directional valid word.
        return (totalDirInInput == 1 && totalPItemsInInput == 0 && totalSItemsInInput == 0);
    }

    private Boolean isInputAPickupableItemAndStaticItem(){
        //Checks if input has only one valid word of both pickupable item and static item.
        return (totalPItemsInInput == 1 && totalSItemsInInput == 1 && totalDirInInput == 0);
    }

    private Boolean isInputAPickupableItem(){
        //Checks if input has only one valid word of pickupable item.
        return (totalPItemsInInput == 1 && totalDirInInput == 0 && totalSItemsInInput == 0);
    }

    private Boolean isInputAStaticItem(){
        //Checks if input has only one valid word of pickupable item.
        return (totalSItemsInInput == 1 && totalDirInInput == 0 && totalPItemsInInput == 0);
    }

    //Post-Validation Methods
    private void inputTypeValidator(){
        //Assigns a number to typeOfInput depending on the type of input (depending on amount of valid words).
        if (isInputADirection()){typeOfInput = 1;} //if input is valid direction - assign 1
        else if (isInputAPickupableItem()){typeOfInput = 2;} //if input is valid pickupable item - assign 2
        else if (isInputAStaticItem()){typeOfInput = 3;} //if input is valid static item - assign 3
        else if (isInputAPickupableItemAndStaticItem()){typeOfInput = 4;} //input valid pickupable&staticitem - assign 4
        else typeOfInput = 0; //all else cases, assign 0
    }

    private void orderItems(String item1, String item2){
        //Puts items in right order if using pickupable item on static item. (Need to pass right parameters)
        for (int j = 0; j < currentRoom.getListOfStaticItems().size(); j++) {
            String validStaticItemName = currentRoom.getListOfStaticItems().get(j).getName();
            if (item1.equals(validStaticItemName)) {
                listOfValidWords.clear();
                listOfValidWords.add(item2);
                listOfValidWords.add(item1);
            }
        }
    }

    private void passInput(TextTerminal<SwingTextTerminal> terminal){
        //Passing input to player object. TODO: put logical checks to inputvalidator?
        switch (typeOfInput){
            case 1:
                player.movePlayer(listOfValidWords.get(0)); //passing inputted move to function movePlayer
                break;
            case 2:
                player.pickUpPickupableItem(listOfValidWords.get(0), terminal); //passing inputted item to function pickUpPickupableItem
                break;
            case 3:
                player.actionStaticItem(listOfValidWords.get(0), terminal); //passing inputted static item to function actionStaticItem
                break;
            case 4:
                orderItems(listOfValidWords.get(0), listOfValidWords.get(1)); //setting order such that pickupable item is before static item
                player.usePickupableItemOnStaticItem(listOfValidWords.get(0), listOfValidWords.get(1), terminal);
                break;
            default:
        }
    }
}
