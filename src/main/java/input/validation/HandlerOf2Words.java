package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import initialisation.CollectionOfAllClasses;

import java.util.ArrayList;
import java.util.HashMap;

import static input.commands.DoAttack.doAttack;
import static input.commands.DoBreak.doBreakWithoutItem;
import static input.commands.DoClose.doClose;
import static input.commands.DoConsume.doConsume;
import static input.commands.DoCut.doCutWith;
import static input.commands.DoDrop.doDrop;
import static input.commands.DoExamine.doExamine;
import static input.commands.DoGiveItemToNPC.doGiveItemToNPC;
import static input.commands.DoOpen.doOpen;
import static input.commands.DoPickUp.doPickUp;
import static input.commands.DoPull.doPull;
import static input.commands.DoPush.doPush;
import static input.commands.DoRead.doRead;
import static input.commands.DoSmell.doSmell;
import static input.commands.DoTalkWith.doTalkWith;
import static input.commands.DoUse.doUse;
import static input.commands.DoUse.doUseItemOnNPC;
import static input.commands.DoListen.doListenTo;
import static input.validation.HandlerOf1Word.handle1Direction;
import static input.validation.InputValidation.*;

public class HandlerOf2Words {
    protected static void validateAndHandle2Words(HashMap<String, String> validInputList){
        Item item = getItem(validInputList);
        String command = getCommand(validInputList);
        NPC npc = getNPC(validInputList);
        String direction = getDirection(validInputList);

        if (validInputList.containsKey("item") && validInputList.containsKey("npc")) {
            validateAndHandleItemAndNPCCombination(item, npc);
        }
        else if (validInputList.containsKey("command") && validInputList.containsKey("item")){
            validateAndHandleCommandAndItemCombination(command, item);
        }
        else if (validInputList.containsKey("command") && validInputList.containsKey("npc")){
            validateAndHandleCommandAndNPCCombination(command, npc);
        }
        else if (validInputList.containsKey("direction") && validInputList.containsKey("command")){
            validateAndHandleCommandAndDirectionCombination(command, direction);
        }
        else {
            //todo: print "You cannot do that. Try in the form [command] + [thing] ( + [thing] )"
        }
    }

    private static void validateAndHandleItemAndNPCCombination(Item item, NPC npc){
        if(npc.getItemToBeUsedOn().equals(item)){
            if(item.getCanBeGiven()){
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

    private static void validateAndHandleCommandAndItemCombination(String command, Item item){
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
            case "OBSERVE":
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
                cutItemCommand(item);
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

    private static void cutItemCommand(Item item){
        ArrayList<Item> itemsInInventory = CollectionOfAllClasses.getInventory().getItemsInInventory();

        if (item.getCanBeCut()){
            for (Item itemInInventory : itemsInInventory){
                if (item.getItemToCutWith().equals(itemInInventory)){
                    doCutWith(item, itemInInventory);
                }
            }
            //todo: else give message that user doesn't have the right item to cut?
        }
        else{
            //todo: print: item.getName() + " cannot be cut."
        }
    }

    private static void validateAndHandleCommandAndNPCCombination(String command, NPC npc) {
        switch (command) {
            case "LISTEN":
                if (npc.getCanBeListenedTo()) { doListenTo(npc); }
                else { /*todo: print: npcName + " cannot be listened to."*/ }
                break;
            case "TALK":
                if (npc.getCanBeTalkedWith()) { doTalkWith(npc); }
                else { /*todo: print: npcName + " cannot be talked to."*/ }
                break;
            case "ATTACK":
                if (npc.getCanBeAttacked()) { doAttack(npc); }
                else { /*todo: print: npcName + " cannot be attacked."*/}
                break;
            case "SMELL":
                if (npc.getCanBeSmelled()) { doSmell(npc); }
                else { /*todo: print: npcName + " cannot be smelled."*/ }
                break;
            case "PUSH":
                if (npc.getCanBePushed()) { doPush(npc); }
                else { /*todo: print: npcName + " cannot be pushed."*/ }
                break;
            case "PULL":
                if (npc.getCanBePulled()) { doPull(npc); }
                else { /*todo: print: npcName + " cannot be pulled."*/ }
                break;
            case "OBSERVE":
            case "EXAMINE":
                if (npc.getCanBeExamined()) { doExamine(npc); }
                else { /*todo: print: "Cannot examine * + npcName + "."*/ }
                break;
            case "USE":
                if (npc.getCanBeUsed()) { doUse(npc); }
                else {/*todo: print: npcName + " cannot be used ."*/}
                break;
            case "EAT":
            case "DRINK":
            case "CONSUME":
                if (npc.getCanBeConsumed()) { doConsume(npc); }
                else {/*todo: print: "Cannot consume * + npcName + "."*/}
                break;
            case "OPEN":
                if (npc.getCanBeOpened()) { doOpen(npc); }
                else { /*todo: print: itemName + " cannot be opened."*/}
                break;
            case "CLOSE":
                if (npc.getCanBeClosed()) { doClose(npc); }
                else { /*todo: print: itemName + " cannot be closed."*/}
                break;
            case "CUT":
                cutNPCCommand(npc);
                break;
            default:
                //todo: print: "Cannot do that."
        }
    }

    private static void cutNPCCommand(NPC npc){
        ArrayList<Item> itemsInInventory = CollectionOfAllClasses.getInventory().getItemsInInventory();

        if (npc.getCanBeCut()){
            for (Item itemInInventory : itemsInInventory){
                if (npc.getItemToCutWith().equals(itemInInventory)){
                    doCutWith(npc, itemInInventory);
                }
            }
            //todo: else give message that user doesn't have the right item to cut?
        }
        else{
            //todo: print: item.getName() + " cannot be cut."
        }
    }

    private static void validateAndHandleCommandAndDirectionCombination(String command, String direction){
        switch (command){
            case "RUN":
            case "GO":
            case "WALK":
            case "MOVE":
                handle1Direction(direction);
                break;
            default:
                //todo: print: "Cannot " + command + " to " + direction + "."
        }
    }
}