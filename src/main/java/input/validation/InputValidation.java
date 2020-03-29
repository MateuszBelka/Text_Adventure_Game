package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.PlayerStats;
import output.NonStoryPrinter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

import static input.validation.HandlerOf1Word.validateAndHandle1Word;
import static input.validation.HandlerOf2Words.validateAndHandle2Words;
import static input.validation.HandlerOf3Words.*;

public class InputValidation {

    public static void inputValidator(HashMap<String, String> validInputList){
        int listSize = validInputList.size();

        switch (listSize){
            case 0:
                NonStoryPrinter.print("No valid input detected.");
                break;
            case 1:
                validateAndHandle1Word(validInputList);
                break;
            case 2:
                validateAndHandle2Words(validInputList);
                break;
            case 3:
                validateAndHandle3Words(validInputList);
                break;
            default:
                NonStoryPrinter.print("Try using less words.\n");
        }
    }

    protected static String getKeyInValidInputList(HashMap<String, String> validInputList, String value){
        HashSet<String> key = new HashSet<>();
        for (Map.Entry<String, String> entry : validInputList.entrySet()){
            if (Objects.equals(value, entry.getValue())){
                key.add(entry.getKey());
            }
        }
        return deleteFirstAndLastChar(key.toString());
    }

    private static String deleteFirstAndLastChar(String value){
        StringBuilder stringBuilder = new StringBuilder(value);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    protected static Item getItem(HashMap<String, String> validInputList){
        String itemName = null;
        if (validInputList.containsValue("item")){
            itemName = getKeyInValidInputList(validInputList, "item");
            if (itemName.contains(",")){
                StringBuilder stringBuilder = new StringBuilder(itemName);
                int index= stringBuilder.indexOf(",");
                itemName = stringBuilder.substring(0, index);
            }
        }
        return Item.getItemByName(itemName);
    }

    protected static String getCommand(HashMap<String, String> validInputList){
        if (validInputList.containsValue("command")){
            return getKeyInValidInputList(validInputList, "command");
        }
        else return null;
    }

    protected static NPC getNPC(HashMap<String, String> validInputList){
        if (validInputList.containsValue("npc")){
            String npcName = getKeyInValidInputList(validInputList, "npc");
            return NPC.getNPCByName(npcName);
        }
        else return null;
    }

    protected static String getDirection(HashMap<String, String> validInputList){
        if (validInputList.containsValue("direction")){
            return getKeyInValidInputList(validInputList, "direction");
        }
        else return null;
    }


}
