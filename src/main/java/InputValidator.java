import org.beryx.textio.TextTerminal;

import java.util.ArrayList;

public class InputValidator {
    private int totalDirInInput = 0;
    private int totalPItemsInInput = 0;
    private int totalSItemsInInput = 0;
    private ArrayList<String> listOfValidInputtedWords = new ArrayList<>();
    private String input;
    private Room currentRoom;
    private int typeOfInput;
    private Player player;

    //Main Method
    public void validateInput(String input, Player player, TextTerminal terminal) { //check of the validity of input
        resetInputHandlerVariables();
        updateInputHandlerVariables(input, player);
        inputValidator();
//        System.out.println("type: " + typeOfInput + ", valid: " + listOfValidInputtedWords);
//        System.out.println("INPUT: dirs: " + totalDirInInput + " p: " + totalPItemsInInput + " s: " + totalSItemsInInput) ;
        passInput(terminal);
    }

    //Class Variable Methods
    private void resetInputHandlerVariables() { //input handler variables' reset
        totalDirInInput = 0;
        totalPItemsInInput = 0;
        totalSItemsInInput = 0;
        listOfValidInputtedWords.clear();
    }

    private void updateInputHandlerVariables(String input, Player player){ //update input, player and currentRoom
        this.input = input;
        this.player = player;
        currentRoom = player.getCurrentRoom();
    }

    //Word Input Validation Methods
    public void wordValidator(){ //parsing input, check if: the inputted word is a valid move/static item/pickupable item
        String[] parsedInput = inputParser();
        for (String wordToCheck : parsedInput) {
            isWordValidMove(wordToCheck);
            isWordValidStaticItem(wordToCheck);
            isWordValidPickupableItem(wordToCheck);
        }
    }

    private String[] inputParser(){
        //parses input separated by (multiple)spaces
        String delimiters = "[ ]+";
        return input.split(delimiters);
    }

    private void isWordValidMove(String wordToCheck){ //checks if the parsed input is a valid move
        for (int j = 0; j < currentRoom.getListOfAvailableDirections().size(); j++) {
            String validDir = currentRoom.getListOfAvailableDirections().get(j);
            if (wordToCheck.equals(validDir)) {
                totalDirInInput++;
                listOfValidInputtedWords.add(wordToCheck);
            }
        }
    }

    private void isWordValidStaticItem(String wordToCheck){ //checks if the parsed input is a valid static item
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

    private void isWordValidPickupableItem(String wordToCheck){ //checks if the parsed input is a valid pickupable item
        if (currentRoom.getListOfPickupableItems() != null){
            for (int j = 0; j < currentRoom.getListOfPickupableItems().size(); j++) {
                String validPickupableItemName = currentRoom.getListOfPickupableItems().get(j).getName();
                if (wordToCheck.equals(validPickupableItemName)){
                    totalPItemsInInput++;
                    listOfValidInputtedWords.add(wordToCheck);
                }
            }
        }
        if (player.getInventory().getItemsInInventory() != null){
            for (int i = 0; i < player.getInventory().getItemsInInventory().size(); i++){
                String validPickupableItemName = player.getInventory().getItemsInInventory().get(i).getName();
                if (wordToCheck.equals(validPickupableItemName)){
                    totalPItemsInInput++;
                    listOfValidInputtedWords.add(wordToCheck);
                }
            }
        }
    }

    //Sentence Input Validation Methods
    private void inputValidator(){
        wordValidator();
        inputTypeValidator();
    }

    private Boolean isInputADirection(){ //checks if input is a direction
        return (totalDirInInput == 1 && totalPItemsInInput == 0 && totalSItemsInInput == 0);
    }

    private Boolean isInputAPickupableItemAndStaticItem(){ //checks if input is a pickupable item and static item
        return (totalPItemsInInput == 1 && totalSItemsInInput == 1 && totalDirInInput == 0);
    }

    private Boolean isInputAPickupableItem(){ //checks if input is a pickupable item
        return (totalPItemsInInput == 1 && totalDirInInput == 0 && totalSItemsInInput == 0);
    }

    private Boolean isInputAStaticItem(){ //checks if input is a static item
        return (totalSItemsInInput == 1 && totalDirInInput == 0 && totalPItemsInInput == 0);
    }

    //Post-Validation Methods
    private void inputTypeValidator(){ //assigning a number to typeOfInput depending on the type of input
        if (isInputADirection()){typeOfInput = 1;} //if direction - assign 1
        else if (isInputAPickupableItem()){typeOfInput = 2;} //if pickupable item - assign 2
        else if (isInputAStaticItem()){typeOfInput = 3;} //if static item - assign 3
        else if (isInputAPickupableItemAndStaticItem()){typeOfInput = 4;} //if pickupable item and static item - assign 4
        else typeOfInput = 0; //if neither, assign 0
    }

    private void orderItems(String item1, String item2){ //put items in right order
        for (int j = 0; j < currentRoom.getListOfStaticItems().size(); j++) {
            String validStaticItemName = currentRoom.getListOfStaticItems().get(j).getName();
            if (item1.equals(validStaticItemName)) {
                listOfValidInputtedWords.clear();
                listOfValidInputtedWords.add(item2);
                listOfValidInputtedWords.add(item1);
            }
        }
    }

    private void passInput(TextTerminal terminal){ //passing input to another class called player
        switch (typeOfInput){
            case 1:
                player.movePlayer(listOfValidInputtedWords.get(0)); //passing inputted move to function movePlayer
                break;
            case 2:
                player.pickUpPickupableItem(listOfValidInputtedWords.get(0), terminal); //passing inputted item to function pickUpPickupableItem
                break;
            case 3:
                player.actionStaticItem(listOfValidInputtedWords.get(0), terminal); //passing inputted static item to function actionStaticItem
                break;
            case 4:
                orderItems(listOfValidInputtedWords.get(0), listOfValidInputtedWords.get(1)); //setting order such that pickupable item is before static item
                player.usePickupableItemOnStaticItem(listOfValidInputtedWords.get(0), listOfValidInputtedWords.get(1), terminal);
                break;
            default:
        }
    }
}
