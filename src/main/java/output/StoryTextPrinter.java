package output;

import gameElements.player.PlayerStats;
import initialisation.InitOfClassesThroughSaveFile;
import initialisation.InitOfStoryIndependentClasses;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class StoryTextPrinter {
    public static void printStory(TextArea terminal) {
        ArrayList<String> currentTextList = InitOfStoryIndependentClasses.getStoryTextGetter().compileStoryText();

        for (String text: currentTextList){
            terminal.appendText(text);
        }
    }
}
