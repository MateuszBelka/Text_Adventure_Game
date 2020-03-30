package input.commands;

import input.validation.Commands;
import output.NonStoryPrinter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoHelp {
    //todo: help should give not only a list of commands, but also how to use them.
    public static void doHelp () {
        NonStoryPrinter.print("The following commands are available to you:");

        List<String> listOfCommands = Stream.of(Commands.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        StringBuilder listOfCommandsOneLine = new StringBuilder();

        for(String command : listOfCommands) {
            listOfCommandsOneLine.append(command).append(", ");
        }

        NonStoryPrinter.print(listOfCommandsOneLine.toString());
    }

    private DoHelp(){} //hiding the implicit public constructor
}
