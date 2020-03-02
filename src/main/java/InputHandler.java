import java.util.ArrayList;

public class InputHandler {
    private int totalDirInInput = 0;
    private int totalPItemsInInput = 0;
    private int totalSItemsInInput = 0;
    private ArrayList<String> listOfValidInputtedWords = new ArrayList<>();
    private String input;
    private Room currentRoom;
    private int typeOfInput;

    public void addValidWordToList (String word) {listOfValidInputtedWords.add(word);}

    public ArrayList<String> getListOfValidInputtedWords() {return listOfValidInputtedWords;}

    private void resetInputHandlerVariables() {
        totalDirInInput = 0;
        totalPItemsInInput = 0;
        totalSItemsInInput = 0;
        listOfValidInputtedWords.clear();
    }

    //parses input separated by (multiple)spaces
    private String[] inputParser(){
        String delimiters = "[ ]+";
        return input.split(delimiters);
    }

    //validate move and add to total amount of directional words in input
    private void isWordValidMove(String wordToCheck){
        for (int j = 0; j < currentRoom.getListOfAvailableDir().size(); j++) {
            String validDir = currentRoom.getListOfAvailableDir().get(j);
            if (wordToCheck.equals(validDir)) {
                totalDirInInput++;
                addValidWordToList(wordToCheck);
            }
        }
    }

    //validate staticItem and add to total amount of static items in input
    private void isWordValidStaticItem(String wordToCheck){
        for (int j = 0; j < currentRoom.getListOfStaticItems().size(); j++) {
            String validStaticItemName = currentRoom.getListOfStaticItems().get(j).getName();
            if (wordToCheck.equals(validStaticItemName)){
                totalSItemsInInput++;
                addValidWordToList(wordToCheck);
            }
        }
    }

    //validate pickupableItem and add to total amount of pickupable items in input
    private void isWordValidPickupableItem(String wordToCheck){
        for (int j = 0; j < currentRoom.getListOfPickupableItems().size(); j++) {
            String validPickupableItemName = currentRoom.getListOfPickupableItems().get(j).getName();
            if (wordToCheck.equals(validPickupableItemName)){
                totalPItemsInInput++;
                addValidWordToList(wordToCheck);
            }
        }
    }

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

    private void updateInputHandlerVariables(String receivedInput, Room currRoom){
        input = receivedInput;
        currentRoom = currRoom;
    }

    private void doCommand(){
        switch (typeOfInput){
            case 1:
                System.out.println("movePlayer");
                break;
            case 2:
                System.out.println("pickupPickupableItem");
                break;
            case 3:
                System.out.println("'action' staticItem");
                break;
            case 4:
                System.out.println("use pickupableItem on staticItem");
                break;
            default:
        }
    }

    public void handleInput(String receivedInput, Room currRoom){
        resetInputHandlerVariables();
        updateInputHandlerVariables(receivedInput, currRoom);
        inputValidator();
//        doCommand();
        System.out.println(typeOfInput);
        System.out.println(getListOfValidInputtedWords());


    }

}