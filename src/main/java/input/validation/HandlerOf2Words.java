package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;
import java.util.HashMap;

import static input.commands.Attack.doAttack;
import static input.commands.Break.doBreakWithoutItem;
import static input.commands.Close.doClose;
import static input.commands.Consume.doConsume;
import static input.commands.Drop.doDrop;
import static input.commands.Examine.doExamine;
import static input.commands.GiveItemToNPC.doGiveItemToNPC;
import static input.commands.Open.doOpen;
import static input.commands.PickUp.doPickUp;
import static input.commands.Pull.doPull;
import static input.commands.Push.doPush;
import static input.commands.Read.doRead;
import static input.commands.Smell.doSmell;
import static input.commands.TalkWith.doTalkWith;
import static input.commands.Use.doUse;
import static input.commands.Use.doUseItemOnNPC;
import static input.commands.Listen.doListenTo;
import static input.validation.InputValidation.getKeyInValidInputList;

public class HandlerOf2Words {

    protected static void validateAndHandle2Words(HashMap<String, String> validInputList){
        if (validInputList.containsKey("item") && validInputList.containsKey("npc")) {
            validateAndHandleItemAndNPCCombination(validInputList);
        }
        if (validInputList.containsKey("command") && validInputList.containsKey("item")){
            validateAndHandleCommandAndItemCombination(validInputList);
        }
        if (validInputList.containsKey("command") && validInputList.containsKey("npc")){
            //todo: check if command is valid for that item. if yes, return true. If no, print "you cannot do that"
        }
        else {
            //todo: print "You cannot do that. Try in the form [command] + [thing] ( + [thing] )"
        }
    }

    private static void validateAndHandleItemAndNPCCombination(HashMap<String, String> validInputList){
        String itemName = getKeyInValidInputList(validInputList, "item");
        String npcName = getKeyInValidInputList(validInputList, "npc");
        NPC npc = NPC.getNPCByName(npcName);
        Item item = Item.getItemByName(itemName);

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

        ArrayList<Item> itemsInLocation = CollectionOfAllClasses.getPlayer().getCurrentLocation().getListOfItems();
        for (Item itemInLocation : itemsInLocation){
            if (itemInLocation.equals(item)){
                //todo: print: "Cannot do that. Maybe try to pick " + item + " up first?"
            }
        }
    }

    private static void validateAndHandleCommandAndItemCombination(HashMap<String, String> validInputList){
        String command = getKeyInValidInputList(validInputList, "command");
        String itemName = getKeyInValidInputList(validInputList, "item");
        Item item = Item.getItemByName(itemName);

        switch (command){
            case "USE":
                if (item.getCanBeUsed()) { doUse(item); }
                else {/*todo: print: itemName + " cannot be used ."*/}
                break;
            case "EAT":
            case "DRINK":
            case "CONSUME":
                if (item.getCanBeConsumed()){ doConsume(item); }
                else {/*todo: print: "Cannot consume * + itemName + "."*/}
                break;
            case "TAKE":
            case "PICK":
            case "GRAB":
            case "GET":
            case "PICKUP":
                if (item.getCanBePickedUp()){ doPickUp(item); }
                else { /*todo: print: "Cannot pick up * + itemName + "."*/ }
                break;
            case "DROP":
                if (item.getCanBeDropped()) { doDrop(item); }
                else {/*todo: print: "Cannot drop " + itemName + "."*/}
                break;
            case "READ":
                if (item.getCanBeRead()) { doRead(item); }
                else { /*todo: print: "Cannot read * + itemName + "."*/ }
                break;
            case "EXAMINE":
                if (item.getCanBeExamined()) { doExamine(item); }
                else { /*todo: print: "Cannot examine * + itemName + "."*/ }
                break;
            case "SMELL":
                if (item.getCanBeSmelled()) { doSmell(item); }
                else { /*todo: print: itemName + " cannot be smelled."*/ }
                break;
            case "PUSH":
                if (item.getCanBePushed()) { doPush(item); }
                else { /*todo: print: itemName + " cannot be pushed."*/ }
                break;
            case "PULL":
                if (item.getCanBePulled()) { doPull(item); }
                else { /*todo: print: itemName + " cannot be pulled."*/ }
                break;
            case "LISTEN":
                if (item.getCanBeListenedTo()) { doListenTo(item); }
                else { /*todo: print: itemName + " cannot be listened to."*/ }
                break;
            case "TALK":
                if (item.getCanBeTalkedWith()) { doTalkWith(item); }
                else { /*todo: print: itemName + " cannot be talked to."*/ }
                break;
            case "OPEN":
                if (item.getCanBeOpened()) { doOpen(item); }
                else { /*todo: print: itemName + " cannot be opened."*/}
                break;
            case "CLOSE":
                if (item.getCanBeClosed()) { doClose(item); }
                else { /*todo: print: itemName + " cannot be closed."*/}
                break;
            case "CUT":
                cutItemHandler(item);
                break;
            case "ATTACK":
                if (item.getCanBeAttacked()) { doAttack(item); }
                else { /*todo: print: itemName + " cannot be attacked."*/}
                break;
            case "BREAK":
                if (item.getCanBeBrokenWithoutItem()) { doBreakWithoutItem(item); }
                else { /*todo: print: itemName + " cannot be broken."*/}
                break;
            default:
                //todo: print: "Cannot do that."
        }
    }

    private static void cutItemHandler(Item item){
        //if item can be cut,
        //if there is an item to cut with, in inventory.
        //
    }


}
