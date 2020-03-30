package input.commands;

import output.NonStoryPrinter;

public class DoHelp {
    public static void doHelp () {
        //prints an overview of the commands and the syntax to use them.

         String helpText = "_____________________________________________________________\n" +
                "\nOverview of commands and syntax :\n" +
                "[attack] [item]\n" +
                "[attack] [npc]\n" +
                "[back] or [backtrack]\n" +
                "[break] [item] \n" +
                "[break] [item] with [item] \n" +
                "( [consume] or [eat] or [drink] ) [item]\n" +
                "( [consume] or [eat] or [drink] ) [npc]\n" +
                "[close] [item] with [item]\n" +
                "[close] [item]\n" +
                "[close] [npc]\n" +
                "[consume] [npc]\n" +
                "[cut] [item] with [item]\n" +
                "[cut] [item]\n" +
                "[cut] [npc] with [item]\n" +
                "[cut] [npc]\n" +
                "[drop] [item]\n" +
                "[examine] [item]\n" +
                "[examine] [npc]\n" +
                "[give] [item] to [npc] \n" +
                "[help]\n" +
                "[inventory]\n" +
                "[jump]\n" +
                "[listen] to [item] with [item]\n" +
                "[listen] to [item]\n" +
                "[listen] to [npc] with [item]\n" +
                "[listen] to [npc]\n" +
                "[listen]\n" +
                "[load]\n" +
                "[look]\n" +
                "( [move] or [run] or [walk] or [go] ) to a [direction]\n" +
                "[open] [item] with [item]\n" +
                "[open] [item]\n" +
                "[open] [npc]\n" +
                "( [pick] or [pickup] or [take] or [grab] or [get] ) [item]\n" +
                "[pull] [item]\n" +
                "[pull] [npc]\n" +
                "[push] [item]\n" +
                "[push] [npc]\n" +
                "[quit] or [exit]\n" +
                "[read] [item]\n" +
                "[save]\n" +
                "[smell] [item]\n" +
                "[smell] [npc]\n" +
                "[smell]\n" +
                "[talk] with [item]\n" +
                "[talk] with [npc]\n" +
                "[unlock] [item] with [item]\n" +
                "[use] [character] \n" +
                "[use] [item] \n" +
                "[use] [item] on [character] \n" +
                "[use] [item] on [item] \n" +
                "_____________________________________________________________\n" +
                "\nShortcut commands :\n" +
                "[item] : Picks up if not in inventory, consumes if in inventory\n" +
                "[npc] : Talks with npc\n" +
                "[direction] : moves to direction\n" +
                "_____________________________________________________________\n";

        NonStoryPrinter.print(helpText);
    }

    private DoHelp(){} //hiding the implicit public constructor
}
