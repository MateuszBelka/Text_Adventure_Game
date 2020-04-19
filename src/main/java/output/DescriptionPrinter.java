package output;

import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class DescriptionPrinter {
    public static void printStory(TextArea terminal) {
        ArrayList<String> currentTextList = DescriptionGetter.compileStoryText();

        for (String text: currentTextList){
            terminal.appendText(text + "\n");
        }
    }
}
