package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.Location;
import gameElements.levelAndContents.npc.NPC;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

import java.util.ArrayList;
import java.util.HashMap;

import static input.commands.DoAttack.doAttack;
import static input.commands.DoBreak.doBreakWithoutItem;
import static input.commands.DoClose.doClose;
import static input.commands.DoConsume.doConsume;
import static input.commands.DoCut.doCutItemWithItem;
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

        if (validInputList.containsValue("item") && validInputList.containsValue("npc")) {
            assert npc != null;
            validateAndHandleItemAndNPCCombination(item, npc);
        }
        else if (validInputList.containsValue("command") && validInputList.containsValue("item")){
            assert command != null;
            validateAndHandleCommandAndItemCombination(command, item);
        }
        else if (validInputList.containsValue("command") && validInputList.containsValue("npc")){
            assert command != null;
            validateAndHandleCommandAndNPCCombination(command, npc);
        }
        else if (validInputList.containsValue("direction") && validInputList.containsValue("command")){
            assert command != null;
            validateAndHandleCommandAndDirectionCombination(command, direction);
        }
        else {
            NonStoryPrinter.print("Unrecognized input. Try in the form [command] (+ [thing] ( + [thing] ) )");
        }
    }

    private static void validateAndHandleItemAndNPCCombination(Item item, NPC npc){
        if (npc.getItemToBeUsedOn() == null){
            NonStoryPrinter.print(npc.getName() + " does not need " + item.getName() + ".");
        }
        else if(npc.getItemToGive().equals(item)){
            if(item.getCanBeGiven()){
                doGiveItemToNPC(item, npc);
            }
            else if (item.getCanBeUsedOnNPC()){
                doUseItemOnNPC(item, npc);
            }
        }
        else { NonStoryPrinter.print("Wrong item for " + npc.getName() + "."); }

        Location currentLocation = InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation();
        ArrayList<Item> itemsInLocation = currentLocation.getListOfItems();
        for (Item itemInLocation : itemsInLocation){
            if (itemInLocation.equals(item)){
                NonStoryPrinter.print("Cannot do that. Maybe try to pick " + item.getName() + " up first?");
            }
        }
    }

    private static void validateAndHandleCommandAndItemCombination(String command, Item item){
        switch (command){
            case "USE":
                if (item.getCanBeUsed()) { doUse(item); }
                else { NonStoryPrinter.print("Cannot use " + item.getName() + "."); }
                break;
            case "EAT":
            case "DRINK":
            case "CONSUME":
                if (item.getCanBeConsumed()){ doConsume(item); }
                else { NonStoryPrinter.print("Cannot consume " + item.getName() + "."); }
                break;
            case "TAKE":
            case "PICK":
            case "GRAB":
            case "GET":
            case "PICKUP":
                if (item.getCanBePickedUp()){ doPickUp(item); }
                else { NonStoryPrinter.print("Cannot pick up " + item.getName() + "."); }
                break;
            case "DROP":
                if (item.getCanBeDropped()) { doDrop(item); }
                else { NonStoryPrinter.print("Cannot drop " + item.getName() + "."); }
                break;
            case "READ":
                if (item.getCanBeRead()) { doRead(item); }
                else { NonStoryPrinter.print("Cannot read " + item.getName() + "."); }
                break;
            case "LOOK":
            case "OBSERVE":
            case "EXAMINE":
                if (item.getCanBeExamined()) { doExamine(item); }
                else { NonStoryPrinter.print("Cannot examine " + item.getName() + "."); }
                break;
            case "SMELL":
                if (item.getCanBeSmelled()) { doSmell(item); }
                else { NonStoryPrinter.print(item.getName() + " does not have a particular smell."); }
                break;
            case "PUSH":
                if (item.getCanBePushed()) { doPush(item); }
                else { NonStoryPrinter.print("Cannot push " + item.getName() + "."); }
                break;
            case "PULL":
                if (item.getCanBePulled()) { doPull(item); }
                else { NonStoryPrinter.print("Cannot pull " + item.getName() + "."); }
                break;
            case "LISTEN":
                if (item.getCanBeListenedTo()) { doListenTo(item); }
                else { NonStoryPrinter.print("Nothing in particular is heard, when listening to "
                        + item.getName() + "."); }
                break;
            case "TALK":
                if (item.getCanBeTalkedWith()) { doTalkWith(item); }
                else { NonStoryPrinter.print(item.getName() + " cannot be talked to."); }
                break;
            case "OPEN":
                if (item.getCanBeOpened()) { doOpen(item); }
                else { NonStoryPrinter.print(item.getName() + " cannot be opened."); }
                break;
            case "CLOSE":
                if (item.getCanBeClosed()) { doClose(item); }
                else { NonStoryPrinter.print(item.getName() + " cannot be closed."); }
                break;
            case "CUT":
                cutItemCommand(item);
                break;
            case "ATTACK":
                if (item.getCanBeAttacked()) { doAttack(item); }
                else { NonStoryPrinter.print(item.getName() + " cannot be attacked."); }
                break;
            case "BREAK":
                if (item.getCanBeBrokenWithoutItem()) { doBreakWithoutItem(item); }
                else { NonStoryPrinter.print(item.getName() + " cannot be broken. " +
                        "It might be possible to break, with another item. "); }
                break;
            default:
                NonStoryPrinter.print( "Cannot use [" + command.toLowerCase() + "] this way. Try [help]." );
        }
    }

    private static void cutItemCommand(Item item){
        ArrayList<Item> itemsInInventory = InitOfClassesThroughSaveFile.getInventory().getListOfItems();
        boolean check = false;

        if (item.getCanBeCut()){
            for (Item itemInInventory : itemsInInventory){
                if (item.getItemToCutWith().equals(itemInInventory)){
                    doCutItemWithItem(item, itemInInventory);
                    check = true ;
                }
            }
            if (!check){
                NonStoryPrinter.print("Don't have the right item to cut " + item.getName() + " with.");
            }
        }
        else{
            NonStoryPrinter.print(item.getName() + " cannot be cut.");
        }
    }

    private static void validateAndHandleCommandAndNPCCombination(String command, NPC npc) {
        switch (command) {
            case "LISTEN":
                if (npc.getCanBeListenedTo()) { doListenTo(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be listened to."); }
                break;
            case "TALK":
                if (npc.getCanBeTalkedWith()) { doTalkWith(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be talked to."); }
                break;
            case "ATTACK":
                if (npc.getCanBeAttacked()) { doAttack(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be attacked."); }
                break;
            case "SMELL":
                if (npc.getCanBeSmelled()) { doSmell(npc); }
                else { NonStoryPrinter.print(npc.getName() + " does not have a particular smell."); }
                break;
            case "PUSH":
                if (npc.getCanBePushed()) { doPush(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be pushed."); }
                break;
            case "PULL":
                if (npc.getCanBePulled()) { doPull(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be pulled."); }
                break;
            case "OBSERVE":
            case "EXAMINE":
                if (npc.getCanBeExamined()) { doExamine(npc); }
                else { NonStoryPrinter.print("Cannot examine " + npc.getName() + "."); }
                break;
            case "USE":
                if (npc.getCanBeUsed()) { doUse(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be used."); }
                break;
            case "EAT":
            case "DRINK":
            case "CONSUME":
                if (npc.getCanBeConsumed()) { doConsume(npc); }
                else { NonStoryPrinter.print("Cannot " + command.toLowerCase() + " " + npc.getName() + "."); }
                break;
            case "OPEN":
                if (npc.getCanBeOpened()) { doOpen(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be opened."); }
                break;
            case "CLOSE":
                if (npc.getCanBeClosed()) { doClose(npc); }
                else { NonStoryPrinter.print(npc.getName() + " cannot be closed."); }
                break;
            case "CUT":
                cutNPCCommand(npc);
                break;
            default:
                NonStoryPrinter.print("Cannot use [" + command.toLowerCase() + "] with [" + npc.getName() +
                        "] that way. Refer to [help].");
        }
    }

    private static void cutNPCCommand(NPC npc){
        ArrayList<Item> itemsInInventory = InitOfClassesThroughSaveFile.getInventory().getListOfItems();
        boolean check = false;

        if (npc.getCanBeCut()){
            for (Item itemInInventory : itemsInInventory){
                if (npc.getItemToCutWith().equals(itemInInventory)){
                    doCutWith(npc, itemInInventory);
                    check = true;
                }
            }
            if (!check){
                NonStoryPrinter.print("Don't have the right item to cut " + npc.getName() + " with.");
            }
        }
        else{
            NonStoryPrinter.print(npc.getName() + " cannot be cut.");
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
                NonStoryPrinter.print("Cannot " + command.toLowerCase() + " to " + direction.toLowerCase() + ".");
        }
    }
}