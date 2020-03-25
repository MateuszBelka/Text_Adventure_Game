package output;

import javafx.scene.control.TextArea;

public class StoryTextPrinter {
    public static void printStory(TextArea terminal) {

        terminal.appendText("A temporary new line of text has been added!\n");

//        ArrayList<String> currentTextList = CollectionOfAllClasses.getStoryTextGetter().compileStoryText();
//
//        for (String text: currentTextList){
//            terminal.appendText(text);
//        }
    }
}
