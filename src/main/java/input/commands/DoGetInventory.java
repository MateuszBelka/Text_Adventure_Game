package input.commands;

import gameElements.levelAndContents.Item;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

import java.util.ArrayList;

public class DoGetInventory {
    public static void doInventoryLookUp(){
        //prints a list of names of the inventory items, if any.
        ArrayList<Item> listOfItems = InitOfClassesThroughSaveFile.getInventory().getListOfItems();
        String inventoryList = "Inventory: ";

        for (Item item : listOfItems){
            inventoryList = inventoryList + "[" + item.getName() + "] ";
        }

        if (inventoryList.equals("Inventory: ")){
            InteractionPrinter.print("Inventory is empty.");
        }
        else{
            InteractionPrinter.print(inventoryList);
        }
    }

    private DoGetInventory(){} //hiding the implicit public constructor
}
