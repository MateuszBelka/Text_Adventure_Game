package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;

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
        Item item1 = getItem(validInputList);
        validInputList.remove(item1, "item");
        Item item2 = getItem(validInputList);
        String command = getCommand(validInputList);
        validInputList.remove(command, "command");
        NPC npc = getNPC(validInputList);

        if (    validInputList.containsValue("command") &&
                validInputList.containsValue("item")    &&
                validInputList.containsValue("npc") ) {
            validateAndHandleCommandItemNpcCombination(command, item1, npc);
        }

        else if (item2 != null){
            if (validInputList.containsValue("item") && validInputList.containsValue("command")){
                validateAndHandleCommandItemItemCombination(command, item1, item2);
            }
        }
        else {
            /*todo: print "Input invalid". Try [command] + [thing] + [thing] .*/
        }
    }

    private static void validateAndHandleCommandItemNpcCombination(String command, Item item, NPC npc){
        switch (command){
            case "GIVE":
                if (item.getCanBeGiven() && npc.getNeedsItem() && npc.getItemToGive().equals(item)){
                    doGiveItemToNPC(item, npc);
                }
                break;
            case "USE":
                if (npc.getCanBeUsedByItem() && item.getCanBeUsedOnNPC()){
                    doUseItemOnNPC(item, npc);
                }
                break;
            case "LISTEN":
                if (npc.getCanBeListenedTo() && item.getCanBeListenedWith() && npc.getItemToListenWith().equals(item)){
                    doListenToNPCWithItem(npc, item);
                }
                break;
            default:
                //todo: print: "Cannot do that."
        }
    }

    private static void validateAndHandleCommandItemItemCombination(String command, Item item1, Item item2) {
        switch (command) {
            case "BREAK":
                if (item1.getCanBreak() && item2.getCanBeBrokenWithItem() && item2.getItemToBreakWith().equals(item1)) {
                    doBreakWithItem(item1, item2);
                } else {/*"todo: print: Not the right item to break item2.getName() with*/}
                break;
            case "USE":
                if (item1.getCanBeUsedByItem() && item2.getCanBeUsedOnItem() && item2.getItemToBeUsedOn().equals(item1)) {
                    doUseItemOnItem(item1, item2);
                } else {
                    //todo:print: Not the right item to use on item2.getName().
                }
                break;
            case "CUT":
                if (item1.getCanBeCutWith().equals(item2)) {
                    doCutItemWithItem(item1, item2);
                } else {
                    //todo: print: Cannot cut item2.getName() with item1.getName().
                }
                break;
            case "UNLOCK":
                if (item1.getItemToUnlock().equals(item2) && item1.getCanBeUnlockedByItem()) {
                    doUnlockItemWithItem(item1, item2);
                } else {
                    //todo: print: item2.getName() cannot be unlocked with item1.getName();
                }
                break;
            case "OPEN":
                if (item1.getItemToOpenWith().equals(item2)) {
                    doOpenItemWithItem(item1, item2);
                } else {
                    //todo: print: wrong item to open with.
                }
                break;
            case "CLOSE":
                if (item1.getItemToCloseWith().equals(item2)) {
                    doCloseItemWithItem(item1, item2);
                } else {
                    //todo: print: item2.getName() doesn't close item1.getName().
                }
                break;
            case "LISTEN":
                if (item1.getItemToListenWith().equals(item2)) {
                    doListenToItemWithItem(item1, item2);
                }
                break;
            default:
                //todo:print: Cannot do that.
        }
    }
}