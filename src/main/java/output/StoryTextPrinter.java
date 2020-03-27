package output;

import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import javafx.scene.control.TextArea;

public class StoryTextPrinter {
    public static void printStory(TextArea terminal) {
        PlayerStats player = InitOfClassesThroughSaveFile.getPlayerStats();
        String description = player.getCurrentLocation().getDescription();

        terminal.appendText("Printing description of current room!\n" + description);

//        ArrayList<String> currentTextList = CollectionOfAllClasses.getStoryTextGetter().compileStoryText();
//
//        for (String text: currentTextList){
//            terminal.appendText(text);
//        }
    }
}
