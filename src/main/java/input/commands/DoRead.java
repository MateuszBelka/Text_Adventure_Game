package input.commands;

import gameElements.levelAndContents.Item;
import output.NonStoryPrinter;

public class DoRead {
    public static void doRead(Item item) {
        NonStoryPrinter.print(item.getTextForReading());
    }
}
