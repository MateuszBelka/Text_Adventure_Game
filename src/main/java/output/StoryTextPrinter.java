package output;

import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class StoryTextPrinter {
    public static void printStory(TextArea terminal) {
        ArrayList<String> currentTextList = StoryTextGetter.compileStoryText();

        for (String text: currentTextList){
            terminal.appendText(text);
        }
    }
}
