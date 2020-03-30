package input.commands;

import input.validation.Commands;
import output.NonStoryPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoHelp {
    //todo: help should give not only a list of commands, but also how to use them.
    public static void doHelp () {

        String helpText = "";
        StringBuilder stringBuilder = new StringBuilder(helpText);
        stringBuilder.append("_____________________________________________________________\n\n");
        stringBuilder.append("Overview of commands and syntax :\n");
        stringBuilder.append("[attack] [item]\n");
        stringBuilder.append("[attack] [npc]\n");
        stringBuilder.append("[back] or [backtrack]\n");
        stringBuilder.append("[break] [item] \n");
        stringBuilder.append("[break] [item] with [item] \n");
        stringBuilder.append("([consume] or [eat] or [drink]) [item]\n");
        stringBuilder.append("([consume] or [eat] or [drink]) [npc]\n");
        stringBuilder.append("[close] [item] with [item]\n");
        stringBuilder.append("[close] [item]\n");
        stringBuilder.append("[close] [npc]\n");
        stringBuilder.append("[consume] [npc]\n");
        stringBuilder.append("[cut] [item] with [item]\n");
        stringBuilder.append("[cut] [item]\n");
        stringBuilder.append("[cut] [npc] with [item]\n");
        stringBuilder.append("[cut] [npc]\n");
        stringBuilder.append("[drop] [item]\n");
        stringBuilder.append("[examine] [item]\n");
        stringBuilder.append("[examine] [npc]\n");
        stringBuilder.append("[give] [item] to [npc] \n");
        stringBuilder.append("[help]\n");
        stringBuilder.append("[inventory]\n");
        stringBuilder.append("[jump]\n");
        stringBuilder.append("[listen] to [item] with [item]\n");
        stringBuilder.append("[listen] to [item]\n");
        stringBuilder.append("[listen] to [npc] with [item]\n");
        stringBuilder.append("[listen] to [npc]\n");
        stringBuilder.append("[listen]\n");
        stringBuilder.append("[load]\n");
        stringBuilder.append("[look]\n");
        stringBuilder.append("([move] or [run] or [walk] or [go]) to a [direction]\n");
        stringBuilder.append("[open] [item] with [item]\n");
        stringBuilder.append("[open] [item]\n");
        stringBuilder.append("[open] [npc]\n");
        stringBuilder.append("([pick] or [pickup] or [take] or [grab] or [get]) [item]\n");
        stringBuilder.append("[pull] [item]\n");
        stringBuilder.append("[pull] [npc]\n");
        stringBuilder.append("[push] [item]\n");
        stringBuilder.append("[push] [npc]\n");
        stringBuilder.append("[quit] or [exit]\n");
        stringBuilder.append("[read] [item]\n");
        stringBuilder.append("[save]\n");
        stringBuilder.append("[smell] [item]\n");
        stringBuilder.append("[smell] [npc]\n");
        stringBuilder.append("[smell]\n");
        stringBuilder.append("[talk] with [item]\n");
        stringBuilder.append("[talk] with [npc]\n");
        stringBuilder.append("[unlock] [item] with [item]\n");
        stringBuilder.append("[use] [character] \n");
        stringBuilder.append("[use] [item] \n");
        stringBuilder.append("[use] [item] on [character] \n");
        stringBuilder.append("[use] [item] on [item] \n");

        stringBuilder.append("_____________________________________________________________\n");
        stringBuilder.append("\nShortcut commands :\n");
        stringBuilder.append("[item] : Picks up if not in inventory, consumes if in inventory\n");
        stringBuilder.append("[npc] : Talks with npc\n");
        stringBuilder.append("[direction] : moves to direction\n");
        stringBuilder.append("_____________________________________________________________\n");


        helpText = stringBuilder.toString();


//        List<String> listOfCommands = Stream.of(Commands.values())
//                .map(Enum::name)
//                .collect(Collectors.toList());
//        StringBuilder listOfCommandsOneLine = new StringBuilder();
//
//        for(String command : listOfCommands) {
//            listOfCommandsOneLine.append(command).append(", ");
//        }
//
        NonStoryPrinter.print(helpText);
    }

    private DoHelp(){} //hiding the implicit public constructor
}
