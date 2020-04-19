package input.commands;

import gameElements.levelAndContents.Location;
import initialisation.InitOfClassesThroughSaveFile;
import output.InteractionPrinter;

import java.util.HashMap;
import java.util.Set;

public class DoGetDirections {
    public static void doGetDirections(){
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

        InteractionPrinter.print(directionsToPrint);
    }
}
