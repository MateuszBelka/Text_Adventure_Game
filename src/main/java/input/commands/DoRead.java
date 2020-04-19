package input.commands;

import gameElements.levelAndContents.Item;
import output.InteractionPrinter;

public class DoRead {
    public static void doRead(Item item) {
        InteractionPrinter.print( item.getDescriptionOfCommand("read") );
    }

    private DoRead(){} //hiding the implicit public constructor
}
