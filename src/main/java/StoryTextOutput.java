import org.beryx.textio.TextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;

import java.util.ArrayList;

public class StoryTextOutput {
    //Attributes
    private final ArrayList<String> storyText = new ArrayList<>();

    //Setter Methods to manipulate attribute
    public void addLineToStoryText(String text){ storyText.add(text);}

    public void resetStoryText(){storyText.clear();}

    public void loadTextForStartOfLevel(Player player){
        //This method adds (Level, Room, StaticItems, PickupableItems) to attribute.
        //Method only runs when enterLevel in Level class is true. It is true once, and then is switched false.
        //Thus, this text list (Level, Room, StaticItems, PickupableItems) will be printed once, on entry to Level.
        resetStoryText();
        addLineToStoryText(player.getCurrentLevel().getTextAboutLevel());
        loadTextForRoomAndItems(player);
    }

    public void loadTextForRoomAndItems(Player player){
        //Runs when enterLevel in player's current level is false. (Player enters level only once.)
        //Adds (Room, StaticItem, PickupableItem) texts to attribute.
        addLineToStoryText(player.getCurrentRoom().getTextAboutRoom());
        for (StaticItem sItem : player.getCurrentRoom().getListOfStaticItems()) {
            addLineToStoryText(sItem.getTextAboutThisItem());
        }
        for (PickupableItem pItem : player.getCurrentRoom().getListOfPickupableItems()) {
            addLineToStoryText(pItem.getTextAboutThisItem());
        }
    }

    //Main Method
    public void setAndPrintAndClearStoryText(Player player, TextTerminal<SwingTextTerminal> terminal){
        //Sets the strings to the arraylist (according to enterLevel attribute of player's current level),
        //Prints arraylist,
        //Clears arraylist.
        if (player.getCurrentLevel().switchEnterLevel()){ loadTextForStartOfLevel(player); }
        else loadTextForRoomAndItems(player);

        for(String line : storyText){ terminal.printf("%s\n", line); }

        resetStoryText();
    }
}
