package input.commands;

import gameElements.levelAndContents.Location;
import initialisation.InitOfClassesThroughSaveFile;
import output.NonStoryPrinter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class DoDirections {
    //todo: rename class and method to "doGetDirections", adjust in Handlerof1word
    public static void doDirections(){
        //prints the possible directions to go to, from current location

        Location currentLocation = InitOfClassesThroughSaveFile.getPlayerStats().getCurrentLocation();
        HashMap<String, Location> locations = currentLocation.getListOfConnectedLocations();

        Set<String> directions = locations.keySet();
        String directionsToPrint = "";
        StringBuilder stringBuilder = new StringBuilder(directionsToPrint);

        for (String direction : directions) {
            stringBuilder.append("[" + direction + "] ");
        }
        directionsToPrint = stringBuilder.toString();

        NonStoryPrinter.print(directionsToPrint);
    }
}
