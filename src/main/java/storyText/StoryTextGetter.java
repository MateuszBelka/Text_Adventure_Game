package storyText;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.Player;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;

public class StoryTextGetter {
    private ArrayList<String> listToPrint = new ArrayList<>();
    private transient Player player = CollectionOfAllClasses.getPlayer();

    //Get Methods
    public Player getPlayer() {
        return player;
    }

    //Set Methods
    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<String> compileStoryText(){
        listToPrint.clear();

        addLevelTextIfFirstPrint();
        addLocationTextIfFirstPrint();
        addItemsTextsIfFirstPrint();
        addNPCsTextsIfFirstPrint();
        addListOfEntitiesInLocation();

        return listToPrint;
    }

    private void addLevelTextIfFirstPrint(){
        Boolean firstPrintOfLevel = player.getCurrentLevel().descriptionPrintedOnce();

        if (firstPrintOfLevel) {
            listToPrint.add(player.getCurrentLevel().getDescription());
        }
    }

    private void addLocationTextIfFirstPrint(){
        Boolean firstPrintOfLocation = player.getCurrentLocation().descriptionPrintedOnce();

        if (firstPrintOfLocation) {
            listToPrint.add(player.getCurrentLocation().getDescription());
        }
    }

    private void addItemsTextsIfFirstPrint(){
        for (int i = 0; i < player.getCurrentLocation().getListOfItems().size(); i++){
            Boolean firstPrintOfItem = player.getCurrentLocation().getListOfItems().get(i).descriptionPrintedOnce();

            if (firstPrintOfItem) {
                listToPrint.add(player.getCurrentLocation().getListOfItems().get(i).getDescription());
            }
        }
    }

    private void addNPCsTextsIfFirstPrint(){
        for (int i = 0; i < player.getCurrentLocation().getListOfNPCs().size(); i++){
            Boolean firstPrintOfNPC = player.getCurrentLocation().getListOfNPCs().get(i).descriptionPrintedOnce();

            if (firstPrintOfNPC) {
                listToPrint.add(player.getCurrentLocation().getListOfNPCs().get(i).getDescription());
            }
        }
    }

    private void addListOfEntitiesInLocation(){
        addListOfItems();
        addListOfNPCs();
    }

    private String addListOfItems(){
        StringBuilder compiledListOfItems = new StringBuilder();
        ArrayList<Item> listOfItems = player.getCurrentLocation().getListOfItems();

        for (int i = 0; i < listOfItems.size(); i++){
            String itemToAdd = "[" + listOfItems.get(i) + "] ";
            compiledListOfItems.append(itemToAdd);
        }
        return compiledListOfItems.toString();
    }

    private String addListOfNPCs(){
        StringBuilder compiledListOfNPCs = new StringBuilder();
        ArrayList<NPC> listOfNPCs = player.getCurrentLocation().getListOfNPCs();

        for (int i = 0; i < listOfNPCs.size(); i++){
            String itemToAdd = "<" + listOfNPCs.get(i) + "> ";
            compiledListOfNPCs.append(itemToAdd);
        }
        return compiledListOfNPCs.toString();
    }


}
