import org.beryx.textio.TextTerminal;
import org.beryx.textio.swing.SwingTextTerminal;

import java.util.ArrayList;

public class StoryTextOutput {
    private final ArrayList<String> storyText = new ArrayList<>();

    public void addLineToStoryText(String text){ storyText.add(text);}

    public void printStoryText(Player player, TextTerminal<SwingTextTerminal> terminal){
        if (player.getCurrentLevel().switchEnterLevel()){
            loadTextForStartOfLevel(player);
        }
        else loadTextForRoomAndItems(player);
        for(String line : storyText){
            terminal.printf("%s\n", line);
        }
        resetStoryText();
    }

    public void resetStoryText(){storyText.clear();}

    public void loadTextForStartOfLevel(Player player){
        resetStoryText();
        addLineToStoryText(player.getCurrentLevel().getTextAboutLevel());
        loadTextForRoomAndItems(player);
    }

    public void loadTextForRoomAndItems(Player player){
        addLineToStoryText(player.getCurrentRoom().getTextAboutRoom());
        for (StaticItem sItem : player.getCurrentRoom().getListOfStaticItems()) {
            addLineToStoryText(sItem.getTextAboutThisItem());
        }
        for (PickupableItem pItem : player.getCurrentRoom().getListOfPickupableItems()) {
            addLineToStoryText(pItem.getTextAboutThisItem());
        }
    }
}
