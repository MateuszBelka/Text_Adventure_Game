package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;
import java.util.HashMap;

import static input.commands.GiveItemToNPC.doGiveItemToNPC;
import static input.commands.UseItemOnNPC.doUseItemOnNPC;
import static input.validation.InputValidation.getKeyInValidInputList;

public class HandlerOf2Words {

    protected static Boolean validateAndHandle2Words(HashMap<String, String> validInputList){
        if (validInputList.containsKey("item") && validInputList.containsKey("npc")) {
            validateAndHandleItemAndNPCCombination(validInputList);
        }
        if (validInputList.containsKey("npc") && validInputList.containsValue("npc")) {/*todo: print "you cannot do that" */}
        if (validInputList.containsKey("command") && validInputList.containsValue("command")) {/*todo: print "you cannot do that" */}
        if (validInputList.containsKey("command") && validInputList.containsKey("item")){
            //todo: check if command is valid for that item. if yes, return true. If no, print "you cannot do that"
        }
        if (validInputList.containsKey("command") && validInputList.containsKey("npc")){
            //todo: check if command is valid for that item. if yes, return true. If no, print "you cannot do that"
        }
        return true; // can be deleted.
    }

    //todo: clean horrid method :D
    private static Boolean validateAndHandleItemAndNPCCombination(HashMap<String, String> validInputList){
        String itemName = getKeyInValidInputList(validInputList, "item");
        String npcName = getKeyInValidInputList(validInputList, "npc");
        ArrayList<NPC> npcs = CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfNPCs();
        NPC npc = null;

        for (NPC value : npcs) {
            if (value.getName().equals(npcName)) {
                npc = value;
            }
        }

        ArrayList<Item> itemsInInventory = CollectionOfAllClasses.getInventory().getItemsInInventory();
        for (Item item: itemsInInventory){
            if (item.getName().equals(itemName)){
                if(npc.getItemToBeUsedOn().equals(item)){
                    if(item.getCanBeGivenTo()){
                        doGiveItemToNPC(item, npc);
                    }
                    else if (item.getCanBeUsedOnNPC()){
                        doUseItemOnNPC(item, npc);
                    }
                    else{
                        //todo:print: "Cannot give or use " + itemName + " to " + npcName + "."
                    }
                }
            }
        }

        ArrayList<Item> itemsInLocation = CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfItems();
        //todo: finish writing what happens if item is in location.
        return false; //delete this, and change method into void.
    }

    protected static void handle2ValidWords(HashMap<String, String> validInputList){
        //todo: write this method.
    }


}
