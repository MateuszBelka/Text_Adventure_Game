package input.validation;

import gameElements.levelAndContents.Item;
import gameElements.levelAndContents.NPC;
import gameElements.player.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

import static input.validation.HandlerOf1Word.validateAndHandle1Word;
import static input.validation.HandlerOf2Words.validateAndHandle2Words;
import static input.validation.HandlerOf3Words.*;

public class InputValidation {

    public static void temporaryInputReceiver(String input, Player player) {
        //Placeholder method
    }

    public void inputValidator(HashMap<String, String> validInputList){
        int listSize = validInputList.size();

        switch (listSize){
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
                {/* todo: print "try using less words" */}
        }
    }

    protected static String getKeyInValidInputList(HashMap<String, String> validInputList, String value){
        HashSet<String> keys = new HashSet<>();
        for (Map.Entry<String, String> entry : validInputList.entrySet()){
            if (Objects.equals(value, entry.getValue())){
                keys.add(entry.getKey());
                return deleteFirstAndLastChar(keys.toString());
            }
        }
        return "";
    }

    private static String deleteFirstAndLastChar(String value){
        StringBuilder stringBuilder = new StringBuilder(value);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    protected static Item getItem(HashMap<String, String> validInputList){
        if (validInputList.containsKey("item")){
            String itemName = getKeyInValidInputList(validInputList, "item");
            return Item.getItemByName(itemName);
        }
        else return null;
    }

    protected static String getCommand(HashMap<String, String> validInputList){
        if (validInputList.containsKey("command")){
            return getKeyInValidInputList(validInputList, "command");
        }
        else return null;
    }

    protected static NPC getNPC(HashMap<String, String> validInputList){
        if (validInputList.containsKey("npc")){
            String npcName = getKeyInValidInputList(validInputList, "npc");
            return NPC.getNPCByName(npcName);
        }
        else return null;
    }

    protected static String getDirection(HashMap<String, String> validInputList){
        if (validInputList.containsKey("direction")){
            return getKeyInValidInputList(validInputList, "direction");
        }
        else return null;
    }


}
