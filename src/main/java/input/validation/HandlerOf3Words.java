package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.npc.NPC;
import output.NonStoryPrinter;

import java.util.HashMap;

import static input.commands.DoBreak.doBreakWithItem;
import static input.commands.DoClose.doCloseItemWithItem;
import static input.commands.DoCut.doCutItemWithItem;
import static input.commands.DoGiveItemToNPC.doGiveItemToNPC;
import static input.commands.DoListen.doListenToItemWithItem;
import static input.commands.DoListen.doListenToNPCWithItem;
import static input.commands.DoOpen.doOpenItemWithItem;
import static input.commands.DoUnlock.doUnlockItemWithItem;
import static input.commands.DoUse.doUseItemOnItem;
import static input.commands.DoUse.doUseItemOnNPC;
import static input.validation.InputValidation.*;

public class HandlerOf3Words {
    protected static void validateAndHandle3Words(HashMap<String, String> validInputList){
        System.out.println(validInputList);
        Item item0 = getItem(validInputList);
        validInputList.remove(item0.getName().toUpperCase());
        Item item1 = getItem(validInputList);
        String command = getCommand(validInputList);
        NPC npc = getNPC(validInputList);

        if (item1!=null){
            Item item3 = item1;
            item1 = item0;
            item0 = item3;
        }

        if ( (command != null) && (npc != null) ) {
            validateAndHandleCommandItemNpcCombination(command, item0, npc);
        }
        else if ( (item1 != null) && (command != null) ){
            validateAndHandleCommandItemItemCombination(command, item0, item1);
        }
        else { NonStoryPrinter.print("Input invalid. Try [command] (+ [thing] (+ [thing] ) ). See [help]."); }
    }

    private static void validateAndHandleCommandItemNpcCombination(String command, Item item, NPC npc){
        switch (command){
            case "GIVE":
                if (item.getCanBeGiven()) {
                    if (npc.getItemToGive().equals(item)) { doGiveItemToNPC(item, npc); }
                    else { NonStoryPrinter.print(npc.getName() + " does not need " + item.getName() + "."); }
                }
                else {NonStoryPrinter.print(item.getName() + " cannot be given away.");}
                break;
            case "USE":
                if (npc.getCanBeUsedByItem() && item.getCanBeUsedOnNPC()){
                    doUseItemOnNPC(item, npc);
                }
                else{ NonStoryPrinter.print(item.getName() + " cannot be used on " + npc.getName() + ".");
                }
                break;
            case "LISTEN":
                if (npc.getCanBeListenedTo() && item.getCanBeListenedWith() && npc.getItemToListenWith().equals(item)){
                    doListenToNPCWithItem(npc, item);
                }
                else { NonStoryPrinter.print("Cannot listen to "+ npc.getName()+ " with " + item.getName() + "."); }
                break;
            default:
                NonStoryPrinter.print("Can only give item, use item on, or listen with item, to NPCs. " +
                        "Try something else.");
        }
    }

    private static void validateAndHandleCommandItemItemCombination(String command, Item item1, Item item2) {
        switch (command) {
            case "BREAK":
                if (item1.getCanBreak() && item2.getCanBeBrokenWithItem() && item2.getItemToBreakWith().equals(item1)){
                    doBreakWithItem(item1, item2);
                }
                else { NonStoryPrinter.print("Not the right item to break " + item2.getName() + " with."); }
                break;
            case "USE":
                if(item1.getCanBeUsedByItem() && item2.getCanBeUsedOnItem() && item2.getItemToBeUsedOn().equals(item1)){
                    doUseItemOnItem(item1, item2);
                }
                else { NonStoryPrinter.print("Not the right item to use on " + item2.getName() + "."); }
                break;
            case "CUT":
                if (item1.getItemToCutWith().equals(item2)) {
                    doCutItemWithItem(item1, item2);
                }
                else { NonStoryPrinter.print("Cannot cut " + item2.getName() + " with " + item1.getName() + "."); }
                break;
            case "UNLOCK":
                if (item1.getItemToUnlock().equals(item2) && item1.getCanBeUnlockedByItem()) {
                    doUnlockItemWithItem(item1, item2);
                }
                else { NonStoryPrinter.print(item2.getName() + " cannot be unlocked with " + item1.getName() + "."); }
                break;
            case "OPEN":
                if (item1.getItemToOpenWith().equals(item2)) { doOpenItemWithItem(item1, item2); }
                else { NonStoryPrinter.print("Wrong item to open" + item2.getName() + " with."); }
                break;
            case "CLOSE":
                if (item1.getItemToCloseWith().equals(item2)) { doCloseItemWithItem(item1, item2); }
                else { NonStoryPrinter.print(item1.getName() + " doesn't close " + item2.getName() + "."); }
                break;
            case "LISTEN":
                if (item1.getItemToListenWith().equals(item2)) {
                    doListenToItemWithItem(item1, item2);
                }
                break;
            default:
                NonStoryPrinter.print("Cannot use " + command.toLowerCase() + " this way. Try [help].");
        }
    }
}