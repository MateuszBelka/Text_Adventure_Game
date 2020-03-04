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
    public void handleInput(String input, Player player) {
        resetInputHandlerVariables();
        updateInputHandlerVariables(input, player);
        inputValidator();
        System.out.println("type: " + typeOfInput + ", valid: " + listOfValidInputtedWords);
        System.out.println("INPUT: dirs: " + totalDirInInput + " p: " + totalPItemsInInput + " s: " + totalSItemsInInput) ;
        passInput();
    }

    //Class Variable Methods
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

    //Word Validation Methods
    public void wordValidator(){
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

    private void isWordValidMove(String wordToCheck){
        for (int j = 0; j < currentRoom.getListOfAvailableDirections().size(); j++) {
            String validDir = currentRoom.getListOfAvailableDirections().get(j);
            if (wordToCheck.equals(validDir)) {
                totalDirInInput++;
                listOfValidInputtedWords.add(wordToCheck);
            }
        }
    }

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

    //Full Input Validation Methods
    private void inputValidator(){
        wordValidator();
        inputTypeValidator();
    }

    private Boolean isInputADirection(){
        return (totalDirInInput == 1 && totalPItemsInInput == 0 && totalSItemsInInput == 0);
    }

    private Boolean isInputAPickupableItemAndStaticItem(){
        return (totalPItemsInInput == 1 && totalSItemsInInput == 1 && totalDirInInput == 0);
    }

    private Boolean isInputAPickupableItem(){
        return (totalPItemsInInput == 1 && totalDirInInput == 0 && totalSItemsInInput == 0);
    }

    private Boolean isInputAStaticItem(){
        return (totalSItemsInInput == 1 && totalDirInInput == 0 && totalPItemsInInput == 0);
    }

    //Post-Validation Methods
    private void inputTypeValidator(){
        if (isInputADirection()){typeOfInput = 1;}
        else if (isInputAPickupableItem()){typeOfInput = 2;}
        else if (isInputAStaticItem()){typeOfInput = 3;}
        else if (isInputAPickupableItemAndStaticItem()){typeOfInput = 4;}
        else typeOfInput = 0;
    }

    private void orderItems(String item1, String item2){
        for (int j = 0; j < currentRoom.getListOfStaticItems().size(); j++) {
            String validStaticItemName = currentRoom.getListOfStaticItems().get(j).getName();
            if (item1.equals(validStaticItemName)) {
                listOfValidInputtedWords.clear();
                listOfValidInputtedWords.add(item2);
                listOfValidInputtedWords.add(item1);
            }
        }
    }

    private void passInput(){
        switch (typeOfInput){
            case 1:
                player.movePlayer(listOfValidInputtedWords.get(0));
                break;
            case 2:
                player.pickUpPickupableItem(listOfValidInputtedWords.get(0));
                break;
            case 3:
                player.actionStaticItem(listOfValidInputtedWords.get(0));
                break;
            case 4:
                orderItems(listOfValidInputtedWords.get(0), listOfValidInputtedWords.get(1));
                player.usePickupableItemOnStaticItem(listOfValidInputtedWords.get(0), listOfValidInputtedWords.get(1));
                break;
            default:
        }
    }
}

//todo: debug "multiple milk"
